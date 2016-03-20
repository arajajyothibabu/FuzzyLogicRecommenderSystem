package controllers.distance_metrics;

import controllers.OracleDAO;
import models.Rating;
import models.User;

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

}
