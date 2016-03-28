package controllers;

import models.*;
import utils.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Araja Jyothi Babu on 20-Mar-16.
 */
public class OracleDAO {

    public static boolean addUser(User user) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        boolean result = statement.execute("INSERT into users values('" + user.userId + "', '" + user.gender + "', '" + user.age + "', '" + user.occupation + "', '" + user.zipCode + "')");
        connection.close();
        return result;
    }

    public static boolean addMovie(Movie movie) throws Exception {
        Connection connection = DB.openConnection();
        Statement statement = connection.createStatement();
        boolean result = statement.execute("INSERT into movies values('" + movie.movieId + "', '" + movie.title + "', '" + movie.genres + "'");
        connection.close();
        return result;
    }

    public static boolean addRating(Rating rating) throws Exception {
        Connection connection = DB.openConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT into ratings values(?,?,?,?)");
        statement.setInt(1, rating.userId);
        statement.setInt(2, rating.movieId);
        statement.setInt(3, rating.rating);
        statement.setDate(4, Date.valueOf(rating.timeStamp));
        boolean result = statement.execute();
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
        ResultSet moviesFromDB = statement.executeQuery("SELECT * FROM movies where movieid = '" + movieId + "'");
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
            returnArray = Utils.objectToIntArray(movieFromDB.getArray(1).getArray());
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

    private static String createQuery(String selectClause, int length) {
        String query = selectClause + " IN (";
        StringBuilder queryBuilder = new StringBuilder(query);
        for( int i = 0; i< length; i++){
            queryBuilder.append(" ?");
            if(i != length -1) queryBuilder.append(",");
        }
        queryBuilder.append(")");
        return queryBuilder.toString();
    }

    //movies rated by user above averageRating
    public static ArrayList<Movie> getMovies(ArrayList<User> users) throws Exception {
        Connection connection = DB.openConnection();
        Statement movieStatement = connection.createStatement();
        int noOfUsers = users.size();
        String selectClause = "SELECT AVG(rating) FROM ratings where userid";
        PreparedStatement ratingStatement = connection.prepareStatement(createQuery(selectClause, noOfUsers));
        for(int i = 0; i < noOfUsers; i++){
            ratingStatement.setInt(i+1, users.get(i).userId);
        }
        ResultSet avgRatingFromDB = ratingStatement.executeQuery();
        double averageRating = 0;
        if(avgRatingFromDB.next()) {
            averageRating = avgRatingFromDB.getDouble(1);
        }
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        selectClause = "SELECT DISTINCT(movieid) from ratings where rating >= '" + averageRating + "' AND userid";
        PreparedStatement moviesStatement = connection.prepareStatement(createQuery(selectClause, noOfUsers));
        for(int i = 0; i < noOfUsers; i++){
            moviesStatement.setInt(i+1, users.get(i).userId);
        }
        ResultSet movieRatedByUser = moviesStatement.executeQuery();
        ResultSet movieFromDB, avgRatingOfMovieFromDB;
        Statement averageRatingToMovie = connection.createStatement();
        while(movieRatedByUser.next()){
            movieFromDB = movieStatement.executeQuery("SELECT * FROM movies where movieid = '" + movieRatedByUser.getInt(1) + "'");
            if(movieFromDB.next()) {
                avgRatingOfMovieFromDB = averageRatingToMovie.executeQuery("SELECT AVG(rating) FROM ratings where movieid = '" + movieRatedByUser.getInt(1) + "'");
                if(avgRatingOfMovieFromDB.next())
                    averageRating = avgRatingOfMovieFromDB.getDouble(1);
                movieList.add(Utils.makeMovie(movieFromDB, averageRating));
            }
        }
        connection.close();
        return movieList;
    }

    public static ArrayList<Movie> getRestOfMovies(ArrayList<MovieRenderModel> movies) throws Exception {
        Connection connection = DB.openConnection();
        int noOfMovies = movies.size();
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        String selectClause = "SELECT * FROM movies WHERE movieid NOT ";
        PreparedStatement movieStatement = connection.prepareStatement(createQuery(selectClause, noOfMovies));
        for(int i = 0; i < noOfMovies; i++){
            movieStatement.setInt(i+1, movies.get(i).movieId);
        }
        ResultSet moviesFromDB = movieStatement.executeQuery();
        Statement avgRatingStatement = connection.createStatement();
        ResultSet averageRatingFromDB;
        double averageRating = 0;
        while(moviesFromDB.next()){
            averageRatingFromDB = avgRatingStatement.executeQuery("SELECT AVG(rating) FROM ratings where movieid = '" + moviesFromDB.getInt(1) + "'");
            if(averageRatingFromDB.next()){
                averageRating = averageRatingFromDB.getDouble(1);
            }
            movieList.add(Utils.makeMovie(moviesFromDB, averageRating));
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
        ResultSet usersFromDB = statement.executeQuery("SELECT * FROM users where userid = '" + userId + "'");
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