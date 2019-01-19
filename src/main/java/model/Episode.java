package model;

public class Episode extends Program {

    private int season;
    private int episodeID;

    public Episode(String title, int duration, int season) {
        super(title, duration);
        this.season = season;
    }

    public Episode(String title, int duration, int season, int episodeID) {
        super(title, duration);
        this.season = season;
        this.episodeID = episodeID;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getEpisodeID() {
        return episodeID;
    }

    public void setEpisodeID(int episodeID) {
        this.episodeID = episodeID;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
