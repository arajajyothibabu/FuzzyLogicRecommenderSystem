package utils;

import controllers.OracleDAO;
import models.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Araja Jyothi Babu on 13-Mar-16.
 */
public class Utils {
    public static String replaceNull(String value){
        return value==null? "0" : value;
    }

    public static String replaceNull(String value, String replacingValue){
        return value==null? replacingValue : value;
    }

    public static User makeUser(ResultSet user) throws Exception {
        return new User(user.getInt(1), user.getString(2).charAt(0), user.getInt(3), user.getString(4), user.getInt(5));
        //return new User(user.getInt(1), 'M', 2, "Nothing", 530048);
    }

    public static Movie makeMovie(ResultSet movie, double averageRating) throws Exception {
        return new Movie(movie.getInt(1), movie.getString(2), averageRating, objectToIntArray(movie.getArray(3).getArray()));
    }

    public static int[] objectToIntArray(Object sqlObject) throws Exception {
        String[] strings = (String []) sqlObject;
        int[] returnArray = new int[19];
        for(int i = 0; i < strings.length; i++)
            returnArray[i] = Integer.parseInt(strings[i]);
        return returnArray;
    }

    public static Rating makeRating(ResultSet rating) throws Exception {
        return new Rating(rating.getInt(1), rating.getInt(2), rating.getInt(3), rating.getString(4));
    }

    public static Rating makeRating() throws Exception { //for null rating objects in DB
        return new Rating(0, 0, 0, "");
    }

    public static UserSimilarity makeSimilarUser(ResultSet similarUser) throws Exception {
        return new UserSimilarity(similarUser.getInt(1), similarUser.getInt(2), similarUser.getInt(3), similarUser.getInt(4));
    }

    public static MovieRenderModel makeMovieRender(Movie movie) throws Exception {
        return new MovieRenderModel(movie.movieId, movie.title, movie.rating, movie.genres);
    }

    public static ArrayList<MovieRenderModel> makeMovieRenderList(ArrayList<Movie> movies) throws Exception {
        ArrayList<MovieRenderModel> movieRenderModels = new ArrayList<>();
        for(Movie movie : movies)
            movieRenderModels.add(makeMovieRender(movie));
        return movieRenderModels;
    }

    public static String trimTitle(String title){
        if(title.length() > 18)
            return title.substring(0, 15) + "...";
        else
            return title;
    }

    public static double square(double x){
        return x * x;
    }

    public static Map<User, Double> sortUsersByDissimilarity(Map<User, Double> unSortedMap) {
        // Convert Map to List
        List<Map.Entry<User, Double>> list = new LinkedList<Map.Entry<User, Double>>(unSortedMap.entrySet());
        // Sort list with comparator, to compare the Map values
        Collections.sort(list, new Comparator<Map.Entry<User, Double>>() {
            public int compare(Map.Entry<User, Double> o1, Map.Entry<User, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        // Convert sorted map back to a Map
        Map<User, Double> sortedMap = new LinkedHashMap<User, Double>();
        for (Iterator<Map.Entry<User, Double>> it = list.iterator(); it.hasNext();) {
            Map.Entry<User, Double> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static Map<Movie, Double> sortMoviesByDissimilarity(Map<Movie, Double> unSortedMap) {
        // Convert Map to List
        List<Map.Entry<Movie, Double>> list = new LinkedList<Map.Entry<Movie, Double>>(unSortedMap.entrySet());
        // Sort list with comparator, to compare the Map values
        Collections.sort(list, new Comparator<Map.Entry<Movie, Double>>() {
            public int compare(Map.Entry<Movie, Double> o1, Map.Entry<Movie, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        // Convert sorted map back to a Map
        Map<Movie, Double> sortedMap = new LinkedHashMap<Movie, Double>();
        for (Iterator<Map.Entry<Movie, Double>> it = list.iterator(); it.hasNext();) {
            Map.Entry<Movie, Double> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static enum DistanceMetric {
        Cosine, Euclidean, Manhattan, Pearson
    }

}
