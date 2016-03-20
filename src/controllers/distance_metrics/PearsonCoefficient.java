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
        int actualNumberOfRatingsByUser = ratingsCount > 0 ? ratingsCount : 1;
        double averageRating = totalRating / actualNumberOfRatingsByUser;
        return averageRating;
    }

    public static double averageGenreOfMovie(Movie movie) throws Exception {
        double totalGenre = 0;
        ArrayList<Integer> genresOfMovie = Utils.makeGenereList(OracleDAO.getGenres(movie.movieID));
        for(Integer genre : genresOfMovie)
            totalGenre += genre.intValue();
        double averageGenre = totalGenre / genresOfMovie.size();
        return averageGenre;
    }

    public static double dissimilarityBetweenUsers(User userU, User userV) throws Exception{
        ArrayList<Movie> movieList = OracleDAO.getMovies();
        double numeratorSum = 0, denominatorUserUSum = 0, denominatorUserVSum = 0, userUDifference = 0, userVDifference = 0;
        double averageRatingOfUserU = averageRatingOfUser(userU);
        double averageRatingOfUserV = averageRatingOfUser(userV);
        int ratingOfUserUForSingleMovie = 0, ratingOfUserVForSingleMovie = 0;
        for(Movie movie : movieList){
            ratingOfUserUForSingleMovie = OracleDAO.ratingOfUserToMovie(userU.userId, movie.movieID).rating;
            ratingOfUserVForSingleMovie = OracleDAO.ratingOfUserToMovie(userV.userId, movie.movieID).rating;
            userUDifference = ratingOfUserUForSingleMovie - averageRatingOfUserU;
            userVDifference = ratingOfUserVForSingleMovie - averageRatingOfUserV;
            numeratorSum += userUDifference * userVDifference;
            denominatorUserUSum += Utils.square(userUDifference);
            denominatorUserVSum += Utils.square(userVDifference);
        }
        return numeratorSum / (Math.sqrt(denominatorUserUSum) * Math.sqrt(denominatorUserVSum));
    }

    public static double dissimilarityBetweenMovies(Movie movie1, Movie movie2) throws Exception {
        ArrayList<String> genreList = Genre.getGenreList();
        int noOfGenres = genreList.size();
        double numeratorSum = 0, denominatorMovie1GenreSum = 0, denominatorMovie2GenreSum = 0, movie1Difference = 0, movie2Difference = 0;
        double averageGenreOfMovie1 = averageGenreOfMovie(movie1);
        double averageGenreOfMovie2 = averageGenreOfMovie(movie2);
        for(int i = 0; i < noOfGenres; i++){
            movie1Difference = movie1.genres.get(i) - averageGenreOfMovie1;
            movie2Difference = movie2.genres.get(i) - averageGenreOfMovie2;
            numeratorSum += movie1Difference * movie2Difference;
            denominatorMovie1GenreSum += Utils.square(movie1Difference);
            denominatorMovie2GenreSum += Utils.square(movie2Difference);
        }
        return numeratorSum / (Math.sqrt(denominatorMovie1GenreSum) * Math.sqrt(denominatorMovie2GenreSum));
    }

}
