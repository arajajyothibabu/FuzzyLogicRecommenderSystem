package controllers.services;

import controllers.OracleDAO;
import controllers.fuzzy_inference_system.FIS;
import models.MovieRenderModel;
import utils.DB;

import java.util.ArrayList;

/**
 * Created by Araja Jyothi Babu on 07-Apr-16.
 */
public class IndexService {

    private DB db;
    private OracleDAO dao;
    private static FIS fis;
    ArrayList<ArrayList<MovieRenderModel>> fullMovieList;
    ArrayList<MovieRenderModel> recommendedMovieList;
    ArrayList<MovieRenderModel> restOfMovieList;

    public IndexService() throws Exception{
        db = new DB();
        dao = new OracleDAO(db);
        fis = new FIS(new RatingDataService(dao), new MovieDataService(dao), new UserDataService(dao));
        restOfMovieList = fis.processedMovies();
    }

    public IndexService(int userId, int K, String method) throws Exception{
        db = new DB();
        dao = new OracleDAO(db);
        fis = new FIS(new RatingDataService(dao), new MovieDataService(dao), new UserDataService(dao));
        fullMovieList = fis.processedMovies(userId, K, method);
        recommendedMovieList = fullMovieList.get(0);
        restOfMovieList = fullMovieList.get(1);
    }

    public ArrayList<MovieRenderModel> getRecommendedMovieList() throws Exception{
        return this.recommendedMovieList;
    }

    public ArrayList<MovieRenderModel> getRestOfMovieList() throws Exception{
        return this.restOfMovieList;
    }


}
