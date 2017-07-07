package com.example.seekers.wheresmystuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * A controller class to search through a list of found items.
 */
public class SearchFoundItemsActivity extends AppCompatActivity {

    private Button search;
    private Button back;
    private EditText name;
    private EditText color;
    private EditText description;
    private EditText address;
    public static ArrayList<FoundItem> foundSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_found_items);

        search = (Button) findViewById(R.id.searchButtonFound);
        back = (Button) findViewById(R.id.searchBackButtonFound);
        name = (EditText) findViewById(R.id.enterFoundNameSearch);
        color = (EditText) findViewById(R.id.enterFoundColorSearch);
        description = (EditText) findViewById(R.id.enterFoundDescriptionSearch);
        address = (EditText) findViewById(R.id.searchEnterAddressFound);
        foundSearch = new ArrayList<FoundItem>();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = name.getText().toString();
                String itemColor = color.getText().toString();
                String itemDescription = description.getText().toString();
                String itemAddress = address.getText().toString();
                ArrayList<FoundItem> temp = WelcomeScreenActivity.foundItemList.getFoundItemList();
                for (int i = 0; i < temp.size(); i++) {
                    if (itemName.equals(temp.get(i).getName())) {
                        if (!foundSearch.contains(temp.get(i))) {
                            foundSearch.add(temp.get(i));
                        }
                    }
                    if (itemColor.equals(temp.get(i).getColor())) {
                        if (!foundSearch.contains(temp.get(i))) {
                            foundSearch.add(temp.get(i));
                        }
                    }
                    if (itemDescription.equals(temp.get(i).getDescription())) {
                        if (!foundSearch.contains(temp.get(i))) {
                            foundSearch.add(temp.get(i));
                        }
                    }
                    if (itemAddress.equals(temp.get(i).getAddress())) {
                        if (!foundSearch.contains(temp.get(i))) {
                            foundSearch.add(temp.get(i));
                        }
                    }
                }
                Intent intent = new Intent(SearchFoundItemsActivity.this, ViewSearchFoundItemsActivity.class);
                startActivity(intent);
            }
        });
    }
}
