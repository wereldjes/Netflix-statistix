package datalayerInterface;

import model.Movie;
import model.Profile;

import java.util.HashSet;
import java.util.List;

public interface IMovie {

    Movie getMovieByTitle(String title);

    HashSet<Movie> getAllMovies();

    Movie getLongestMovieUnderSixteen();

    void addWatchedPercentage(Movie m, Profile p, int percentage);

    void updateWatchedPercentage(Movie m, Profile p, int percentage);

    void deleteWatchedPercentage(Movie m, Profile p);

    int getWatchedPercentage(Movie m, Profile p);

    List<Movie> getWatchedMoviesByProfile(Profile p);

    int getMovieWatchCount(Movie m);
}
