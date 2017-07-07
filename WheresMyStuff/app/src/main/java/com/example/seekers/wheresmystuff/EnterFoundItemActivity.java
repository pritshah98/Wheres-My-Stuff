package com.example.seekers.wheresmystuff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class represents the controller to handle when someone has
 * found an item and would like to post it
 */
public class EnterFoundItemActivity extends AppCompatActivity {

    private EditText enterNameOfItem;
    private EditText enterColorOfItem;
    private EditText enterDescriptionOfItem;
    private EditText enterAddressOfItem;
    private Button cancelEnter;
    private Button enterFoundItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_found_item);
        enterNameOfItem = (EditText) findViewById(R.id.enterNameOfItem);
        enterColorOfItem = (EditText) findViewById(R.id.enterColor);
        enterDescriptionOfItem = (EditText) findViewById(R.id.enterFoundItemDescription);
        cancelEnter = (Button) findViewById(R.id.cancelEnterItem);
        enterFoundItem = (Button) findViewById(R.id.enterLostItemButton);
        enterAddressOfItem = (EditText) findViewById(R.id.enterAddressOfItemFound);

        cancelEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        enterFoundItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = enterNameOfItem.getText().toString();
                String color = enterColorOfItem.getText().toString();
                String description = enterDescriptionOfItem.getText().toString();
                String address = enterAddressOfItem.getText().toString();
                FoundItem newFoundItem = new FoundItem(name, color, description, address);
                WelcomeScreenActivity.foundItemList.getFoundItemList().add(newFoundItem);
                WelcomeScreenActivity.myRef.child("FoundItems").child(name + " : " + description).setValue(newFoundItem);
                finish();
            }
        });
    }
}
