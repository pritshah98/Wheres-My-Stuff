package com.example.seekers.wheresmystuff.Model;

/**
 * This class represents the User account.
 * Created by pritshah on 6/17/17.
 */

public class User extends Person {
    private String name;
    private String username;
    private String password;
    private String accountType;
    private boolean banned;
    private int incorrect;

    public User() {

    }

    /**
     * Create a User account with the given data.
     *
     * @param name The name of the user.
     * @param username The user's username for login and within the app.
     * @param password The user's password for login.
     * @param accountType The type of account for this user.
     */
    public User(String name, String username, String password, String accountType) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
        banned = false;
        incorrect = 0;
    }

    /**
     * Check if the User account is banned
     * @return true if account is banned, false otherwise
     */
    public boolean isBanned() {
        if (banned) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * add to number of attempts to login
     */
    public void addIncorrect() {
        incorrect++;
    }

    /**
     * reset number of attempts to login
     */
    public void resetIncorrect() {
        incorrect = 0;
    }

    /**
     * get number incorrect tries
     * @return incorrect tries
     */
    public int getIncorrect() {
        return incorrect;
    }

    /**
     * Set account to banned or unbanned
     * @param b true for banned, false for unbanned
     */
    public void setBanned(boolean b) {
        if (b) {
            banned = true;
        } else {
            banned = false;
        }
    }

    /**
     * Get the name of the user.
     *
     * @return name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the username for the user's account.
     *
     * @return username of the account.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the status of the account.
     *
     * @return type of account for the user.
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Get the password for the user's account.
     *
     * @return password of the account.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Overrides the toString method to accurately describe this class
     * @return a String that holds a proper description of this class
     */
    public String toString() {
        return "Name: " + this.name + " Account Type: " + this.accountType;
    }
}
