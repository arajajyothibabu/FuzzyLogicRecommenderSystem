package controllers.distance_metrics;

import controllers.OracleDAO;
import models.Genre;
import models.Movie;
import models.User;
import utils.Utils;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 16-Mar-16.
 */
public class Cosine {

    public static double dissimilarityBetweenUsers(User userU, User userV) throws Exception{
        ArrayList<Movie> movieList = OracleDAO.getMovies();
        double dotProduct = 0, ratingOfUserU = 0, ratingOfUserV = 0, ratingOfUserUMagnitude = 0, ratingOfUserVMagnitude = 0;
        for(Movie movie : movieList){
            ratingOfUserU = OracleDAO.ratingOfUserToMovie(userU.userId, movie.movieId).rating;
            ratingOfUserV = OracleDAO.ratingOfUserToMovie(userV.userId, movie.movieId).rating;
            dotProduct += ratingOfUserU * ratingOfUserV;
            ratingOfUserUMagnitude += Utils.square(ratingOfUserU);
            ratingOfUserVMagnitude += Utils.square(ratingOfUserV);
        }
        double cosineSimilary = 0;
        try{
            cosineSimilary = dotProduct / (Math.sqrt(ratingOfUserUMagnitude) * Math.sqrt(ratingOfUserVMagnitude));
            return cosineSimilary;
        }catch (Exception e){
            return 0;
        }
    }

    public static double dissimilarityBetweenMovies(Movie movie1, Movie movie2) throws Exception {
        ArrayList<String> genreList = Genre.getGenreList();
        double dotProduct = 0, genreMovie1Magnitude = 0, genreMovie2Magnitude = 0;
        int genreOfMovie1 = 0, genreOfMovie2 = 0;
        for(int i = 0; i < genreList.size(); i++){
            genreOfMovie1 = movie1.genres.get(i);
            genreOfMovie2 = movie2.genres.get(i);
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
