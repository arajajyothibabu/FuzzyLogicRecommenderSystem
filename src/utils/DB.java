package utils;

/**
 * Created by Araja Jyothi Babu on 13-Mar-16.
 */
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

    public static ResultSet getMovies() throws Exception {
        connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet movieList = statement.executeQuery("SELECT * FROM movies");
        return movieList;
    }

    public static ArrayList<User> getUsers(String userId) throws Exception {
        connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet userList = statement.executeQuery("SELECT * FROM users where UserId != '" + userId + "'");
        ArrayList<User> users = new ArrayList<>();
        while(userList.next())
            users.add(new )
    }

    public static ResultSet getUsers() throws Exception {
        connection = openConnection();
        Statement statement = connection.createStatement();
        ResultSet userList = statement.executeQuery("SELECT * FROM users");
        return userList;
    }

}
