package controllers;

import models.Movie;
import models.Rating;
import models.User;
import models.UserSimilarity;
import utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 20-Mar-16.
 */
public class OracleDAO {

    public static Boolean addUser(User user) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        Boolean result = statement.execute("INSERT into users values('" + user.userId + "', '" + user.gender + "', '" + user.age + "', '" + user.occupation + "', '" + user.zipCode + "')");
        DB.closeConnection();
        return result;
    }

    public static Boolean addMovie(Movie movie) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        Boolean result = statement.execute("INSERT into movies values('" + movie.movieId + "', '" + movie.title + "', '" + movie.genres + "'");
        DB.closeConnection();
        return result;
    }

    public static ArrayList<UserSimilarity> getSimilarity(User userU, User userV) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet similarUsersFromDB = statement.executeQuery("SELECT a.movieid, b.userid, a.rating, b.rating FROM ratings a, ratings b where a.userid = '" + userU.userId + "' and a.movieid = b.movieid and b.userid != '" + userV.userId + "'");
        DB.closeConnection();
        ArrayList<UserSimilarity> movieList = new ArrayList<UserSimilarity>();
        while(similarUsersFromDB.next()) {
            movieList.add(Utils.makeSimilarUser(similarUsersFromDB));
        }
        return movieList;
    }

    public static ArrayList<Movie> getMovies() throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet moviesFromDB = statement.executeQuery("SELECT * FROM movies");
        DB.closeConnection();
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        while(moviesFromDB.next()) {
            movieList.add(Utils.makeMovie(moviesFromDB));
        }
        return movieList;
    }

    public static int[] getGenres(int movieId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet movieFromDB = statement.executeQuery("SELECT genres FROM movies where movieid = '" + movieId + "'");
        DB.closeConnection();
        if(movieFromDB.next()) {
            return (int [])movieFromDB.getArray(3).getArray();
        }
        int[] emptyArray = new int[19];
        return emptyArray;
    }

    public static ArrayList<Movie> getMovies(Movie movie) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet moviesFromDB = statement.executeQuery("SELECT * FROM movies where movieid != '" + movie.movieId + "'");
        DB.closeConnection();
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        while(moviesFromDB.next()) {
            movieList.add(Utils.makeMovie(moviesFromDB));
        }
        return movieList;
    }

    public static ArrayList<User> getUsers(User user) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet usersFromDB = statement.executeQuery("SELECT * FROM users where UserId != '" + user.userId + "'");
        DB.closeConnection();
        ArrayList<User> userList = new ArrayList<User>();
        while(usersFromDB.next())
            userList.add(Utils.makeUser(usersFromDB));
        return userList;
    }

    public static ArrayList<User> getUsers() throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet usersFromDB = statement.executeQuery("SELECT * FROM users");
        DB.closeConnection();
        ArrayList<User> userList = new ArrayList<User>();
        while(usersFromDB.next())
            userList.add(Utils.makeUser(usersFromDB));
        return userList;
    }

    public static ArrayList<Rating> getRating() throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet ratingsFromDB = statement.executeQuery("SELECT * FROM ratings");
        DB.closeConnection();
        ArrayList<Rating> ratingList = new ArrayList<Rating>();
        while(ratingsFromDB.next())
            ratingList.add(Utils.makeRating(ratingsFromDB));
        return ratingList;
    }

    public static Rating ratingOfUserToMovie(int userId, int movieId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet ratingOfUserFromDB = statement.executeQuery("SELECT * FROM ratings where movieId ='" + movieId + "' and userId ='" + userId + "'");
        DB.closeConnection();
        if(ratingOfUserFromDB.next())
            return Utils.makeRating(ratingOfUserFromDB);
        return Utils.makeRating(); //not found rating
    }

    public static ArrayList<Rating> getRatingsOfUser(int userId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet ratingsOfUserFromDB = statement.executeQuery("SELECT * FROM ratings where userId ='" + userId + "'");
        DB.closeConnection();
        ArrayList<Rating> ratingList = new ArrayList<Rating>();
        if(ratingsOfUserFromDB.next())
            ratingList.add(Utils.makeRating(ratingsOfUserFromDB));
        return ratingList;
    }
    
}