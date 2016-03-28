package controllers.services;

import controllers.OracleDAO;
import models.Movie;
import models.Rating;
import models.User;
import models.UserSimilarity;
import utils.DB;
import utils.Utils;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 27-Mar-16.
 */
public class RatingDataService {

    private static String tableName = "ratings";

    public static boolean addRating(Rating rating) throws Exception {
        boolean isRated = OracleDAO.addRating(rating);
        return isRated;
    }

    public static double getAverageRatingToMovie(int movieId) throws Exception {
        double averageRating = OracleDAO.getAverageRatingToMovie(movieId);
        return averageRating;
    }

    public static ArrayList<Rating> getRating() throws Exception {
        ArrayList<Rating> ratingList = OracleDAO.getRating();
        return ratingList;
    }

    public static Rating ratingOfUserToMovie(int userId, int movieId) throws Exception {
        Rating rating = OracleDAO.ratingOfUserToMovie(userId, movieId);
        return rating;
    }

    public static ArrayList<Rating> getRatingsOfUser(int userId) throws Exception {
        ArrayList<Rating> ratingList = OracleDAO.getRatingsOfUser(userId);
        return ratingList;
    }

}