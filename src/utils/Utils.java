package utils;

import models.User;

import java.sql.ResultSet;

/**
 * Created by Araja Jyothi Babu on 13-Mar-16.
 */
public class Utils {
    public static String replaceNull(String value){
        return value==null? "0" : value;
    }

    public User generateUser(ResultSet user) throws Exception {
        return new User(user.getInt(1), user.getString(2).charAt(0), user.getInt(3), user.getString(4), user.getInt(5));
    }
}
