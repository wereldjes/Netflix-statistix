package model;

import java.time.LocalDate;

public class Profile {

    private String profileName;
    private LocalDate age;
    private int profileID;
    private int accountID;
    // Arraylist to keep track of watched series/movies ?

    public Profile(String profileName, LocalDate age,int accountID, int profileID) {
        this.accountID = accountID;
        this.profileID = profileID;
        this.profileName = profileName;
        this.age = age;
    }

    public Profile(String profileName, LocalDate age, int accountID) {
        this.profileName = profileName;
        this.age = age;
        this.accountID = accountID;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
