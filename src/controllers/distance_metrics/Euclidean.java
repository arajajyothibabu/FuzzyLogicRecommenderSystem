package controllers.distance_metrics;

import controllers.OracleDAO;
import models.*;
import utils.Utils;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class Euclidean implements DistanceMetrics {

    //FIXME: userId ot userObject need to fix later
    public double dissimilarityBetweenUsers(User userU, User userV) throws Exception {
        ArrayList<UserSimilarity> similarityList = OracleDAO.getSimilarity(userU, userV);
        double sumOfSquares = 0;
        double ratingDifference = 0;
        for(UserSimilarity us : similarityList){
            ratingDifference = us.ratingU - us.ratingV;
            sumOfSquares += Utils.square(ratingDifference);
        }
        return Math.sqrt(sumOfSquares);
    }

    public double dissimilarityBetweenMovies(Movie movie1, Movie movie2) throws Exception {
        ArrayList<String> genreList = Genre.getGenreList();
        double sumOfSquares = 0;
        double genreDifference = 0;
        for(int i = 0; i < genreList.size(); i++){
            genreDifference = movie1.genres[i] - movie2.genres[i];
            sumOfSquares += Utils.square(genreDifference);
        }
        return Math.sqrt(sumOfSquares);
    }

}
