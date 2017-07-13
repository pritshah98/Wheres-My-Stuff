package com.example.seekers.wheresmystuff.Controller;

/**
 * Created by Luke on 7/13/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.seekers.wheresmystuff.R;


public class Tab1Lost extends Fragment {

    private Button lostButton;
    private Button viewLostItems;
    private Button searchLostItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1lost, container, false);
        lostButton = (Button) rootView.findViewById(R.id.lostButton);
        viewLostItems = (Button) rootView.findViewById(R.id.viewLostItems);
        searchLostItems = (Button) rootView.findViewById(R.id.searchLostItemsButton);

        searchLostItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchLostItemsActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        lostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EnterLostItemActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        viewLostItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LostItemsListActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        return rootView;
    }
}


