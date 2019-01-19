package model;

public class Movie extends Program {

    private String genre;
    private String language;
    private int ageIndication;
    private int movieID;

    public Movie(String title, int duration, String genre, String language, int ageIndication) {
        super(title, duration);
        this.genre = genre;
        this.language = language;
        this.ageIndication = ageIndication;
    }

    public Movie(String title, int duration, String genre, String language, int ageIndication, int movieID) {
        super(title, duration);
        this.movieID = movieID;
        this.genre = genre;
        this.language = language;
        this.ageIndication = ageIndication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAgeIndication() {
        return ageIndication;
    }

    public void setAgeIndication(int ageIndication) {
        this.ageIndication = ageIndication;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
