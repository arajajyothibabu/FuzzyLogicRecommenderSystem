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
    public double rating;
    public int[] genres;

    public Movie(int movieId, String title, double rating, int[] genres) {
        this.movieId = movieId;
        this.title = title;
        this.rating = rating;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int[] getGenres() {
        return genres;
    }

    public void setGenres(int[] genres) {
        this.genres = genres;
    }

    //NOTE: Genres list is obtained by genreId stored in DB which is Primary key of Genres table


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        if (getMovieId() != movie.getMovieId()) return false;
        if (Double.compare(movie.getRating(), getRating()) != 0) return false;
        if (!getTitle().equals(movie.getTitle())) return false;
        return Arrays.equals(getGenres(), movie.getGenres());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getMovieId();
        result = 31 * result + getTitle().hashCode();
        temp = Double.doubleToLongBits(getRating());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Arrays.hashCode(getGenres());
        return result;
    }
}
