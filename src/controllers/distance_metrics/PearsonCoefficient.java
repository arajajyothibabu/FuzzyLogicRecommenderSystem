package controllers.distance_metrics;

import controllers.services.MovieDataService;
import controllers.services.RatingDataService;
import controllers.services.UserDataService;
import models.*;
import utils.Utils;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 16-Mar-16.
 */
public class PearsonCoefficient implements DistanceMetrics {

    public static double averageRatingOfUser(User user) throws Exception {
        double totalRating = 0;
        ArrayList<Rating> ratingsOfUser = RatingDataService.getRatingsOfUser(user.userId);
        for(Rating rating : ratingsOfUser)
            totalRating += rating.rating;
        int ratingsCount = ratingsOfUser.size();
        int actualNumberOfRatingsByUser = ratingsCount > 0 ? ratingsCount : 1;
        double averageRating = totalRating / actualNumberOfRatingsByUser;
        return averageRating;
    }

    public static double averageGenreOfMovie(Movie movie) throws Exception {
        double totalGenre = 0;
        int[] genresOfMovie = MovieDataService.getGenres(movie.movieId);
        for(int i = 0; i < genresOfMovie.length; i++)
            totalGenre += genresOfMovie[i];
        double averageGenre = totalGenre / genresOfMovie.length;
        return averageGenre;
    }

    public double dissimilarityBetweenUsers(User userU, User userV) throws Exception{
        ArrayList<UserSimilarity> similarityList = UserDataService.getSimilarity(userU, userV);
        double numeratorSum = 0, denominatorUserUSum = 0, denominatorUserVSum = 0, userUDifference = 0, userVDifference = 0;
        double averageRatingOfUserU = averageRatingOfUser(userU);
        double averageRatingOfUserV = averageRatingOfUser(userV);
        for(UserSimilarity us : similarityList){
            userUDifference = us.ratingU - averageRatingOfUserU;
            userVDifference = us.ratingV - averageRatingOfUserV;
            numeratorSum += userUDifference * userVDifference;
            denominatorUserUSum += Utils.square(userUDifference);
            denominatorUserVSum += Utils.square(userVDifference);
        }
        return numeratorSum / (Math.sqrt(denominatorUserUSum) * Math.sqrt(denominatorUserVSum));
    }

    public double dissimilarityBetweenMovies(Movie movie1, Movie movie2) throws Exception {
        ArrayList<String> genreList = Genre.getGenreList();
        int noOfGenres = genreList.size();
        double numeratorSum = 0, denominatorMovie1GenreSum = 0, denominatorMovie2GenreSum = 0, movie1Difference = 0, movie2Difference = 0;
        double averageGenreOfMovie1 = averageGenreOfMovie(movie1);
        double averageGenreOfMovie2 = averageGenreOfMovie(movie2);
        for(int i = 0; i < noOfGenres; i++){
            movie1Difference = movie1.genres[i] - averageGenreOfMovie1;
            movie2Difference = movie2.genres[i] - averageGenreOfMovie2;
            numeratorSum += movie1Difference * movie2Difference;
            denominatorMovie1GenreSum += Utils.square(movie1Difference);
            denominatorMovie2GenreSum += Utils.square(movie2Difference);
        }
        return numeratorSum / (Math.sqrt(denominatorMovie1GenreSum) * Math.sqrt(denominatorMovie2GenreSum));
    }

}
