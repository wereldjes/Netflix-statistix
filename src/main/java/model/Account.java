package model;

public class Account {

    private String name;
    private String streetName;
    private String houseNumber;
    private String residence;
    private String postalCode;
    private int accountID;

    public Account(String name, String streetName, String houseNumber, String residence, String postalCode) {
        this.name = name;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.residence = residence;
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
       return this.getName();
    }
}
