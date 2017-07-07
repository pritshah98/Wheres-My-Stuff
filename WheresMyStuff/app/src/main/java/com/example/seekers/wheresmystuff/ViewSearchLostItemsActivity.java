package com.example.seekers.wheresmystuff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * A controller class that handles when someone would like to view all lost
 * items.
 */
public class ViewSearchLostItemsActivity extends AppCompatActivity {

    private Button back;
    private ArrayAdapter adapter;
    private ListView itemsList;

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_lost_items);

        itemsList = (ListView) findViewById(R.id.lostItemsListSearch);
        back = (Button) findViewById(R.id.backToHomeSearch);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, SearchLostItemsActivity.lostSearch);
        itemsList.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchLostItemsActivity.lostSearch.clear();
                finish();
            }
        });
    }
}
