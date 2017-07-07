package com.example.seekers.wheresmystuff;

import java.util.HashMap;

/**
 * This class represents the person list
 * Created by Marcus on 6/20/2017.
 */

public class PersonList {
    private HashMap<String, Person> personList;

    /**
     * Default constructor to initialize the PersonList with an empty HashMap
     */
    public PersonList() {
        personList = new HashMap<String, Person>();
    }

    /**
     * Get the list of people stored in the HashMap
     *
     * @return hashmap of people stored in the list
     */
    public HashMap<String, Person> getPersonList() {
        return personList;
    }
}
