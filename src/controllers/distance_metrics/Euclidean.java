package controllers.distance_metrics;

import models.*;
import utils.DB;
import utils.Utils;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class Euclidean {

    //TODO:public static double dissimilarityBetweenUser(ArrayList<>users)
    //FIXME: userId ot userObject need to fix later
    public static double dissimilarityBetweenUsers(User userU, User userV) throws Exception{
        ArrayList<Movie> movieList = DB.getMovies();
        double sumOfSquares = 0;
        double ratingDifference = 0;
        for(Movie movie : movieList){
            ratingDifference = DB.ratingOfUserToMovie(userU.userId, movie.movieID).rating - DB.ratingOfUserToMovie(userV.userId, movie.movieID).rating;
            sumOfSquares += Utils.square(ratingDifference);
        }
        return Math.sqrt(sumOfSquares);
    }

    public static double dissmilarityBetweenMovies(){
        return 0;
    }

}
