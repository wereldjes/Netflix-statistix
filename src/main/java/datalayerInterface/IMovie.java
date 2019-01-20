package datalayerInterface;

import model.Movie;

import java.util.HashSet;

public interface IMovie {

    Movie getMovieByTitle(String title);

    HashSet<Movie> getAllMovies();

    Movie getLongestMovieUnderSixteen();
}
