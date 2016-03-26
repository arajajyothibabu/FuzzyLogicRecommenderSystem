<%@ page import="models.MovieRenderModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controllers.fuzzy_inference_system.FIS" %>
<%@ page import="utils.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 20-Mar-16
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="includes/header.jsp" />

<%
    Boolean userLoggedIn = false;
    int userId = 0;
    String method = "Pearson";
    int K = 5;
    if(session.getAttribute("user") != null){
        userLoggedIn = true;
        userId = Integer.parseInt(session.getAttribute("user").toString());
        method = request.getParameter("method");
    }
    ArrayList<MovieRenderModel> recommendedMovieList = new ArrayList();
    ArrayList<MovieRenderModel> movieList = new ArrayList();
%>
<!-- Slider for home only
        <div class="row">
            <div class="orbit-container">
                <ul data-orbit data-options="animation:slide;pause_on_hover:true;animation_speed:2000;navigation_arrows:true;bullets:false;">
                    <li>
                        <img src="img/s1.jpg" alt="slide 1" />
                        <div class="orbit-caption">
                            Caption One.
                        </div>
                    </li>
                    <li class="active">
                        <img src="img/s2.jpg" alt="slide 2" />
                        <div class="orbit-caption">
                            Caption Two.
                        </div>
                    </li>
                    <li>
                        <img src="img/s3.jpg" alt="slide 3" />
                        <div class="orbit-caption">
                            Caption Three.
                        </div>
                    </li>
                </ul>
            </div>
        </div>-->
        <div class="row">
            <div class="large-12 column">
                <h1 align="center" style="font-family:'Lucida Calligraphy'; text-decoration:solid; border-bottom:ridge; border-bottom-color:aqua;">using Collaborative filtering</h1>
            </div>
        </div>

        <div class="row">
            <div class="large-12 columns" style="padding-left:20px; padding-right:20px;">
                <div class="row">
                    <div class="large-12 medium-12 columns">
                        <%
                            if(userLoggedIn){
                                try{
                                    recommendedMovieList = FIS.processedMovies(userId, K, method);
                        %>
                                    <h4 class="label-primary">Movies Recommended for you</h4>
                                    <ul class="small-block-grid-2 medium-block-grid-3 large-block-grid-5">
                        <%
                                    for(MovieRenderModel movie : recommendedMovieList) {
                                        out.print(movie.renderMovie());
                                    }
                                }catch (Exception e){
                                    out.print(e);
                                    e.printStackTrace();
                                }
                            }
                        %>
                        <ul class="small-block-grid-2 medium-block-grid-3 large-block-grid-5">
                            <%
                                try{
                                    movieList = FIS.processedMovies();
                                    for(MovieRenderModel movie : movieList) {
                                        if(! movie.presentIn(recommendedMovieList)){
                                            out.print(movie.renderMovie());
                                        }
                                    }
                                }catch(Exception e){
                                    out.print(e);
                                    e.printStackTrace();
                                }
                            %>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function(){
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