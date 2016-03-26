package controllers.distance_metrics;

import controllers.OracleDAO;
import models.Genre;
import models.Movie;
import models.User;
import models.UserSimilarity;
import utils.Utils;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 16-Mar-16.
 */
public class Cosine implements DistanceMetrics {

    public static double dissimilarityBetweenUsers(User userU, User userV) throws Exception{
        ArrayList<UserSimilarity> similarityList = OracleDAO.getSimilarity(userU, userV);
        double dotProduct = 0, ratingOfUserUMagnitude = 0, ratingOfUserVMagnitude = 0;
        for(UserSimilarity us : similarityList){
            dotProduct += us.ratingU * us.ratingV;
            ratingOfUserUMagnitude += Utils.square(us.ratingU);
            ratingOfUserVMagnitude += Utils.square(us.ratingV);
        }
        double cosineSimilarity = 0;
        try{
            cosineSimilarity = dotProduct / (Math.sqrt(ratingOfUserUMagnitude) * Math.sqrt(ratingOfUserVMagnitude));
            return cosineSimilarity;
        }catch (Exception e){
            return 0;
        }
    }

    public static double dissimilarityBetweenMovies(Movie movie1, Movie movie2) throws Exception {
        ArrayList<String> genreList = Genre.getGenreList();
        double dotProduct = 0, genreMovie1Magnitude = 0, genreMovie2Magnitude = 0;
        int genreOfMovie1 = 0, genreOfMovie2 = 0;
        for(int i = 0; i < genreList.size(); i++){
            genreOfMovie1 = movie1.genres[i];
            genreOfMovie2 = movie2.genres[i];
            dotProduct += genreOfMovie1 * genreOfMovie2;
            genreMovie1Magnitude += Utils.square(genreOfMovie1);
            genreMovie2Magnitude += Utils.square(genreOfMovie2);
        }
        double cosineSimilary = 0;
        try{
            cosineSimilary = dotProduct / (Math.sqrt(genreMovie1Magnitude) * Math.sqrt(genreMovie2Magnitude));
            return cosineSimilary;
        }catch (Exception e){
            return 0;
        }
    }

}
