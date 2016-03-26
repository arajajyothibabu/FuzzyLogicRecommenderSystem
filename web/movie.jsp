<%@ page import="controllers.OracleDAO" %>
<%@ page import="models.Rating" %>
<%@ page import="models.MovieRenderModel" %>
<%@ page import="utils.Utils" %>
<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 21-Mar-16
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    Boolean userLoggedIn = false;
    int userId = 0;
    int rating = 0;
    int movieId = 0;
    String method = "";
    int K = 5;
    MovieRenderModel movie = new MovieRenderModel();
    try{
        movieId =  Integer.parseInt(Utils.replaceNull(request.getParameter("id").toString()));
        movie = Utils.makeMovieRender(OracleDAO.getMovie(movieId));
        if(session.getAttribute("user") != null){
            userLoggedIn = true;
            userId = Integer.parseInt(session.getAttribute("user").toString());
            method = Utils.replaceNull(request.getParameter("method"));
            Rating userRating = OracleDAO.ratingOfUserToMovie(userId, movieId);
            rating = userRating.rating;
        }
    }catch (Exception e){
        out.println(e);
    }
%>
<jsp:include page="includes/header.jsp" />
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
            <div class="large-6 medium-6 columns">
                <p class="title"><% out.print(movie.title); %></p>
                <img src="<% out.print(movie.imgSrc); %>">
                <p class="genres"><% out.print(movie.genres); %></p>
                <input class="rating" id="rating" value="<% out.print(rating); %>">
            </div>
            <div class="large-6 medium-6 columns">
                <h3>Similar Movies</h3>
            </div>
        </div>
        <%
            }catch (Exception e){
        %>
        <h1 align="center" class="label-warning">No Movie Found</h1>
        <%
                out.println(e);
            }
        %>
    </div>
</div>
<script>
    $(document).ready(function(){
        $("#rating").rating({
            step : 1,
            min : 0,
            max : 5,
            stars : 5
        });
        $('#rating').on('rating.change', function(event, value, caption) {
            <%
                if(userLoggedIn){

                }
            %>
        });
    });
</script>
<jsp:include page="includes/footer.jsp" />