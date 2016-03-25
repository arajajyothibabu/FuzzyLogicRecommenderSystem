package models;

import controllers.OracleDAO;
import utils.Utils;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 22-Mar-16.
 */
public class MovieRenderModel {

    public int movieId;
    public String title;
    public double rating;
    public String imgSrc;
    public String genres;

    public MovieRenderModel(int movieId, String title, double rating, int[] genres) throws Exception {
        this.movieId = movieId;
        this.title = title;
        this.rating = rating;
        this.imgSrc =  "img/" + String.valueOf(movieId-100) + ".jpg";
        this.genres = getGenres(genres);
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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public static String getGenres(int [] genreIds) throws Exception {
        ArrayList<String> genreList = Genre.getGenreList();
        StringBuilder genresData = new StringBuilder("");
        for(int i = 0; i < genreList.size(); i++){
            if( genreIds[i] == 1)
                genresData.append(genreList.get(i) + ", ");
        }
        return genresData.toString();
    }

}
