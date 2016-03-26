package controllers;

import models.Movie;
import models.Rating;
import models.User;
import models.UserSimilarity;
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
        connection.close();
        return result;
    }

    public static Boolean addMovie(Movie movie) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        Boolean result = statement.execute("INSERT into movies values('" + movie.movieId + "', '" + movie.title + "', '" + movie.genres + "'");
        connection.close();
        return result;
    }

    public static ArrayList<UserSimilarity> getSimilarity(User userU, User userV) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet similarUsersFromDB = statement.executeQuery("SELECT a.movieid, b.userid, a.rating, b.rating FROM ratings a, ratings b where a.userid = '" + userU.userId + "' and a.movieid = b.movieid and b.userid != '" + userV.userId + "'");
        ArrayList<UserSimilarity> movieList = new ArrayList<UserSimilarity>();
        while(similarUsersFromDB.next()) {
            movieList.add(Utils.makeSimilarUser(similarUsersFromDB));
        }
        connection.close();
        return movieList;
    }

    public static ArrayList<Movie> getMovies() throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        Statement ratingStatement = connection.createStatement();
        ResultSet moviesFromDB = statement.executeQuery("SELECT * FROM movies");
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        ResultSet avgRatingFromDB;
        double averageRating = 0;
        while(moviesFromDB.next()) {
            avgRatingFromDB = ratingStatement.executeQuery("SELECT AVG(rating) FROM ratings where movieid = '" + moviesFromDB.getInt(1) + "'");
            if(avgRatingFromDB.next()) {
                averageRating = avgRatingFromDB.getDouble(1);
            }
            movieList.add(Utils.makeMovie(moviesFromDB, averageRating));
        }
        connection.close();
        return movieList;
    }

    public static Movie getMovie(int movieId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        Statement ratingStatement = connection.createStatement();
        ResultSet moviesFromDB = statement.executeQuery("SELECT * FROM movies");
        Movie movie = new Movie(movieId, "No Name",0, new int[19]); //dummy movie object
        ResultSet avgRatingFromDB;
        double averageRating = 0;
        if(moviesFromDB.next()) {
            avgRatingFromDB = ratingStatement.executeQuery("SELECT AVG(rating) FROM ratings where movieid = '" + moviesFromDB.getInt(1) + "'");
            if(avgRatingFromDB.next()) {
                averageRating = avgRatingFromDB.getDouble(1);
            }
            movie = Utils.makeMovie(moviesFromDB, averageRating);
        }
        connection.close();
        return movie;
    }

    public static int[] getGenres(int movieId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet movieFromDB = statement.executeQuery("SELECT genres FROM movies where movieid = '" + movieId + "'");
        int[] returnArray = new int[19];
        if(movieFromDB.next()) {
            returnArray = Utils.objectToIntArray(movieFromDB.getArray(3).getArray());
        }
        connection.close();
        return returnArray;
    }

    public static double getAverageRatingToMovie(int movieId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        double averageRating = 0;
        ResultSet avgRatingFromDB = statement.executeQuery("SELECT AVG(rating) FROM ratings where movieid = '" + movieId + "'");
        if(avgRatingFromDB.next()) {
            averageRating = avgRatingFromDB.getDouble(1);
        }
        connection.close();
        return averageRating;
    }

    //movies rated by user above averageRating
    public static ArrayList<Movie> getMovies(ArrayList<User> users) throws Exception {
        Connection connection = DB.openConnection();
        Statement movieStatement = connection.createStatement();
        Statement moviesStatement = connection.createStatement();
        Statement ratingStatement = connection.createStatement();
        ResultSet avgRatingFromDB = ratingStatement.executeQuery("SELECT AVG(rating) FROM ratings where userid IN '" + users + "'");
        double averageRating = 0;
        if(avgRatingFromDB.next()) {
            averageRating = avgRatingFromDB.getDouble(1);
        }
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        ResultSet movieRatedByUser = movieStatement.executeQuery("SELECT movieid from ratings where rating >= '" + averageRating + "' AND userid IN '" + users + "'");
        ResultSet moviesFromDB;
        while(movieRatedByUser.next()){
            moviesFromDB = moviesStatement.executeQuery("SELECT * FROM movies where movieid == '" + movieRatedByUser.getInt(1) + "'");
            if(moviesFromDB.next()) {
                movieList.add(Utils.makeMovie(moviesFromDB, averageRating));
            }
        }
        connection.close();
        return movieList;
    }

    public static ArrayList<Movie> getMovies(Movie movie) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        Statement ratingStatement = connection.createStatement();
        ResultSet moviesFromDB = statement.executeQuery("SELECT * FROM movies where movieid != '" + movie.movieId + "'");
        ResultSet avgRatingFromDB;
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        while(moviesFromDB.next()) {
            avgRatingFromDB = ratingStatement.executeQuery("SELECT AVG(rating) FROM ratings where movieid = '" + moviesFromDB.getInt(1) + "'");
            double averageRating = 0;
            if(avgRatingFromDB.next()) {
                averageRating = avgRatingFromDB.getDouble(1);
            }
            movieList.add(Utils.makeMovie(moviesFromDB, averageRating));
        }
        connection.close();
        return movieList;
    }

    public static ArrayList<User> getUsers(User user) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet usersFromDB = statement.executeQuery("SELECT * FROM users where UserId != '" + user.userId + "'");
        ArrayList<User> userList = new ArrayList<User>();
        while(usersFromDB.next())
            userList.add(Utils.makeUser(usersFromDB));
        connection.close();
        return userList;
    }

    public static User getUser(int userId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet usersFromDB = statement.executeQuery("SELECT * FROM users where UserId == '" + userId + "'");
        User user = new User(userId,'M',1,"",530048); //for user not found case : default user
        if(usersFromDB.next())
            user = Utils.makeUser(usersFromDB);
        connection.close();
        return user;
    }

    public static ArrayList<User> getUsers() throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet usersFromDB = statement.executeQuery("SELECT * FROM users");
        ArrayList<User> userList = new ArrayList<User>();
        while(usersFromDB.next())
            userList.add(Utils.makeUser(usersFromDB));
        connection.close();
        return userList;
    }

    public static ArrayList<Rating> getRating() throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet ratingsFromDB = statement.executeQuery("SELECT * FROM ratings");
        ArrayList<Rating> ratingList = new ArrayList<Rating>();
        while(ratingsFromDB.next())
            ratingList.add(Utils.makeRating(ratingsFromDB));
        connection.close();
        return ratingList;
    }

    public static Rating ratingOfUserToMovie(int userId, int movieId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet ratingOfUserFromDB = statement.executeQuery("SELECT * FROM ratings where movieId ='" + movieId + "' and userId ='" + userId + "'");
        Rating rating = Utils.makeRating(); //not found rating
        if(ratingOfUserFromDB.next())
            rating = Utils.makeRating(ratingOfUserFromDB);
        DB.closeConnection();
        return rating;
    }

    public static ArrayList<Rating> getRatingsOfUser(int userId) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        ResultSet ratingsOfUserFromDB = statement.executeQuery("SELECT * FROM ratings where userId ='" + userId + "'");
        ArrayList<Rating> ratingList = new ArrayList<Rating>();
        if(ratingsOfUserFromDB.next())
            ratingList.add(Utils.makeRating(ratingsOfUserFromDB));
        DB.closeConnection();
        return ratingList;
    }
    
}