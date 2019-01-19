package datalayerInterface;

import model.Episode;
import java.util.List;

public interface IEpisode {

    List<Episode> getAllEpisodes();

    Episode getEpisodeByName(String title);
}
