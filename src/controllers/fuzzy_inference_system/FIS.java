package controllers.fuzzy_inference_system;

import controllers.OracleDAO;
import controllers.distance_metrics.Cosine;
import controllers.distance_metrics.Euclidean;
import controllers.distance_metrics.Manhattan;
import controllers.distance_metrics.PearsonCoefficient;
import models.Movie;
import models.User;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Araja Jyothi Babu on 21-Mar-16.
 */
public class FIS {

    public static double choiceSimilarity(User user, int K) throws Exception {
        ArrayList<User> otherUsers = OracleDAO.getUsers(user);
        Map<User, Double> euclidianUsers = new HashMap<User, Double>();
        Map<User, Double> manhattanUsers = new HashMap<User, Double>();
        Map<User, Double> pearsonUsers = new HashMap<User, Double>();
        Map<User, Double> cosineUsers = new HashMap<User, Double>();
        for(User currentUser : otherUsers){
            euclidianUsers.put(currentUser, Euclidean.dissimilarityBetweenUsers(user, currentUser));
            manhattanUsers.put(currentUser, Manhattan.dissimilarityBetweenUsers(user, currentUser));
            pearsonUsers.put(currentUser, PearsonCoefficient.dissimilarityBetweenUsers(user, currentUser));
            cosineUsers.put(currentUser, Cosine.dissimilarityBetweenUsers(user, currentUser));
        }
        //FIXME: need to do properly for all methods
        Map<User, Double> sortedUsers = Utils.sortUsersByDissimilarity(pearsonUsers);
        double sumOfDissimilarity = 0;
        List<User> keys = new ArrayList(sortedUsers.keySet());
        for(int i = 0; i < K; i++) {
            sumOfDissimilarity += sortedUsers.get(sortedUsers.get(keys.get(i)));
        }
        return sumOfDissimilarity / K;
    }

    public static double acceptanceRate(Movie movie, int K) throws Exception {
        ArrayList<Movie> otherMovies = OracleDAO.getMovies(movie);
        Map<Movie, Double> euclidianMovies = new HashMap<Movie, Double>();
        Map<Movie, Double> manhattanMovies = new HashMap<Movie, Double>();
        Map<Movie, Double> pearsonMovies = new HashMap<Movie, Double>();
        Map<Movie, Double> cosineMovies = new HashMap<Movie, Double>();
        for(Movie currentMovie : otherMovies){
            euclidianMovies.put(currentMovie, Euclidean.dissimilarityBetweenMovies(movie, currentMovie));
            manhattanMovies.put(currentMovie, Manhattan.dissimilarityBetweenMovies(movie, currentMovie));
            pearsonMovies.put(currentMovie, PearsonCoefficient.dissimilarityBetweenMovies(movie, currentMovie));
            cosineMovies.put(currentMovie, Cosine.dissimilarityBetweenMovies(movie, currentMovie));
        }
        //FIXME: need to do properly for all methods
        Map<Movie, Double> sortedMovies = Utils.sortMoviesByDissimilarity(pearsonMovies);
        double sumOfDissimilarity = 0;
        List<User> keys = new ArrayList(sortedMovies.keySet());
        for(int i = 0; i < K; i++) {
            sumOfDissimilarity += sortedMovies.get(sortedMovies.get(keys.get(i)));
        }
        return sumOfDissimilarity / K;
    }

}
