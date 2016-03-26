<%@ page import="models.MovieRenderModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controllers.fuzzy_inference_system.FIS" %><%--
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
    String method = "";
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
                <h1 align="center" style="font-family:'Lucida Calligraphy'; text-decoration:solid; border-bottom:ridge; border-bottom-color:aqua;">Welcome to the world of Innovation and Automation</h1>
            </div>
        </div>

        <div class="row">
            <div class="large-3 columns" style="padding:15px;">
                <div class="row">
                    <div class="large-12 medium-12 columns">

                    </div>
                </div>
            </div>
            <div class="large-9 columns" style="padding-left:50px; padding-right:50px; border-right:groove;">
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
                        %>
                                        <li class="text-center center-block">
                                            <img src="<% out.print(movie.imgSrc); %>">
                                            <p class="title"><% out.print(movie.title); %></p>
                                            <cite class="genres"><% out.print(movie.genres); %></cite>
                                            <input type="text" id="" value="<% out.print(movie.rating); %>">
                                        </li>
                        <%
                                    }
                                }catch (Exception e){
                                    out.print(e);
                                }
                            }
                        %>
                        <ul class="small-block-grid-1 medium-block-grid-2 large-block-grid-3">
                            <%
                                try{
                                    movieList = FIS.processedMovies();
                                    for(MovieRenderModel movie : movieList) {
                                        if(! movie.presentIn(recommendedMovieList)){
                            %>
                                            <li class="text-center center-block">
                                                <div class="panel panel-info">
                                                    <div class="panel-heading">
                                                        <span class="title"><% out.print(movie.title); %></span>
                                                    </div>
                                                    <div class="panel-body">
                                                        <img src="<% out.print(movie.imgSrc); %>">
                                                        <input type="text" id="" value="<% out.print(movie.rating); %>">
                                                    </div>
                                                    <div class="panel-footer panel-info">
                                                        <cite class="genres"><% out.print(movie.genres); %></cite>
                                                    </div>
                                                </div>
                                            </li>
                            <%
                                        }
                                    }
                                }catch(Exception e){
                                    out.print(e);
                                }
                            %>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
<jsp:include page="includes/footer.jsp" />