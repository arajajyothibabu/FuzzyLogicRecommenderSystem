package models;

/**
 * Created by Araja Jyothi Babu on 22-Mar-16.
 */
public class UserSimilarity {

    public int movieId;
    public int userVId;
    public int ratingU;
    public int ratingV;

    public UserSimilarity(int movieId, int userVId, int ratingU, int ratingV) {
        this.movieId = movieId;
        this.userVId = userVId;
        this.ratingU = ratingU;
        this.ratingV = ratingV;
    }

    public UserSimilarity() {
    }
}
