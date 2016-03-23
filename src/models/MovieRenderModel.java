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
    public int rating;
    public String imgSrc;
    public String genres;

    public MovieRenderModel(int movieId, String title, int rating) throws Exception {
        this.movieId = movieId;
        this.title = title;
        this.rating = rating;
        this.imgSrc =  "" + movieId + ".jpg";
        this.genres = getGenres(movieId);
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

    public String getGenres() {
        return genres;
    }

    public void setGenres() throws Exception {
        this.genres = getGenres(movieId);
    }

    public static String getGenres(int movieId) throws Exception {
        ArrayList<String> genreList = Genre.getGenreList();
        StringBuilder genresData = new StringBuilder("");
        int[] genreIds = OracleDAO.getGenres(movieId);
        for(int i = 0; i < genreList.size(); i++){
            if( genreIds[i] == 1)
                genresData.append(genreList.get(i) + ", ");
        }
        return genresData.toString();
    }

}
