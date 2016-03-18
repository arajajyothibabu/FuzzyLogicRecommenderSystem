package models;

/**
 * Created by Araja Jyothi Babu on 15-Mar-16.
 */
public class Rating {

    //TODO: implement just like User class
    public int userId;
    public int movieId;
    public int rating;
    public String timeStamp;

    public Rating() {
    }

    public Rating(int userId, int movieId, int rating, String timeStamp) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.timeStamp = timeStamp;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
