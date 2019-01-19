package datalayer;

import datalayerInterface.IAccount;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements IAccount {

    private static AccountDAO instance;

    public static AccountDAO getInstance() {
        if(instance == null){
            instance = new AccountDAO();
        }
        return instance;
    }

    @Override @SuppressWarnings("Duplicates")
    public void createAccount(Account a) {
        Connection con = null;
        String query = "INSERT INTO account (`name`, `street_name`, `house_number`, `residence`, `postal_code`)"
                     + "VALUES (?, ?, ?, ?, ?)";

        try {
            //Set statement parameters
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, a.getName());
            st.setString(2, a.getStreetName());
            st.setString(3, a.getHouseNumber());
            st.setString(4, a.getResidence());
            st.setString(5, a.getPostalCode());

            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override @SuppressWarnings("Duplicates")
    public void updateAccount(Account a) {
        Connection con = null;
        String query = "UPDATE account SET name = ?, street_name = ?, house_number = ?, residence = ?, postal_code = ? WHERE account_id = ?";

        try {
            //Set statement parameters
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, a.getName());
            st.setString(2, a.getStreetName());
            st.setString(3, a.getHouseNumber());
            st.setString(4, a.getResidence());
            st.setString(5, a.getPostalCode());
            st.setInt(6, a.getAccountID());

            st.executeUpdate();
            st.close();
        } catch(Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void deleteAccount(Account a) {
        Connection con = null;
        String query = "DELETE FROM account WHERE account_id = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, a.getAccountID());

            st.execute();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override @SuppressWarnings("Duplicates")
    public Account getAccountByUsername(String username) {
        Connection con = null;
        Account a = null;
        String query = "SELECT * FROM account WHERE name = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                int id = rs.getInt("account_id");
                String name = rs.getString("name");
                String streetName = rs.getString("street_name");
                String houseNumber = rs.getString("house_number");
                String residence = rs.getString("residence");
                String postalCode = rs.getString("postal_code");

                a = new Account(id, name, streetName, houseNumber, residence, postalCode);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override @SuppressWarnings("Duplicates")
    public List<Account> getAccountsWithOneProfile() {
        Connection con = null;
        String query = "SELECT account.*, COUNT(*) count FROM account INNER JOIN profile ON profile.account_id = account.account_id"
                     + "GROUP BY account.account_id HAVING count = 1";
        ArrayList<Account> oneProfileAccounts = new ArrayList<>();

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                int id = rs.getInt("account_id");
                String name = rs.getString("name");
                String streetName = rs.getString("street_name");
                String houseNumber = rs.getString("house_number");
                String residence = rs.getString("residence");
                String postalCode = rs.getString("postal_code");

                Account account = new Account(id, name, streetName, houseNumber, residence, postalCode);
                oneProfileAccounts.add(account);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return oneProfileAccounts;
    }
}
