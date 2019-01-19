package datalayer;

import datalayerInterface.IEpisode;
import model.Episode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EpisodeDAO implements IEpisode {
    public static EpisodeDAO instance;

    public static EpisodeDAO getInstance() {
        if(instance == null) {
            instance = new EpisodeDAO();
        }
        return instance;
    }

    @Override @SuppressWarnings("Duplicates")
    public List<Episode> getAllEpisodes() {
        Connection con = null;
        String query = "SELECT * FROM episode";
        ArrayList<Episode> allEpisodes = new ArrayList<>();

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                int episodeID = rs.getInt("episode_id");
                String title = rs.getString("title");
                int duration = rs.getInt("duration");
                int season = rs.getInt("season");

                Episode e = new Episode(title, duration, season, episodeID);
                allEpisodes.add(e);
            }

        } catch( Exception e) {
            e.printStackTrace();
        }
        return allEpisodes;
    }

    @Override @SuppressWarnings("Duplicates")
    public Episode getEpisodeByName(String title) {
        Connection con = null;
        String query = "SELECT * FROM episode WHERE title = ?";
        Episode ep = null;

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, title);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                int episodeID = rs.getInt("episode_id");
                String episodeTitle = rs.getString("title");
                int duration = rs.getInt("duration");
                int season = rs.getInt("season");

                ep = new Episode(episodeTitle, duration, season, episodeID);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return ep;
    }
}
