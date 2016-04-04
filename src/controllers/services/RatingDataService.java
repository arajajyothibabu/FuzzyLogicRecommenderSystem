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

    private OracleDAO dao;

    public RatingDataService(OracleDAO dao) {
        this.dao = dao;
    }

    public boolean addRating(Rating rating) throws Exception {
        boolean isRated = dao.addRating(rating);
        return isRated;
    }

    public double getAverageRatingToMovie(int movieId) throws Exception {
        double averageRating = dao.getAverageRatingToMovie(movieId);
        return averageRating;
    }

    public ArrayList<Rating> getRating() throws Exception {
        ArrayList<Rating> ratingList = dao.getRating();
        return ratingList;
    }

    public Rating ratingOfUserToMovie(int userId, int movieId) throws Exception {
        Rating rating = dao.ratingOfUserToMovie(userId, movieId);
        return rating;
    }

    public ArrayList<Rating> getRatingsOfUser(int userId) throws Exception {
        ArrayList<Rating> ratingList = dao.getRatingsOfUser(userId);
        return ratingList;
    }

}