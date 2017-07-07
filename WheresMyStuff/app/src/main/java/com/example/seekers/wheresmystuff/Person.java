package com.example.seekers.wheresmystuff;

/**
 * Created by Marcus on 6/20/2017.
 */

/**
 * A class that represents a person(user or administrator)
 */
public abstract class Person {
    /**
     * getter method for the name
     * @return the name of the person
     */
    public abstract String getName();

    /**
     * method to check if a User is banned
     */
    public abstract boolean isBanned();

    /**
     * Set account to banned or unbanned
     * @param b true for banned, false for unbanned
     */
    public abstract void setBanned(boolean b);

    /**
     * getter method for the username
     * @return the username of the person
     */
    public abstract String getUsername();

    /**
     * getter method for the AcccountType
     * @return the accounttype for the person
     */
    public abstract String getAccountType();

    /**
     * the getter method for the password
     * @return the password for the person
     */
    public abstract String getPassword();

    /**
     * get number incorrect tries
     * @return number incorrect tries
     */
    public abstract int getIncorrect();

    /**
     * reset number of attempts to login
     */
    public abstract void resetIncorrect();

    /**
     * add to number of attempts to login
     */
    public abstract void addIncorrect();

    /**
     * ovverides the tostring method for this class
     * @return a string that properly describes the information held in the
     * class
     */
    public abstract String toString();
}
