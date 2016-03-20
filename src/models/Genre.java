package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Araja Jyothi Babu on 20-Mar-16.
 */
public class Genre{

    public static ArrayList<String> getGenreList() {
        List<String> array = Arrays.asList("Action", "Adventre", "Animation", "Biography", "Comedy", "Crime", "Documentary", "Drama", "Family", "Fantasy", "History", "Horror", "Music", "Mystery", "Romance", "Sci-Fi", "Sport", "Thriller", "War");
        ArrayList<String> genreList = new ArrayList<String>(array);
        return genreList;
    }

}
