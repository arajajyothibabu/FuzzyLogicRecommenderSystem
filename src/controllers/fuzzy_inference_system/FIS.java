package controllers.fuzzy_inference_system;

import controllers.distance_metrics.*;
import controllers.services.MovieDataService;
import controllers.services.UserDataService;
import models.Movie;
import models.MovieRenderModel;
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

    public static DistanceMetrics selectMethod(String method){
        switch (Utils.DistanceMetric.valueOf(method)){
            case Cosine: return new Cosine();
            case Manhattan: return new Manhattan();
            case Euclidean: return new Euclidean();
            case Pearson: return new PearsonCoefficient();
            default: return new PearsonCoefficient();
        }
    }

    public static Map<User, Double> similarUsers(User user, String method) throws Exception {
        ArrayList<User> otherUsers = UserDataService.getUsers(user);
        Map<User, Double> similarUsers = new HashMap<User, Double>();
        for(User currentUser : otherUsers){
            similarUsers.put(currentUser, selectMethod(method).dissimilarityBetweenUsers(user, currentUser));
        }
        return similarUsers;
    }

    public static Map<Movie, Double> similarMovies(Movie movie, String method) throws Exception {
        ArrayList<Movie> otherMovies = MovieDataService.getMovies(movie);
        Map<Movie, Double> similarMovies = new HashMap<Movie, Double>();
        for(Movie currentMovie : otherMovies){
            similarMovies.put(currentMovie, selectMethod(method).dissimilarityBetweenMovies(movie, currentMovie));
        }
        return similarMovies;
    }

    public static double choiceSimilarity(User user, int K, String method) throws Exception {
        Map<User, Double> sortedUsers = similarUsers(user, method);
        double sumOfDissimilarity = 0;
        K = sortedUsers.size() < K ? sortedUsers.size() : K;
        List<User> keys = new ArrayList(sortedUsers.keySet());
        for(int i = 0; i < K; i++) {
            sumOfDissimilarity += sortedUsers.get(sortedUsers.get(keys.get(i)));
        }
        return sumOfDissimilarity / K;
    }

    public static ArrayList<User> similarKUsers(User user, int K, String method) throws Exception {
        ArrayList<User> similarUsers = new ArrayList<>();
        Map<User, Double> sortedUsers = similarUsers(user, method);
        K = sortedUsers.size() < K ? sortedUsers.size() : K;
        List<User> keys = new ArrayList(sortedUsers.keySet());
        for(int i = 0; i < K; i++) {
            similarUsers.add(keys.get(i));
        }
        return similarUsers;
    }

    public static double acceptanceRate(Movie movie, int K, String method) throws Exception {
        //FIXME: need to do properly for all methods
        Map<Movie, Double> sortedMovies = similarMovies(movie, method);
        double sumOfDissimilarity = 0;
        K = sortedMovies.size() < K ? sortedMovies.size() : K;
        List<User> keys = new ArrayList(sortedMovies.keySet());
        for(int i = 0; i < K; i++) {
            sumOfDissimilarity += sortedMovies.get(sortedMovies.get(keys.get(i)));
        }
        return sumOfDissimilarity / K;
    }

    public static ArrayList<Movie> similarKMovies(Movie movie, int K, String method) throws Exception {
        ArrayList<Movie> similarMovies = new ArrayList<>();
        Map<Movie, Double> sortedMovies = similarMovies(movie, method);
        K = sortedMovies.size() < K ? sortedMovies.size() : K;
        List<Movie> keys = new ArrayList(sortedMovies.keySet());
        for(int i = 0; i < K; i++) {
            similarMovies.add(keys.get(i));
        }
        return similarMovies;
    }

    public static ArrayList<ArrayList<MovieRenderModel>> processedMovies(int userId, int K, String method) throws Exception {
        User user = UserDataService.getUser(userId);
        ArrayList<MovieRenderModel> recommendedMovieList =  Utils.makeMovieRenderList(MovieDataService.getMovies(similarKUsers(user, K, method)));
        ArrayList<MovieRenderModel> restOfMoviesList =  Utils.makeMovieRenderList(MovieDataService.getRestOfMovies(recommendedMovieList));
        ArrayList<ArrayList<MovieRenderModel>> processedMovieList =  new ArrayList<>();
        processedMovieList.add(recommendedMovieList);
        processedMovieList.add(restOfMoviesList);
        return processedMovieList;
    }

    public static ArrayList<MovieRenderModel> processedMovies() throws Exception {
        ArrayList<MovieRenderModel> movieList =  Utils.makeMovieRenderList(MovieDataService.getMovies());
        return movieList;
    }

    public static ArrayList<MovieRenderModel> relatedMovies(int movieId, int K, String method) throws Exception {
        Movie movie = MovieDataService.getMovie(movieId);
        ArrayList<MovieRenderModel> movieList =  Utils.makeMovieRenderList(similarKMovies(movie, K, method));
        return movieList;
    }

}
