<%@ page import="models.MovieRenderModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="utils.Utils" %>
<%@ page import="controllers.services.IndexService" %><%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 20-Mar-16
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="includes/header.jsp" />

<%
    ArrayList<MovieRenderModel> recommendedMovieList = new ArrayList();
    ArrayList<MovieRenderModel> restOfMovieList = new ArrayList();
    Boolean userLoggedIn = false;
    int userId = 0;
    String method = "Pearson";
    int K = 5;
    try{
        if(session.getAttribute("user") != null){
            userLoggedIn = true;
            userId = Integer.parseInt(session.getAttribute("user").toString());
            method = Utils.replaceNull(request.getParameter("method"),"Pearson");
            IndexService indexService = new IndexService(userId, K, method);
            recommendedMovieList = indexService.getRecommendedMovieList();
            restOfMovieList = indexService.getRestOfMovieList();
        }else{
            IndexService indexService = new IndexService();
            restOfMovieList = indexService.getRestOfMovieList();
        }
    }catch(Exception e){
        //catched it :)
    }
%>
        <div class="row">
            <div class="large-12 column">
                <h1 align="center" style="font-family:'Lucida Calligraphy'; text-decoration:solid; border-bottom:ridge; border-bottom-color:aqua;">using Collaborative filtering</h1>
            </div>
        </div>

<jsp:include page="includes/alerts.jsp" />

        <div class="row">
            <div class="large-12 columns" style="padding-left:20px; padding-right:20px;">
                <div class="row">
                    <div class="large-12 medium-12 columns">
                        <%
                            if(userLoggedIn){
                                if(recommendedMovieList.size() > 0){
                        %>
                                    <fieldset><legend>Movies Recommended for you</legend>
                                        <ul class="small-block-grid-2 medium-block-grid-3 large-block-grid-5">
                        <%
                                        for(MovieRenderModel movie : recommendedMovieList) {
                                            out.print(movie.renderMovie());
                                        }
                        %>
                                        </ul>
                                    </fieldset>
                        <%
                                }
                            }
                        %>
                        <ul class="small-block-grid-2 medium-block-grid-3 large-block-grid-5">
                            <%
                                for(MovieRenderModel movie : restOfMovieList) {
                                    out.print(movie.renderMovie());
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