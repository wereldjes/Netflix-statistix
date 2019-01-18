package model;

public class Series {

    private String title;
    private String genre;
    private String language;
    private int ageIndication;
    private String seriesSuggestion;

    public Series(String title, String genre, String language, int ageIndication, String serieSuggestion) {
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.ageIndication = ageIndication;
        this.seriesSuggestion = serieSuggestion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getSeriesSuggestion() {
        return seriesSuggestion;
    }

    public void setSeriesSuggestion(String seriesSuggestion) {
        this.seriesSuggestion = seriesSuggestion;
    }
}
