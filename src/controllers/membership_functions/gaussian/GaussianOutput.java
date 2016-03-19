package controllers.membership_functions.gaussian;

import utils.Utils;
/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class GaussianOutput {

    public static double makeInputToExp(double x, double m, double sigma) {return -(0.5) * Utils.square((x - m) / sigma);
    }

    public static double exp(double value){return Math.exp(value);
    }
    //3 output membership functions
    public static double acceptanceRate3_low(double x){return exp(makeInputToExp(x, 0, 0.8493));
    }

    public static double acceptanceRate3_medium(double x){return exp(makeInputToExp(x, 2.5, 0.48));
    }

    public static double acceptanceRate3_high(double x) {return exp(makeInputToExp(x, 2.5, 0.48));
    }
    //4 output membership functions

    public static double acceptanceRate4_veryLow(double x){return exp(makeInputToExp(x, 0 , 0.48));
    }

    public static double acceptanceRate4_low(double x){return exp(makeInputToExp(x, 1.75, 0.48));
    }

    public static double acceptanceRate4_medium(double x){return exp(makeInputToExp(x, 3.25, 0.48));
    }

    public static double acceptanceRate4_high(double x){return exp(makeInputToExp(x, 5, 0.48));
    }

    // 5 output membership function

    public static double acceptanceRate5_veryLow(double x){return exp(makeInputToExp(x, 0 , 0.42));
    }

    public static double acceptanceRate5_low(double x){return exp(makeInputToExp(x, 1.25 , 0.42));
    }

    public static double acceptanceRate5_medium(double x){return exp(makeInputToExp(x, 2.5 , 0.42));
    }

    public static double acceptanceRate5_high(double x){return exp(makeInputToExp(x, 3.75 , 0.42));
    }

    public static double acceptanceRate5_veryHigh(double x){return exp(makeInputToExp(x, 5 , 0.42));
    }
    
}
