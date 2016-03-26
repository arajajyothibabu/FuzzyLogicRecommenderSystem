package controllers.distance_metrics;

import models.Movie;
import models.User;

/**
 * Created by Araja Jyothi Babu on 26-Mar-16.
 */
public interface DistanceMetrics {

    double dissimilarityBetweenUsers(User userU, User userV) throws Exception;

    double dissimilarityBetweenMovies(Movie movie1, Movie movie2) throws Exception;

}
