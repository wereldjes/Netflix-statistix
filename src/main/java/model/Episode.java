package model;

public class Episode extends Program {

    private int season;

    public Episode(String title, int lengthOfTime, int season) {
        super(title, lengthOfTime);
        this.season = season;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
