package datalayerInterface;

import main.java.model.Episode;
import java.util.List;

public interface IEpisode {

    List getAllEpisodes();

    Episode getEpisodeByName();
}
