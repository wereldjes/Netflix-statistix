package datalayer;

import datalayerInterface.IMovie;
import model.Movie;

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
                String movieTitle = rs.getString("name");
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
                String movieTitle = rs.getString("name");
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
}
