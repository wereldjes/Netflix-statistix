package model;

public class Episode extends Program {

    private int season;
    private int episodeID;
    private String seriesTitle;

    public Episode(String title, int duration, int season) {
        super(title, duration);
        this.season = season;
    }

    public Episode(String title, int duration, int season, int episodeID, String seriesTitle) {
        super(title, duration);
        this.seriesTitle = seriesTitle;
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

    public String getSeriesTitle() {
        return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
        this.seriesTitle = seriesTitle;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
