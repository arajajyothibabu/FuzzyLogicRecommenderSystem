package controllers.membership_functions.trapezoidal;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class TrapezoidalOutput {

    //3 output membership functions
    public static double acceptanceRate3_low(double x){
        if( x < 0 || x >= 2 )
            return 0;
        else if(x == 0)
            return (x - 0)/0;
        else if(x >= 0 && x <= 1)
            return 1;
        else
            return (2 - x) / (2 - 1);
    }

    public static double acceptanceRate3_medium(double x){
        if(x < 0 || x >= 4)
            return 0;
        else if(x >= 0 && x <= 2)
            return (x - 0)/ 2;
        else if(x >= 2 && x <= 3)
            return 1;
        else
            return (4 - x) / (4 - 3);
    }

    public static double acceptanceRate3_high(double x) {
        if (x < 3 || x >= 5)
            return 0;
        else if (x >= 3 && x <= 4)
            return (x - 3) / (4 - 3);
        else if (x >= 4 && x <= 5)
            return 1;
        else
            return (5 - x) / 0;
    }
        //4 output membership functions

    public static double acceptanceRate4_veryLow(double x){
        if(x < 0 || x >= 1.5)
            return 0;
        else if(x == 0)
            return (x -0)/(0);
        else if(x >= 0 && x <= 0.5)
            return 1;
        else
            return (1.5 - x) / (1.5 - 0.5);
    }

    public static double acceptanceRate4_low(double x){
        if(x < 0.5 || x >= 3)
            return 0;
        else if(x <= 0.5 && x >=1.5)
            return (x - 0.5) / (1.5 - 0.5);
        else if(x >= 1.5 && x <= 2)
            return 1;
        else
            return (3 - x) / (3 - 2);
    }

    public static double acceptanceRate4_medium(double x){
        if(x < 2 || x >= 4.5)
            return 0;
        else if(x >= 2 && x <= 3)
            return (x - 2) / (3 - 2);
        else if(x >= 3 && x <= 3.5)
            return 1;
        else
            return (4.5 - x) / (4.5 - 3.5);
    }

    public static double acceptanceRate4_high(double x){
        if(x < 3.5 || x >= 5)
            return 0;
        else if(x >= 3.5 && x <= 4.5)
            return (x - 3.5) / (4.5 - 3.5);
        else if(x >= 4.5 && x <= 5)
            return 1;
        else
            return (5 - x) / 0;
    }

    // 5 output membership function

    public static double acceptanceRate5_veryLow(double x){
        if(x < 0 || x >= 1.1)
            return 0;
        else if(x == 0)
            return (x - 0 ) / (0);
        else if(x >= 0 && x <= 0.75)
            return 1;
        else
            return (1.1 - x) / (1.1 - 0.75);
    }

    public static double acceptanceRate5_low(double x){
        if(x < 0.5 || x >= 2.2)
            return 0;
        else if(x >= 0.5 && x <= 1.1)
            return (x - 0.5) / (1.1 - 0.5);
        else if(x >= 1.85 && x <= 1.1)
            return 1;
        else
            return (2.2 - x) / (2.2 - 1.85);
    }

    public static double acceptanceRate5_medium(double x){
        if(x < 1.85 || x >= 3.3)
            return 0;
        else if(x >= 1.85 && x <= 2.2)
            return (x - 1.85) / (2.2 - 1.85);
        else if(x >= 2.2 && x <= 2.95)
            return 1;
        else
            return (3.3 - x) / (3.3 - 2.95);
    }

    public static double acceptanceRate5_high(double x){
        if(x < 2.95 || x >= 4.4)
            return 0;
        else if(x >= 2.95 && x <= 3.3)
            return (x - 2.95) / (2.95 - 3.3);
        else if(x >= 3.3 && x <= 4.05)
            return 1;
        else
            return (4.4 - x) / (4.4 - 4.05);
    }

    public static double acceptanceRate5_veryHigh(double x){
        if(x < 4.05 || x >= 5)
            return 0;
        else if(x >= 4.05 && x <= 4.4)
            return (x -4.05)/(4.4-4.05);
        else if(x >= 4.4 && x <= 5)
            return 1;
        else
            return (5 - x) / 0;
    }
}
