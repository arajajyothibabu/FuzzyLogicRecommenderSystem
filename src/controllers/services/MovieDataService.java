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

    private static String tableName = "movies";

    public static boolean addMovie(Movie movie) throws Exception {
        boolean isAdded = OracleDAO.addMovie(movie);
        return isAdded;
    }

    public static ArrayList<Movie> getMovies() throws Exception {
        ArrayList<Movie> movieList = OracleDAO.getMovies();
        return movieList;
    }

    public static Movie getMovie(int movieId) throws Exception {
        Movie movie = OracleDAO.getMovie(movieId);
        return movie;
    }

    public static int[] getGenres(int movieId) throws Exception {
        int[] genres = OracleDAO.getGenres(movieId);
        return genres;
    }

    //movies rated by user above averageRating
    public static ArrayList<Movie> getMovies(ArrayList<User> users) throws Exception {
        ArrayList<Movie> movieList = OracleDAO.getMovies(users);
        return movieList;
    }

    public static ArrayList<Movie> getRestOfMovies(ArrayList<MovieRenderModel> movies) throws Exception {
        ArrayList<Movie> movieList = OracleDAO.getRestOfMovies(movies);
        return movieList;
    }

    public static ArrayList<Movie> getMovies(Movie movie) throws Exception {
        ArrayList<Movie> movieList = OracleDAO.getMovies(movie);
        return movieList;
    }

}
