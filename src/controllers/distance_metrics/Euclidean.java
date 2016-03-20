package controllers.distance_metrics;

import controllers.OracleDAO;
import models.*;
import utils.DB;
import utils.Utils;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class Euclidean {

    //FIXME: userId ot userObject need to fix later
    public static double dissimilarityBetweenUsers(User userU, User userV) throws Exception {
        ArrayList<Movie> movieList = OracleDAO.getMovies();
        double sumOfSquares = 0;
        double ratingDifference = 0;
        for(Movie movie : movieList){
            ratingDifference = OracleDAO.ratingOfUserToMovie(userU.userId, movie.movieId).rating - OracleDAO.ratingOfUserToMovie(userV.userId, movie.movieId).rating;
            sumOfSquares += Utils.square(ratingDifference);
        }
        return Math.sqrt(sumOfSquares);
    }

    public static double dissimilarityBetweenMovies(Movie movie1, Movie movie2) throws Exception {
        ArrayList<String> genreList = Genre.getGenreList();
        double sumOfSquares = 0;
        double genreDifference = 0;
        for(int i = 0; i < genreList.size(); i++){
            genreDifference = movie1.genres.get(i) - movie2.genres.get(i);
            sumOfSquares += Utils.square(genreDifference);
        }
        return Math.sqrt(sumOfSquares);
    }

}
