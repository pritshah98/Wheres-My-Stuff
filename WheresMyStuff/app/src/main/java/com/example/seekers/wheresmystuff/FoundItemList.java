package com.example.seekers.wheresmystuff;

import java.util.ArrayList;

/**
 * Created by pritshah on 6/24/17.
 */

/**
 * This class represents a list of Found items.
 */
public class FoundItemList {
    private ArrayList<FoundItem> foundItemList;

    /**
     * A constructer for the class
     */
    public FoundItemList() {
        foundItemList = new ArrayList<FoundItem>();
    }

    /**
     * getter for the foundItemlist
     * @return the arraylist foundItemList
     */
    public ArrayList<FoundItem> getFoundItemList() {
        return foundItemList;
    }
}
