package controllers.distance_metrics;

import controllers.services.UserDataService;
import models.*;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 16-Mar-16.
 */
public class Manhattan implements DistanceMetrics {

    public double dissimilarityBetweenUsers(User userU, User userV) throws Exception{
        ArrayList<UserSimilarity> similarityList = UserDataService.getSimilarity(userU, userV);
        double sumOfDifferences = 0;
        double ratingDifference = 0;
        for(UserSimilarity us : similarityList){
            ratingDifference = us.ratingU - us.ratingV;
            sumOfDifferences += Math.abs(ratingDifference);
        }
        return sumOfDifferences;
    }

    public double dissimilarityBetweenMovies(Movie movie1, Movie movie2) throws Exception {
        ArrayList<String> genreList = Genre.getGenreList();
        double sumOfDifferences = 0;
        double genreDifference = 0;
        for(int i = 0; i < genreList.size(); i++){
            genreDifference = movie1.genres[i] - movie2.genres[i];
            sumOfDifferences += genreDifference;
        }
        return sumOfDifferences;
    }

}
