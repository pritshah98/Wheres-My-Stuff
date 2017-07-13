package com.example.seekers.wheresmystuff.Model;

/**
 * Created by pritshah on 6/22/17.
 */

public class LostItem extends Item {
    private String name;
    private String color;
    private String description;
    private String address;

    public LostItem() {

    }

    /**
     * Constructer for LostItem
     * @param name the name of the LostItem
     * @param color the color of the lostItem
     * @param description the description of the LostItem
     */
    public LostItem(String name, String color, String description, String address) {
        this.name = name;
        this.color = color;
        this.description = description;
        this.address = address;
    }

    /**
     * getter for name variable
     * @return returns name of item
     */
    public String getName() {
        return this.name;
    }

    /**
     * getter for color variable
     * @return returns the name of the color
     */
    public String getColor() {
        return this.color;
    }

    /**
     * getter for description variable
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * getter for address variable
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * overides the tostring method
     * @return a string that properly describes the item
     */
    public String toString() {
        return "Name: " + this.name + " Color: " + this.color + " Description: " + this.description;
    }
}
