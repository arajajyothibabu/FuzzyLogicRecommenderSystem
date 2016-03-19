package controllers.membership_functions.trapezoidal;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class TrapezoidalInput {

    //Average rating by User

    public static double avgRatingByUser_low(double x){
        if(x < 0 || x >= 2)
            return 0;
        else if(x == 0)
            return (x - 0)/0;
        else if(x >= 0 && x <= 1)
            return 1;
        else
            return (2-x)/(2-1);
    }

    public static double avgRatingByUser_medium(double x){
        if(x < 0 || x >= 4)
            return 0;
        else if(x >= 0 && x <= 2)
            return (x -0)/(2);
        else if(x >= 2 && x <= 3)
            return 1;
        else
            return (4-x)/(4-3);
    }

    public static double avgRatingByUser_high(double x){
        if(x < 3 || x >= 5)
            return 0;
        else if(x >= 3 && x <= 4)
            return (x -3)/(4-3);
        else if(x >= 4 && x <= 5)
            return 1;
        else
            return (5-x)/(0);
    }

    //Average rating to movie

    public static double avgRatingToMovie_low(double x){
        if(x < 0 || x >= 2)
            return 0;
        else if(x == 0)
            return (x - 0)/0;
        else if(x >= 0 && x <= 1)
            return 1;
        else
            return (2-x)/(2-1);
    }

    public static double avgRatingToMovie_medium(double x){
        if(x < 0 || x >= 4)
            return 0;
        else if(x >= 0 && x <= 2)
            return (x -0)/(2);
        else if(x >= 2 && x <= 3)
            return 1;
        else
            return (4-x)/(4-3);
    }

    public static double avgRatingToMovie_high(double x){
        if(x < 3 || x >= 5)
            return 0;
        else if(x >= 3 && x <= 4)
            return (x -3)/(4-3);
        else if(x >= 4 && x <= 5)
            return 1;
        else
            return (5-x)/(0);
    }

}
