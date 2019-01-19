package datalayer;

import datalayerInterface.IProfile;
import model.Account;
import model.Profile;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.HashSet;

public class ProfileDAO implements IProfile {
    //TODO find a solution for Date being one day off (potential cause from timezone difference)

    private static ProfileDAO instance;

    public static ProfileDAO getInstance(){
        if(instance == null){
            instance = new ProfileDAO();
        }
        return instance;
    }

    @Override @SuppressWarnings("Duplicates")
    public void createProfile(Profile p) {
        Connection con = null;
        String query = "INSERT INTO profile (profile_name, age, account_id)"
                     + "VALUES(?, ?, ?)";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, p.getProfileName());
            st.setDate(2, Date.valueOf(p.getAge()));
            st.setInt(3, p.getAccountID());

            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override @SuppressWarnings("Duplicates")
    public void updateProfile(Profile p) {
        Connection con = null;
        String query = "UPDATE profile SET profile_name = ?, age = ? WHERE profile_id = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, p.getProfileName());
            st.setDate(2, Date.valueOf(p.getAge()));
            st.setInt(3, p.getProfileID());

            st.executeUpdate();
            st.close();
        } catch(Exception e) {

        }
    }

    @Override
    public void deleteProfile(Profile p) {
        Connection con = null;
        String query = "DELETE FROM profile WHERE profile_id = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, p.getProfileID());

            st.execute();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override @SuppressWarnings("Duplicates")
    public Profile getProfile(int id) {
        Connection con = null;
        Profile p = null;
        String query = "SELECT * FROM profile WHERE profile_id = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                int profileID = rs.getInt("profile_id");
                String profileName = rs.getString("profile_name");
                LocalDate age = rs.getDate("age").toLocalDate();
                int accountID = rs.getInt("account_id");

                p = new Profile(profileName, age, accountID, profileID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override @SuppressWarnings("Duplicates")
    public HashSet<Profile> getProfilesByAccount(Account a) {
        Connection con = null;
        String query = "SELECT * FROM profile WHERE account_id = ?";
        HashSet<Profile> accountProfiles = new HashSet<>();

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, a.getAccountID());
            ResultSet rs = st.executeQuery();

            //ResultSet holds a list of Profiles
            //While rs holds values, take them out and build a new profile that gets added to HashSet
            while(rs.next()){
                int profileID = rs.getInt("profile_id");
                String profileName = rs.getString("profile_name");
                LocalDate age = rs.getDate("age").toLocalDate();
                int accountID = rs.getInt("account_id");

                Profile p = new Profile(profileName, age, accountID, profileID);
                accountProfiles.add(p);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        return accountProfiles;
    }
}
