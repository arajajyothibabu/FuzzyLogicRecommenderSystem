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

    private OracleDAO dao;

    public UserDataService(OracleDAO dao) {
        this.dao = dao;
    }

    public boolean addUser(User user) throws Exception {
        boolean isAdded = dao.addUser(user);
        return isAdded;
    }

    public ArrayList<UserSimilarity> getSimilarity(User userU, User userV) throws Exception {
        ArrayList<UserSimilarity> movieList = dao.getSimilarity(userU, userV);
        return movieList;
    }

    public ArrayList<User> getUsers(User user) throws Exception {
        ArrayList<User> userList = dao.getUsers(user);
        return userList;
    }

    public User getUser(int userId) throws Exception {
        User user = dao.getUser(userId);
        return user;
    }

    public ArrayList<User> getUsers() throws Exception {
        ArrayList<User> userList = dao.getUsers();
        return userList;
    }

}
