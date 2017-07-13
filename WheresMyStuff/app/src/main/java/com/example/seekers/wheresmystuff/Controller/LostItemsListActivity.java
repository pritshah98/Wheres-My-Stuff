package com.example.seekers.wheresmystuff.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.seekers.wheresmystuff.Model.LostItem;
import com.example.seekers.wheresmystuff.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * Controller class for when someone would like to view a list of lost
 * items.
 */
public class LostItemsListActivity extends AppCompatActivity {

    private ListView itemsList;
    private ArrayAdapter adapter;
    private Button home;

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_items_list);
        itemsList = (ListView) findViewById(R.id.itemsList);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, WelcomeScreenActivity.lostItemList.getLostItemList());
        itemsList.setAdapter(adapter);
        home = (Button) findViewById(R.id.backToHomeSearch);

        WelcomeScreenActivity.myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                WelcomeScreenActivity.lostItemList.getLostItemList().clear();
                DataSnapshot lostItems = dataSnapshot.child("LostItems");
                Iterable<DataSnapshot> lostChildren = lostItems.getChildren();
                for (DataSnapshot lost: lostChildren) {
                    LostItem l = lost.getValue(LostItem.class);
                    if (l != null) {
                        WelcomeScreenActivity.lostItemList.getLostItemList().add(l);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
