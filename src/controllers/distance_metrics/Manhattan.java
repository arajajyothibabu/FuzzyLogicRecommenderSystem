package controllers.distance_metrics;

import models.*;
import utils.DB;
import utils.Utils;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 16-Mar-16.
 */
public class Manhattan {

    public static double dissimilarityBetweenUsers(User userU, User userV) throws Exception{
        ArrayList<Movie> movieList = DB.getMovies();
        double sumOfDifferences = 0;
        double ratingDifference = 0;
        for(Movie movie : movieList){
            ratingDifference = DB.ratingOfUserToMovie(userU.userId, movie.movieID).rating - DB.ratingOfUserToMovie(userV.userId, movie.movieID).rating;
            sumOfDifferences += Math.abs(ratingDifference);
        }
        return Math.sqrt(sumOfDifferences);
    }

    public static double dissmilarityBetweenMovies(){
        return 0;
    }

}
