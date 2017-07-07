package com.example.seekers.wheresmystuff;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pritshah on 6/22/17.
 */

/**
 * The class that represents a list of lost items.
 */
public class LostItemList {
    private ArrayList<LostItem> lostItemList;

    /**
     * Constructer for LostItemList
     */
    public LostItemList() {
        lostItemList = new ArrayList<LostItem>();
    }

    /**
     * getter method for lostItemList
     * @return an arraylist of the lost items.
     */
    public ArrayList<LostItem> getLostItemList() {
        return lostItemList;
    }
}
