package models;

/**
 * Created by Araja Jyothi Babu on 22-Mar-16.
 */
public class UserDissimilarity {

    public int movieId;
    public int userUId;
    public int userVId;
    public int rating;
    public String timeStamp;

    public UserDissimilarity(int movieId, int userUId, int userVId, int rating, String timeStamp) {
        this.movieId = movieId;
        this.userUId = userUId;
        this.userVId = userVId;
        this.rating = rating;
        this.timeStamp = timeStamp;
    }

    public UserDissimilarity() {
    }
}
