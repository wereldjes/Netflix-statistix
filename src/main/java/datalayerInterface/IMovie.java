package datalayerInterface;

import model.Movie;

import java.util.List;

public interface IMovie {

    Movie getMovieByTitle(String title);

    List getAllMovies();
}
