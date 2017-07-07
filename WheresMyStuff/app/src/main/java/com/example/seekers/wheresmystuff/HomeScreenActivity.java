package com.example.seekers.wheresmystuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * The controller class that represents the home screen and all the options
 * the application can do.
 */
public class HomeScreenActivity extends AppCompatActivity {

    private Button lostButton;
    private Button viewLostItems;
    private Button logout;
    private Button foundButton;
    private Button viewFoundItems;
    private Button searchLostItems;
    private Button searchFoundItems;
    private Button map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        lostButton = (Button) findViewById(R.id.lostButton);
        viewLostItems = (Button) findViewById(R.id.viewLostItems);
        logout = (Button) findViewById(R.id.logout);
        foundButton = (Button) findViewById(R.id.enterFoundItemsButton);
        viewFoundItems = (Button) findViewById(R.id.viewFoundItems);
        searchLostItems = (Button) findViewById(R.id.searchLostItemsButton);
        searchFoundItems = (Button) findViewById(R.id.searchFoundItemsButton);
        map = (Button) findViewById(R.id.viewMapButton);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        searchFoundItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, SearchFoundItemsActivity.class);
                startActivity(intent);
            }
        });

        searchLostItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, SearchLostItemsActivity.class);
                startActivity(intent);
            }
        });

        lostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, EnterLostItemActivity.class);
                startActivity(intent);
            }
        });

        viewLostItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, LostItemsListActivity.class);
                startActivity(intent);
            }
        });

        foundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, EnterFoundItemActivity.class);
                startActivity(intent);
            }
        });

        viewFoundItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this, FoundItemsListActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
