package datalayer;

import datalayerInterface.IMovie;
import model.Movie;
import model.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;

public class MovieDAO implements IMovie {
    private static MovieDAO instance;

    public static MovieDAO getInstance() {
        if(instance == null){
            instance = new MovieDAO();
        }
        return instance;
    }

    @Override @SuppressWarnings("Duplicates")
    public Movie getMovieByTitle(String title) {
        Connection con = null;
        Movie m = null;
        String query = "SELECT * FROM movie WHERE title = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, title);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                int movieID = rs.getInt("movie_id");
                String movieTitle = rs.getString("title");
                String language = rs.getString("language");
                int duration = rs.getInt("duration");
                String genre = rs.getString("genre");
                int ageIndication = rs.getInt("age_indication");

                m = new Movie(movieTitle, duration, genre, language, ageIndication, movieID);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override @SuppressWarnings("Duplicates")
    public HashSet<Movie> getAllMovies() {
        Connection con = null;
        HashSet<Movie> allMovies = new HashSet<>();
        String query = "SELECT * FROM movie";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                int movieID = rs.getInt("movie_id");
                String movieTitle = rs.getString("title");
                String language = rs.getString("language");
                int duration = rs.getInt("duration");
                String genre = rs.getString("genre");
                int ageIndication = rs.getInt("age_indication");

                Movie  m = new Movie(movieTitle, duration, genre, language, ageIndication, movieID);
                allMovies.add(m);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return allMovies;
    }

    @Override @SuppressWarnings("Duplicates")
    public Movie getLongestMovieUnderSixteen() {
        Connection con = null;
        Movie m = null;
        String query = "SELECT * FROM movie WHERE duration = (SELECT MAX(duration) FROM movie WHERE age_indication < 16)";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                int movieID = rs.getInt("movie_id");
                String movieTitle = rs.getString("title");
                String language = rs.getString("language");
                int duration = rs.getInt("duration");
                String genre = rs.getString("genre");
                int ageIndication = rs.getInt("age_indication");

                m = new Movie(movieTitle, duration, genre, language, ageIndication, movieID);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override @SuppressWarnings("Duplicates")
    public void addWatchedPercentage(Movie m, Profile p, int percentage) {
        Connection con = null;
        String query = "INSERT INTO watched VALUES('profile_id' = ?, 'movie_id' = ?, 'watched_percentage' = ?)";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, p.getProfileID());
            st.setInt(2, m.getMovieID());
            st.setInt(3, percentage);

            st.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateWatchedPercentage(Movie m, Profile p, int percentage) {
        Connection con = null;
        String query = "UPDATE watched SET watched_percentage = ? WHERE profile_id = ? AND movie_id = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, percentage);
            st.setInt(2, p.getProfileID());
            st.setInt(3, m.getMovieID());

            st.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override @SuppressWarnings("Duplicates")
    public void deleteWatchedPercentage(Movie m, Profile p) {
        Connection con = null;
        String query = "DELETE FROM watched WHERE profile_id = ? AND movie_id = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, p.getProfileID());
            st.setInt(2, m.getMovieID());

            st.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override @SuppressWarnings("Duplicates")
    public int getWatchedPercentage(Movie m, Profile p) {
        Connection con = null;
        int watchedPercentage = 0;
        String query = "SELECT watched.watched_percentage FROM watched WHERE profile_id = ? AND movie_id = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, p.getProfileID());
            st.setInt(2, m.getMovieID());
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                watchedPercentage = rs.getInt("watched_percentage");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return watchedPercentage;
    }
}
