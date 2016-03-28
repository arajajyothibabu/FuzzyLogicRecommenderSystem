package controllers.services;

import controllers.OracleDAO;
import models.Movie;
import models.Rating;
import models.User;
import models.UserSimilarity;
import utils.DB;
import utils.Utils;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 27-Mar-16.
 */
public class UserDataService {

    private static String tableName = "users";
    private static String authTable = "authusers";

    public static boolean addUser(User user) throws Exception {
        boolean isAdded = OracleDAO.addUser(user);
        return isAdded;
    }

    public static ArrayList<User> getUsers(User user) throws Exception {
        ArrayList<User> userList = OracleDAO.getUsers(user);
        return userList;
    }

    public static User getUser(int userId) throws Exception {
        User user = OracleDAO.getUser(userId);
        return user;
    }

    public static ArrayList<User> getUsers() throws Exception {
        ArrayList<User> userList = OracleDAO.getUsers();
        return userList;
    }

}
