package utils;

/**
 * Created by Araja Jyothi Babu on 13-Mar-16.
 */
import models.Movie;
import models.Rating;
import models.User;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    private static String DBURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String DBUSER = "system";
    private static String DBPASS = "tiger";
    private static Connection connection;

    public DB() {

    }

    public static Connection openConnection() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS );

        return connection;

    }

    public static void closeConnection() throws Exception {
        connection.close();
    }

    public static Boolean commitDB() throws Exception {
        Statement commitStatement = connection.createStatement();
        return commitStatement.execute("COMMIT");
    }

    public static ArrayList<Movie> getMovies() throws Exception {
        connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet moviesFromDB = statement.executeQuery("SELECT * FROM movies");
        ArrayList<Movie> movieList = new ArrayList<>();
        while(moviesFromDB.next())
            movieList.add(Utils.makeMovie(moviesFromDB));
        return movieList;
    }

    public static ArrayList<User> getUsers(String userId) throws Exception {
        connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet usersFromDB = statement.executeQuery("SELECT * FROM users where UserId != '" + userId + "'");
        ArrayList<User> userList = new ArrayList<>();
        while(usersFromDB.next())
            userList.add(Utils.makeUser(usersFromDB));
        return userList;
    }

    public static ArrayList<User> getUsers() throws Exception {
        connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet usersFromDB = statement.executeQuery("SELECT * FROM users");
        ArrayList<User> userList = new ArrayList<>();
        while(usersFromDB.next())
            userList.add(Utils.makeUser(usersFromDB));
        return userList;
    }

    public static ArrayList<Rating> getRating() throws Exception {
        connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet ratingsFromDB = statement.executeQuery("SELECT * FROM ratings");
        ArrayList<Rating> ratingList = new ArrayList<>();
        while(ratingsFromDB.next())
            ratingList.add(Utils.makeRating(ratingsFromDB));
        return ratingList;
    }

    public static Rating ratingOfUserToMovie(int userId, int movieId) throws Exception {
        connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet ratingOfUserFromDB = statement.executeQuery("SELECT * FROM ratings where movieId ='" + movieId + "' and userId ='" + userId + "'");
        if(ratingOfUserFromDB.next())
            return Utils.makeRating(ratingOfUserFromDB);
        return Utils.makeRating(); //not found rating
    }

}
