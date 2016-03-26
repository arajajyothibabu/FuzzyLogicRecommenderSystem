<%@ page import="controllers.OracleDAO" %>
<%@ page import="models.Rating" %>
<%@ page import="models.MovieRenderModel" %>
<%@ page import="utils.Utils" %>
<%@ page import="models.User" %>
<%@ page import="models.Movie" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controllers.fuzzy_inference_system.FIS" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 21-Mar-16
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="includes/header.jsp" />
<%
    Boolean userLoggedIn = false;
    int userId = 0;
    int rating = 0;
    int movieId = 0;
    String method = "Pearson";
    int K = 5;
    MovieRenderModel movie = new MovieRenderModel();
    try{
        movieId =  Integer.parseInt(Utils.replaceNull(request.getParameter("id").toString()));
        movie = Utils.makeMovieRender(OracleDAO.getMovie(movieId));
        if(session.getAttribute("user") != null){
            userLoggedIn = true;
            userId = Integer.parseInt(session.getAttribute("user").toString());
            method = Utils.replaceNull(request.getParameter("method"), "Pearson");
            Rating userRating = OracleDAO.ratingOfUserToMovie(userId, movieId);
            rating = userRating.rating;
        }
    }catch (Exception e){
        out.println(e);
    }
%>
<div class="row">
    <div class="large-12 column">
        <h1 align="center" style="font-family:'Lucida Calligraphy'; text-decoration:solid; border-bottom:ridge; border-bottom-color:aqua;">using Collaborative filtering</h1>
    </div>
</div>


<div class="row">
    <div class="large-12 columns" style="padding-left:20px; padding-right:20px;">
        <%
            try{
        %>
        <div class="row">
            <div class="large-5 medium-6 columns" style="border-right: solid;">
                <div class="text-center center-block">
                    <h3><% out.print(movie.title); %></h3>
                    <img src="<% out.print(movie.imgSrc); %>">
                    <p class="genres"><% out.print(movie.genres); %></p>
                </div>
                <input id="movie-rating" value="<% out.print(rating); %>">
            </div>
            <div class="large-7 medium-6 columns">
                <h3>Similar Movies</h3>
                <ul class="small-block-grid-0 medium-block-grid-2 large-block-grid-3 related">
                <%
                    ArrayList<MovieRenderModel> movies = FIS.relatedMovies(movieId, K, method);
                    for(MovieRenderModel currentMovie : movies){
                        out.print(currentMovie.renderMovie());
                    }
                %>
            </div>
        </div>
        <%
            }catch (NumberFormatException e){
        %>
        <h1 align="center" class="label-warning">No Movie Found</h1>
        <%
                out.println(e.getMessage());
            }
        %>
    </div>
</div>
<script>
    $(document).ready(function(){
        $("#movie-rating").rating({
            step : 1,
            min : 0,
            max : 5,
            stars : 5
        });
        $('#movie-rating').on('rating.change', function(event, value, caption) {
            <%
                if(userLoggedIn){
            %>
                    $.ajax
                    ({
                        type: "GET",
                        url: "includes/rate.jsp?movie=<% out.print(movie.movieId); %>&rating=" + value,
                        dataType: 'text',
                        async: true,
                        contentType: "application/json; charset=utf-8"
                    }).done( function (data) {
                        console.log(data);
                        //if(data != "true")
                            //alert("Rating failed");
                        //do something after rating
                    }).fail( function(){
                        alert("Rating failed..!");
                    });
            <%
                }else{
            %>
                alert("Please login to rate the movie..!");
            <%
                }
            %>
        });
        var rating_options = {
            min : 0,
            max : 5,
            step : 0.1,
            displayOnly :true,
            size : 'xs',
            stars : 5
        };
        $(".readonly-rating").each(function(){
            $(this).rating(rating_options);
        });
    });
</script>
<jsp:include page="includes/footer.jsp" />