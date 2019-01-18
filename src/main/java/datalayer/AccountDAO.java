package datalayer;

import datalayerInterface.IAccount;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO implements IAccount {

    private static AccountDAO instance;

    public static AccountDAO getInstance() {
        if(instance == null){
            instance = new AccountDAO();
        }
        return instance;
    }

    @Override
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

    @Override
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

    }

    @Override
    public Account getAccountByUsername(String username) {
        Connection con = null;
        Account a = null;
        String query = "SELECT * FROM account WHERE name = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, username);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("account_id");
                String name = resultSet.getString("name");
                String streetName = resultSet.getString("street_name");
                String houseNumber = resultSet.getString("house_number");
                String residence = resultSet.getString("residence");
                String postalCode = resultSet.getString("postal_code");

                a = new Account(id, name, streetName, houseNumber, residence, postalCode);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return a;
    }
}
