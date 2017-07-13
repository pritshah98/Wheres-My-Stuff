package com.example.seekers.wheresmystuff.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.seekers.wheresmystuff.Model.Admin;
import com.example.seekers.wheresmystuff.Model.FoundItem;
import com.example.seekers.wheresmystuff.Model.LostItem;
import com.example.seekers.wheresmystuff.Model.User;
import com.example.seekers.wheresmystuff.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * The controller class that represents when someone needs to view a list
 * of found items.
 */
public class FoundItemsListActivity extends AppCompatActivity {

    private ListView itemsList;
    private ArrayAdapter adapter;
    private Button home;

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_items_list);
        itemsList = (ListView) findViewById(R.id.itemsList);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, WelcomeScreenActivity.foundItemList.getFoundItemList());
        itemsList.setAdapter(adapter);
        home = (Button) findViewById(R.id.backToHomeSearch);

        WelcomeScreenActivity.myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                WelcomeScreenActivity.foundItemList.getFoundItemList().clear();
                DataSnapshot foundItems = dataSnapshot.child("FoundItems");
                Iterable<DataSnapshot> foundChildren = foundItems.getChildren();
                for (DataSnapshot found: foundChildren) {
                    FoundItem f = found.getValue(FoundItem.class);
                    if (f != null) {
                        WelcomeScreenActivity.foundItemList.getFoundItemList().add(f);

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            }
        });
    }
}
