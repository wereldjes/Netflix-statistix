package datalayerInterface;

import model.Episode;
import model.Profile;

import java.util.List;

public interface IEpisode {

    List<Episode> getAllEpisodes();

    Episode getEpisodeByName(String title);

    int getAverageWatchTime(Episode e);

    void addWatchedPercentage(Episode e, Profile p, int percentage);

    int getWatchedPercentage(Episode e, Profile p);

    void updateWatchedPercentage(Episode e, Profile p, int percentage);

    void deleteWatchedPercentage(Episode e, Profile p);
}
