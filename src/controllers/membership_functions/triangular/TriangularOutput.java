package controllers.membership_functions.triangular;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class TriangularOutput {

    //3 output membership functions
    public static double acceptanceRate3_low(double x){
        if(x < 0 || x >= 2.5)
            return 0;
        else
            return (2.5 - x)/2.5;
    }

    public static double acceptanceRate3_medium(double x){
        if(x <= 1 || x >= 4.0)
            return 0;
        else if(x >= 1 && x <= 2.5)
            return (x - 1) / 1.5;
        else
            return (4 - x) / 1.5;
    }

    public static double acceptanceRate3_high(double x){
        if(x < 2.5 || x > 5)
            return 0;
        else
            return (x - 2.5)/2.5;
    }

    //4 output membership functions
    public static double acceptanceRate4_veryLow(double x){
        if(x < 0 || x >= 1.5)
            return 0;
        else
            return (1.5 - x)/1.5;
    }

    public static double acceptanceRate4_low(double x){
        if(x <= 0.25 || x >= 3.25)
            return 0;
        else if(x >= 0.25 && x <= 1.75)
            return (x - 0.25) / 1.5;
        else
            return (3.25 - x)/1.5;
    }

    public static double acceptanceRate4_medium(double x){
        if(x <= 1.75 || x >= 4.75)
            return 0;
        else if(x >= 1.75 && x <= 3.25)
            return (x - 1.75) / 1.5;
        else
            return (4.75 - x) / 1.5;
    }

    public static double acceptanceRate4_high(double x){
        if(x < 3.5 || x > 5)
            return 0;
        else
            return (x - 3.5)/1.5;
    }

    //5 output membership functions
    public static double acceptanceRate5_veryLow(double x){
        if(x < 0 || x >= 1.25)
            return 0;
        else
            return (1.25-x)/(1.25);
    }

    public static double acceptanceRate5_low(double x){
        if(x <= 0 || x >= 2.5)
            return 0;
        else if(x >= 0 && x <= 1.25)
            return (x)/(1.25);
        else
            return (2.5-x)/(1.25);
    }

    public static double acceptanceRate5_medium(double x){
        if(x <= 1.25 || x >= 3.75)
            return 0;
        else if(x >= 1.25 && x <= 2.5)
            return (x -1.25)/(1.5);
        else
            return (3.75-x)/(1.25);
    }

    public static double acceptanceRate5_high(double x){
        if(x <= 2.5 || x >= 5)
            return 0;
        else if(x >= 2.5 && x <= 3.75)
            return (x -2.5)/(1.25);
        else
            return (5-x)/(1.25);
    }

    public static double acceptanceRate5_veryhigh(double x){
        if(x <= 3.75 || x >= 5)
            return 0;
        else
            return (x-3.75)/(1.25);
    }
}
