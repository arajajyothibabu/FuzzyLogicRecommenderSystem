package includes.membership_functions.triangular;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class TriangularInput {

    //Average rating by User

    public static double avgRatingByUser_low(double x){
        if(x < 0 || x >= 2.5)
            return 0;
        else
            return (2.5 - x)/2.5;
    }

    public static double avgRatingByUser_medium(double x){
        if(x <= 1 || x >= 4.0)
            return 0;
        else if(x >= 1 && x <= 2.5)
            return (x - 1) / 1.5;
        else
            return (4 - x) / 1.5;
    }

    public static double avgRatingByUser_high(double x){
        if(x < 2.5 || x > 5)
            return 0;
        else
            return (x - 2.5)/2.5;
    }

    //Average rating to movie

    public static double avgRatingToMovie_low(double x){
        if(x < 0 || x >= 2.5)
            return 0;
        else
            return (2.5 - x)/2.5;
    }

    public static double avgRatingToMovie_medium(double x){
        if(x <= 1 || x >= 4.0)
            return 0;
        else if(x >= 1 && x <= 2.5)
            return (x - 1) / 1.5;
        else
            return (4 - x) / 1.5;
    }

    public static double avgRatingToMovie_high(double x){
        if(x < 2.5 || x > 5)
            return 0;
        else
            return (x - 2.5)/2.5;
    }

}