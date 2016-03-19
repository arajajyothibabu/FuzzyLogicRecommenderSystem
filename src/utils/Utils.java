package utils;

import models.*;

import java.sql.ResultSet;

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

    public static Movie makeMovie(ResultSet movie) throws Exception {
        return new Movie(movie.getInt(1), movie.getString(2), movie.getString(3));
    }

    public static Rating makeRating(ResultSet rating) throws Exception {
        return new Rating(rating.getInt(1), rating.getInt(2), rating.getInt(3), rating.getString(4));
    }

    public static Rating makeRating() throws Exception { //for null rating objects in DB
        return new Rating(0, 0, 0, "");
    }

    public static double square(double x){
        return x * x;
    }

}
