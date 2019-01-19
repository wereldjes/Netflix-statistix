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

    private static ProfileDAO instance;

    public static ProfileDAO getInstance(){
        if(instance == null){
            instance = new ProfileDAO();
        }
        return instance;
    }

    @Override
    public void createProfile(Profile p) {
        Connection con = null;
        String query = "INSERT INTO profile (profile_name, age, account_id)"
                     + "VALUES(?, ?, ?)";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, p.getProfileName());
            st.setDate(2, Date.valueOf(p.getAge().plusDays(1)));
            st.setInt(3, p.getAccountID());

            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateProfile(Profile p) {

    }

    @Override
    public void deleteProfile(Profile p) {

    }

    @Override
    public Profile getProfile(int id) {
        return null;
    }

    @Override
    public HashSet<Profile> getProfilesByAccount(Account a) {
        Connection con = null;
        String query = "SELECT * FROM profile WHERE account_id = ?";
        HashSet<Profile> accountProfiles = new HashSet<>();

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, a.getAccountID());
            ResultSet rs = st.executeQuery();

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
