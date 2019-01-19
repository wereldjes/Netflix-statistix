package datalayerInterface;

import model.Episode;
import model.Series;

import java.util.HashSet;
import java.util.List;

public interface ISeries {

    HashSet<Series> getAllSeries();

    Series getSeriesByTitle(String title);

    List<Episode> getAllEpisodeBySeries(String title);
}
