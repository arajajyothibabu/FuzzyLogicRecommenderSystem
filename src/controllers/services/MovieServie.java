package controllers.services;

import controllers.OracleDAO;
import controllers.fuzzy_inference_system.FIS;
import models.MovieRenderModel;
import models.Rating;
import utils.DB;
import utils.Utils;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by Araja Jyothi Babu on 07-Apr-16.
 */
public class MovieServie {

    private MovieRenderModel movie;
    private DB db;
    private OracleDAO dao;
    private static FIS fis;
    private ArrayList<MovieRenderModel> relatedMovieList;

    public MovieServie(int movieId, int K, String method) throws Exception{
        db = new DB();
        dao = new OracleDAO(db);
        MovieDataService movieDataService = new MovieDataService(dao);
        fis = new FIS(new RatingDataService(dao), movieDataService, new UserDataService(dao));
        movie = Utils.makeMovieRender(movieDataService.getMovie(movieId));
        movie.setRating(0); //updating rating of Movie to 0, for user convenience
        relatedMovieList = fis.relatedMovies(movieId, K, method);
    }

    public MovieServie(int userId, int movieId, int K, String method) throws Exception{
        db = new DB();
        dao = new OracleDAO(db);
        RatingDataService ratingDataService = new RatingDataService(dao);
        MovieDataService movieDataService = new MovieDataService(dao);
        fis = new FIS(ratingDataService, movieDataService, new UserDataService(dao));
        Rating userRating = ratingDataService.ratingOfUserToMovie(userId, movieId);
        movie = Utils.makeMovieRender(movieDataService.getMovie(movieId));
        movie.setRating(userRating.rating);
        relatedMovieList = fis.relatedMovies(movieId, K, method);
    }

    public MovieRenderModel getMovie() {
        return movie;
    }

    public void setMovie(MovieRenderModel movie) {
        this.movie = movie;
    }

    public ArrayList<MovieRenderModel> getRelatedMovieList() {
        return relatedMovieList;
    }

    public void setRelatedMovieList(ArrayList<MovieRenderModel> relatedMovieList) {
        this.relatedMovieList = relatedMovieList;
    }
}
