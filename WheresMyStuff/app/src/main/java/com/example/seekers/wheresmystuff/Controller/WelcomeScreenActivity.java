package com.example.seekers.wheresmystuff.Controller;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.seekers.wheresmystuff.Model.User;
import com.example.seekers.wheresmystuff.Model.Admin;
import com.example.seekers.wheresmystuff.Model.FoundItem;
import com.example.seekers.wheresmystuff.Model.FoundItemList;
import com.example.seekers.wheresmystuff.Model.LostItem;
import com.example.seekers.wheresmystuff.Model.LostItemList;
import com.example.seekers.wheresmystuff.Model.PersonList;
import com.example.seekers.wheresmystuff.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
/**
 * A controller class that handles when the app is initiated.
 */
public class WelcomeScreenActivity extends AppCompatActivity {

    private Button login;
    private Button registration;
    public static PersonList personList;
    public static LostItemList lostItemList;
    public static FoundItemList foundItemList;
    public static FirebaseDatabase database;
    public static DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        login = (Button) findViewById(R.id.login);
        registration = (Button) findViewById(R.id.registration);
        personList = new PersonList();
        lostItemList = new LostItemList();
        foundItemList = new FoundItemList();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataSnapshot admins = dataSnapshot.child("Admins");
                Iterable<DataSnapshot> adminsChildren = admins.getChildren();
                for (DataSnapshot admin: adminsChildren) {
                    Admin a = admin.getValue(Admin.class);
                    if (a != null) {
                        personList.getPersonList().put(a.getUsername(), a);
                    }
                }
                DataSnapshot users = dataSnapshot.child("Users");
                Iterable<DataSnapshot> usersChildren = users.getChildren();
                for (DataSnapshot user: usersChildren) {
                    User u = user.getValue(User.class);
                    if (u != null) {
                        personList.getPersonList().put(u.getUsername(), u);
                    }
                }
                DataSnapshot lostItems = dataSnapshot.child("LostItems");
                Iterable<DataSnapshot> lostChildren = lostItems.getChildren();
                for (DataSnapshot lost: lostChildren) {
                    LostItem l = lost.getValue(LostItem.class);
                    if (l != null) {
                        lostItemList.getLostItemList().add(l);
                    }
                }
                DataSnapshot foundItems = dataSnapshot.child("FoundItems");
                Iterable<DataSnapshot> foundChildren = foundItems.getChildren();
                for (DataSnapshot found: foundChildren) {
                    FoundItem f = found.getValue(FoundItem.class);
                    if (f != null) {
                        foundItemList.getFoundItemList().add(f);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeScreenActivity.this, RegistrationScreenActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeScreenActivity.this, LoginScreenActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
    }
}
