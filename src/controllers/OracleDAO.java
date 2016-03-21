package controllers;

import models.Movie;
import models.Rating;
import models.User;
import utils.*;

import java.sql.Connection;
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
        // FIXME: movie.genres are used here to update genre values
        Statement genres = connection.prepareStatement("INSERT into users values('" + 1 + "', '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + 1 + "')");
        ResultSet genreId = statement.executeQuery("SELECT MAX(genreid) from genres");
        if(genreId.next()){
            Boolean result = statement.execute("INSERT into movies values('" + movie.movieId + "', '" + movie.title + "', '" + genreId.getInt(1) + "'");
            DB.closeConnection();
            return result;
        }
        DB.closeConnection();
        return false;
    }

    public static ArrayList<Movie> getMovies() throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet moviesFromDB = statement.executeQuery("SELECT * FROM movies");
        DB.closeConnection();
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        while(moviesFromDB.next()) {
            movieList.add(Utils.makeMovie(moviesFromDB, getGenres(moviesFromDB.getInt(3))));
        }
        return movieList;
    }

    public static ResultSet getGenres(int movieId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet genresFromDB = statement.executeQuery("SELECT * FROM genres where MovieId ='" + movieId + "'");
        DB.closeConnection();
        return genresFromDB;
    }

    public static ArrayList<User> getUsers(String userId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet usersFromDB = statement.executeQuery("SELECT * FROM users where UserId != '" + userId + "'");
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