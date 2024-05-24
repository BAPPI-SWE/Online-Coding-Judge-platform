package models;

public class Problem {
    private String title;
    private String description;
    private String difficulty;
    private double rating;
    private int ratingCount;

    public Problem(String title, String description, String difficulty) {
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.rating = 0.0;
        this.ratingCount = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public double getRating() {
        return rating;
    }

    public void rateProblem(double rating) {
        this.rating = (this.rating * this.ratingCount + rating) / (++this.ratingCount);
    }
}
