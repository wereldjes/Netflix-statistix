package datalayer;

import datalayerInterface.IEpisode;
import model.Episode;
import model.Profile;

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
                String seriesTitle = rs.getString("series_title");

                Episode e = new Episode(title, duration, season, episodeID, seriesTitle);
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
                String seriesTitle = rs.getString("series_title");

                ep = new Episode(episodeTitle, duration, season, episodeID, seriesTitle);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return ep;
    }

    @Override
    public int getAverageWatchTime(Episode e) {
        Connection con = null;
        int averageWatchPercentage = 0;
        String query = "SELECT AVG(watched.watched_percentage) AS average_watch_percentage FROM watched WHERE episode_id = ? ";

        try{
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, e.getEpisodeID());
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                averageWatchPercentage = Math.round(rs.getInt("average_watch_percentage"));
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return averageWatchPercentage;
    }

    @Override
    public void addWatchedPercentage(Episode e, Profile p, int percentage) {
        Connection con = null;
        String query = "INSERT INTO watched VALUES('profile_id' = ?, 'episode_id' = ?, 'watched_percentage' = ?)";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, p.getProfileID());
            st.setInt(2, e.getEpisodeID());
            st.setInt(3, percentage);

            st.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override @SuppressWarnings("Duplicates")
    public int getWatchedPercentage(Episode e, Profile p) {
        Connection con = null;
        int watchedPercentage = 0;
        String query = "SELECT watched.watched_percentage FROM watched WHERE episode_id = ? AND profile_id = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, e.getEpisodeID());
            st.setInt(2, p.getProfileID());
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                watchedPercentage = rs.getInt("watched_percentage");
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return watchedPercentage;
    }

    @Override
    public void updateWatchedPercentage(Episode e, Profile p, int percentage) {
        Connection con = null;
        String query = "UPDATE watched SET watched_percentage = ? WHERE episode_id = ? AND profile_id = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, percentage);
            st.setInt(2, e.getEpisodeID());
            st.setInt(3, p.getProfileID());

            st.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override @SuppressWarnings("Duplicates")
    public void deleteWatchedPercentage(Episode e, Profile p) {

        Connection con = null;
        String query = "DELETE FROM watched WHERE episode_id = ? AND profile_id = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, e.getEpisodeID());
            st.setInt(2, p.getProfileID());

            st.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
