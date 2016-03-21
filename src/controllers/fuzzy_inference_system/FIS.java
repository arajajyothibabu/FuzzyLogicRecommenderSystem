package controllers.fuzzy_inference_system;

import controllers.OracleDAO;
import models.User;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 21-Mar-16.
 */
public class FIS {

    //TODO:Average rating based on user choice similarity
    public static double userChoiceSimilarity(User user, int K) throws Exception {
        ArrayList<User> otherUsers = OracleDAO.getUsers(user);
        return 0;
    }

    //TODO:Average rating based on user acceptance rate

}
