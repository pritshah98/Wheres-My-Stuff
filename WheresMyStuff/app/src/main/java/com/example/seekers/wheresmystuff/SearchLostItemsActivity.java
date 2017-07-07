package com.example.seekers.wheresmystuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * A controller class to search through a list of lost items.
 */
public class SearchLostItemsActivity extends AppCompatActivity {

    private Button search;
    private Button back;
    private EditText name;
    private EditText color;
    private EditText description;
    private EditText address;
    public static ArrayList<LostItem> lostSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_lost_items);

        search = (Button) findViewById(R.id.searchButtonLost);
        back = (Button) findViewById(R.id.searchBackButtonLost);
        name = (EditText) findViewById(R.id.enterNameSearch);
        color = (EditText) findViewById(R.id.enterColorSearch);
        description = (EditText) findViewById(R.id.enterDescriptionSearch);
        address = (EditText) findViewById(R.id.searchEnterAddressLost);
        lostSearch = new ArrayList<LostItem>();

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
                ArrayList<LostItem> temp = WelcomeScreenActivity.lostItemList.getLostItemList();
                for (int i = 0; i < temp.size(); i++) {
                    if (itemName.equals(temp.get(i).getName())) {
                        if (!lostSearch.contains(temp.get(i))) {
                            lostSearch.add(temp.get(i));
                        }
                    }
                    if (itemColor.equals(temp.get(i).getColor())) {
                        if (!lostSearch.contains(temp.get(i))) {
                            lostSearch.add(temp.get(i));
                        }
                    }
                    if (itemDescription.equals(temp.get(i).getDescription())) {
                        if (!lostSearch.contains(temp.get(i))) {
                            lostSearch.add(temp.get(i));
                        }
                    }
                    if (itemAddress.equals(temp.get(i).getAddress())) {
                        if (!lostSearch.contains(temp.get(i))) {
                            lostSearch.add(temp.get(i));
                        }
                    }
                }
                Intent intent = new Intent(SearchLostItemsActivity.this, ViewSearchLostItemsActivity.class);
                startActivity(intent);
            }
        });
    }
}
