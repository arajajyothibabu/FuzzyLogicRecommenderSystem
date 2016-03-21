package utils;

import models.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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

    public static User makeUser(ResultSet user) throws Exception {
        return new User(user.getInt(1), user.getString(2).charAt(0), user.getInt(3), user.getString(4), user.getInt(5));
    }

    public static Movie makeMovie(ResultSet movie, ResultSet genres) throws Exception {
        return new Movie(movie.getInt(1), movie.getString(2), makeGenereList(genres));
    }

    public static Rating makeRating(ResultSet rating) throws Exception {
        return new Rating(rating.getInt(1), rating.getInt(2), rating.getInt(3), rating.getString(4));
    }

    public static Rating makeRating() throws Exception { //for null rating objects in DB
        return new Rating(0, 0, 0, "");
    }

    public static ArrayList<Integer> makeGenereList(ResultSet genreList) throws Exception {
        int genreLength = 19;
        ArrayList<Integer> preparedGenreList = new ArrayList<Integer>();
        for(int i = 1; i <= genreLength; i++)
            preparedGenreList.add(0); //initialised to 0
        if(genreList.next())
        for(int i = 1; i <= genreLength; i++)
            preparedGenreList.add(i-1, genreList.getInt(i)); //updating values if present
        return preparedGenreList;
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


}
