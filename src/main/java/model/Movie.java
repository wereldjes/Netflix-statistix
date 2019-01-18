package model;

public class Movie extends Program {

    private String genre;
    private String language;
    private int ageIndication;

    public Movie(String title, int lengthOfTime, String genre, String language, int ageIndication) {
        super(title, lengthOfTime);
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
}
