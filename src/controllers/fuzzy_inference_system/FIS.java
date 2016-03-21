package controllers.fuzzy_inference_system;

import controllers.OracleDAO;
import controllers.distance_metrics.Cosine;
import controllers.distance_metrics.Euclidean;
import controllers.distance_metrics.Manhattan;
import controllers.distance_metrics.PearsonCoefficient;
import models.User;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Araja Jyothi Babu on 21-Mar-16.
 */
public class FIS {

    //TODO:Average rating based on user choice similarity
    public static double userChoiceSimilarity(User user, int K) throws Exception {
        ArrayList<User> otherUsers = OracleDAO.getUsers(user);
        Map<User, Double> euclidianUsers = new HashMap<User, Double>();
        Map<User, Double> manhattanUsers = new HashMap<User, Double>();
        Map<User, Double> pearsonUsers = new HashMap<User, Double>();
        Map<User, Double> cosineUsers = new HashMap<User, Double>();
        for(User currentUser : otherUsers){
            euclidianUsers.put(currentUser, Euclidean.dissimilarityBetweenUsers(user, currentUser));
            manhattanUsers.put(currentUser, Manhattan.dissimilarityBetweenUsers(user, currentUser));
            pearsonUsers.put(currentUser, PearsonCoefficient.dissimilarityBetweenUsers(user, currentUser));
            cosineUsers.put(currentUser, Cosine.dissimilarityBetweenUsers(user, currentUser));
        }
        Map<User, Double> sortedUsers = Utils.sortUsersByDissimilarity(pearsonUsers);
        double sumOfDissimilarity = 0;
        List<User> keys = new ArrayList(sortedUsers.keySet());
        for(int i = 0; i < K; i++) {
            sumOfDissimilarity += sortedUsers.get(sortedUsers.get(keys.get(i)));
        }
        return sumOfDissimilarity/K;
    }

    //TODO:Average rating based on user acceptance rate

}
