package datalayerInterface;

import main.java.model.Series;
import java.util.List;

public interface ISeries {

    List getAllSeries();

    Series getSeriesByTitle(String title);
}
