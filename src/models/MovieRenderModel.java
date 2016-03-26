package models;

import controllers.OracleDAO;
import utils.Utils;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 22-Mar-16.
 */
public class MovieRenderModel {

    public int movieId;
    public String title;
    public double rating;
    public String imgSrc;
    public String genres;

    public MovieRenderModel() {
    }

    public MovieRenderModel(int movieId, String title, double rating, int[] genres) throws Exception {
        this.movieId = movieId;
        this.title = title;
        this.rating = rating;
        this.imgSrc =  "img/" + String.valueOf(movieId-100) + ".jpg";
        this.genres = getGenres(genres);
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public static String getGenres(int [] genreIds) throws Exception {
        ArrayList<String> genreList = Genre.getGenreList();
        StringBuilder genresData = new StringBuilder("");
        for(int i = 0; i < genreList.size(); i++){
            if( genreIds[i] == 1)
                genresData.append(genreList.get(i) + ", ");
        }
        return genresData.toString();
    }

    public String renderMovie(){
        String movieRender = "<li class='text-center center-block'>" +
                "   <a href='movie.jsp?id=" + this.movieId + "'>" +
                "   <div class='panel panel-info'>" +
                "       <div class='panel-heading'><span class='title'>" + Utils.trimTitle(this.title) + "</span></div>" +
                "       <div class='panel-body'>" +
                "           <img src='" + this.imgSrc + "'>" +
                "           <input type='text' id='" + this.movieId + "-rating' class='readonly-rating' value='" + this.rating +"' data-krajee-rating='rating_options'>" +
                "       </div>" +
                "       <div class='panel-footer panel-info'><cite class='genres'>" + this.genres + "</cite></div>" +
                "   </div></a></li>";
        return movieRender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieRenderModel)) return false;

        MovieRenderModel that = (MovieRenderModel) o;

        return getMovieId() == that.getMovieId();

    }

    @Override
    public int hashCode() {
        return getMovieId();
    }

    public boolean presentIn(ArrayList<MovieRenderModel> movies){
        for(MovieRenderModel currentMovie : movies)
            return this.equals(currentMovie);
        return false;
    }

}
