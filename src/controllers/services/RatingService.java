package controllers.services;

import controllers.OracleDAO;
import controllers.fuzzy_inference_system.FIS;
import models.Rating;
import utils.DB;
import java.util.Calendar;

/**
 * Created by Araja Jyothi Babu on 07-Apr-16.
 */
public class RatingService {

    private DB db;
    private OracleDAO dao;
    private static FIS fis;
    private RatingDataService ratingDataService;
    Rating currentRating;

    public RatingService(int userId, int movieId, int rating) throws Exception{
        db = new DB();
        dao = new OracleDAO(db);
        ratingDataService = new RatingDataService(dao);
        currentRating = new Rating(userId, movieId, rating, new java.sql.Date(Calendar.getInstance().getTimeInMillis()).toString());
    }

    public boolean doRating() throws Exception {
        return ratingDataService.addRating(currentRating);
    }

}
