package datalayer;

import datalayerInterface.IProfile;
import model.Profile;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

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
}
