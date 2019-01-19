package datalayer;

import datalayerInterface.ISeries;
import model.Episode;
import model.Series;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;

public class SeriesDAO implements ISeries {
    public static SeriesDAO instance;

    public static SeriesDAO getInstance(){
        if(instance == null) {
            instance = new SeriesDAO();
        }
        return instance;
    }

    @Override @SuppressWarnings("Duplicates")
    public HashSet<Series> getAllSeries() {
        Connection con = null;
        String query = "SELECT * FROM series";
        HashSet<Series> allSeries = new HashSet<>();

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                String seriesTitle = rs.getString("title");
                String genre = rs.getString("genre");
                String language = rs.getString("language");
                String seriesSuggestion = rs.getString("series_suggestion");
                int ageIndication = rs.getInt("age_indication");

                Series s = new Series(seriesTitle, genre, language, ageIndication, seriesSuggestion);
                allSeries.add(s);
            }

        } catch( Exception e) {
            e.printStackTrace();
        }
        return allSeries;
    }

    @Override @SuppressWarnings("Duplicates")
    public Series getSeriesByTitle(String title) {
        Connection con = null;
        Series s = null;
        String query = "SELECT * FROM series WHERE title = ?";

        try {
            con = MysqlConnector.getInstance().connect();
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, title);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                String seriesTitle = rs.getString("title");
                String genre = rs.getString("genre");
                String language = rs.getString("language");
                String seriesSuggestion = rs.getString("series_suggestion");
                int ageIndication = rs.getInt("age_indication");

                s = new Series(seriesTitle, genre, language, ageIndication, seriesSuggestion);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public List<Episode> getAllEpisodeBySeries(Series s) {
        return null;
    }
}
