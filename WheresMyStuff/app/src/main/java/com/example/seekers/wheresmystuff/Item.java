package com.example.seekers.wheresmystuff;

/**
 * Created by pritshah on 6/24/17.
 */

/**
 * A class that represents an item that has been lost or found.
 */
public abstract class Item {
    /**
     * getter for name variable
     * @return returns name of item
     */
    public abstract String getName();

    /**
     * getter for color variable
     * @return returns the name of the color
     */
    public abstract String getColor();

    /**
     * getter for description variable
     * @return the description
     */
    public abstract String getDescription();

    /**
     * getter for address variable
     * @return the address
     */
    public abstract String getAddress();

    /**
     * overides the tostring method
     * @return a string that properly describes the item
     */
    public abstract String toString();
}
