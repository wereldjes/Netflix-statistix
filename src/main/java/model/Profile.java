package model;

import java.time.LocalDateTime;

public class Profile {

    private String profileName;
    private LocalDateTime age;
    private int profileID;
    // Arraylist to keep track of watched series/movies ?

    public Profile(String profileName, LocalDateTime age, int profileID) {
        this.profileID = profileID;
        this.profileName = profileName;
        this.age = age;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public LocalDateTime getAge() {
        return age;
    }

    public void setAge(LocalDateTime age) {
        this.age = age;
    }

    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }
}
