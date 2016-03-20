package controllers.distance_metrics;

import controllers.OracleDAO;
import models.*;
import utils.Utils;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 16-Mar-16.
 */
public class PearsonCoefficient {

    public static double averageRatingOfUser(User user) throws Exception {
        double totalRating = 0;
        ArrayList<Rating> ratingsOfUser = OracleDAO.getRatingsOfUser(user.userId);
        for(Rating rating : ratingsOfUser)
            totalRating += rating.rating;
        int ratingsCount = ratingsOfUser.size();
        int actualNumberOfRatingsByUser = ratingsCount > 0? ratingsCount : 1;
        double averageRating = totalRating / actualNumberOfRatingsByUser;
        return averageRating;
    }

    public static double dissimilarityBetweenUsers(User userU, User userV) throws Exception{
        ArrayList<Movie> movieList = OracleDAO.getMovies();
        double sumOfDifferencesOfUserU = 0, sumOfDifferencesOfUserV = 0, numeratorSum = 0, denominatorSumUserU = 0, denominatorSumUserV = 0, userUDifference = 0, userVDifference = 0;
        double averageRatingOfUserU = averageRatingOfUser(userU);
        double averageRatingOfUserV = averageRatingOfUser(userV);
        int ratingOfUserUForSingleMovie = 0, ratingOfUserVForSingleMovie = 0;
        for(Movie movie : movieList){
            ratingOfUserUForSingleMovie = OracleDAO.ratingOfUserToMovie(userU.userId, movie.movieID).rating;
            ratingOfUserVForSingleMovie = OracleDAO.ratingOfUserToMovie(userV.userId, movie.movieID).rating;
            userUDifference = ratingOfUserUForSingleMovie - averageRatingOfUserU;
            userVDifference = ratingOfUserVForSingleMovie - averageRatingOfUserV;
            numeratorSum += userUDifference * userVDifference;
            denominatorSumUserU += Utils.square(userUDifference);
            denominatorSumUserV += Utils.square(userVDifference);
        }
        return numeratorSum / (Math.sqrt(denominatorSumUserU) * Math.sqrt(denominatorSumUserV));
    }

    public static double dissmilarityBetweenMovies(){
        return 0;
    }

}
