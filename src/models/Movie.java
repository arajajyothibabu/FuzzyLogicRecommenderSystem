package models;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class Movie {

    public int movieID;
    public String title;
    public String genre;

    public Movie(int movieID, String title, String genre) {
        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
    }

    public Movie() {
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
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
}
