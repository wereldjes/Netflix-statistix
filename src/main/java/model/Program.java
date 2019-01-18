package model;

public abstract class Program {

    private String title;
    private int lengthOfTime;

    public Program(String title, int lengthOfTime) {
        this.title = title;
        this.lengthOfTime = lengthOfTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLengthOfTime() {
        return lengthOfTime;
    }

    public void setLengthOfTime(int lengthOfTime) {
        this.lengthOfTime = lengthOfTime;
    }
}
