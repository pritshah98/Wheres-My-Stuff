package com.example.seekers.wheresmystuff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * A controller class that handles when a person would like to view all found items.
 */
public class ViewSearchFoundItemsActivity extends AppCompatActivity {

    private Button back;
    private ArrayAdapter adapter;
    private ListView itemsList;

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_found_items);

        itemsList = (ListView) findViewById(R.id.foundItemsListSearch);
        back = (Button) findViewById(R.id.backToHomeSearchFound);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, SearchFoundItemsActivity.foundSearch);
        itemsList.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFoundItemsActivity.foundSearch.clear();
                finish();
            }
        });
    }
}
