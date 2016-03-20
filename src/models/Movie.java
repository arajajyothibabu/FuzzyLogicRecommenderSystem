package models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class Movie {

    public int movieId;
    public String title;
    public ArrayList<Integer> genres;

    public Movie(int movieId, String title, ArrayList<Integer> genres) {
        this.movieId = movieId;
        this.title = title;
        this.genres = genres;
    }

    public Movie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Integer> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Integer> genres) {
        this.genres = genres;
    }

    //NOTE: Genres list is obtained by genreId stored in DB which is Primary key of Genres table

}
