package com.example.seekers.wheresmystuff.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.seekers.wheresmystuff.R;

/**
 * Created by Luke on 7/13/2017.
 */

public class Tab2Found extends Fragment {

    private Button foundButton;
    private Button viewFoundItems;
    private Button searchFoundItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2found, container, false);
        foundButton = (Button) rootView.findViewById(R.id.enterFoundItemsButton);
        viewFoundItems = (Button) rootView.findViewById(R.id.viewFoundItems);
        searchFoundItems = (Button) rootView.findViewById(R.id.searchFoundItemsButton);

        searchFoundItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchFoundItemsActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        foundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EnterFoundItemActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        viewFoundItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FoundItemsListActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        return rootView;
    }
}
