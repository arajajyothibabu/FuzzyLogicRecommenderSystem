package models;

import controllers.OracleDAO;
import utils.Utils;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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
        this.genres = getGenres(this.movieId);
    }

    public static String getGenres(int movieId) throws Exception {
        ArrayList<String> genreList = Genre.getGenreList();
        StringBuilder genres = new StringBuilder("");
        ArrayList<Integer> genreIds = Utils.makeGenereList(OracleDAO.getGenres(movieId));
        for(int i = 0; i < genreList.size(); i++){
            if( genreIds.get(i) == 1)
                genres.append(genreList.get(i) + ", ");
        }
        return genres.toString();
    }

}
