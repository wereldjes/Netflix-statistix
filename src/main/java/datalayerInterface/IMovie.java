package datalayerInterface;

import main.java.model.Movie;

import java.util.List;

public interface IMovie {

    Movie getMovieByTitle(String title);

    List getAllMovies();
}
