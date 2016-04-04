package controllers.services;

import controllers.OracleDAO;
import models.*;
import utils.DB;
import utils.Utils;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 27-Mar-16.
 */
public class MovieDataService {

    private OracleDAO dao;

    public MovieDataService(OracleDAO dao) {
        this.dao = dao;
    }

    public boolean addMovie(Movie movie) throws Exception {
        boolean isAdded = dao.addMovie(movie);
        return isAdded;
    }

    public ArrayList<Movie> getMovies() throws Exception {
        ArrayList<Movie> movieList = dao.getMovies();
        return movieList;
    }

    public Movie getMovie(int movieId) throws Exception {
        Movie movie = dao.getMovie(movieId);
        return movie;
    }

    public int[] getGenres(int movieId) throws Exception {
        int[] genres = dao.getGenres(movieId);
        return genres;
    }

    //movies rated by user above averageRating
    public ArrayList<Movie> getMovies(ArrayList<User> users) throws Exception {
        ArrayList<Movie> movieList = dao.getMovies(users);
        return movieList;
    }

    public ArrayList<Movie> getRestOfMovies(ArrayList<MovieRenderModel> movies) throws Exception {
        ArrayList<Movie> movieList = dao.getRestOfMovies(movies);
        return movieList;
    }

    public ArrayList<Movie> getMovies(Movie movie) throws Exception {
        ArrayList<Movie> movieList = dao.getMovies(movie);
        return movieList;
    }

}
