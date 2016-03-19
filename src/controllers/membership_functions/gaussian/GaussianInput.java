package controllers.membership_functions.gaussian;

import utils.Utils;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class GaussianInput {

    public static double makeInputToExp(double x, double m, double sigma) {
        return -(0.5) * Utils.square((x - m) / sigma);
    }

    public static double exp(double value){
        return Math.exp(value);
    }
    //Average rating by User

    public static double avgRatingByUser_low(double x){
        return exp(makeInputToExp(x, 0, 0.8493));
    }

    public static double avgRatingByUser_medium(double x){
        return exp(makeInputToExp(x, 2.5, 0.48));
    }

    public static double avgRatingByUser_high(double x){
        return exp(makeInputToExp(x, 2.5, 0.48));
    }

    //Average rating to movie

    public static double avgRatingToMovie_low(double x){
        return exp(makeInputToExp(x, 0, 0.8493));
    }

    public static double avgRatingToMovie_medium(double x){
        return exp(makeInputToExp(x, 2.5, 0.48));
    }

    public static double avgRatingToMovie_high(double x){
        return exp(makeInputToExp(x, 5, 0.8493));
    }
}
