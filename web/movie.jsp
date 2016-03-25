<%@ page import="controllers.OracleDAO" %>
<%@ page import="models.Rating" %><%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 21-Mar-16
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    String id = request.getParameter("id");
    String imgSrc = "../img/" + id + ".jpg";
    String title = request.getParameter("title");
    String genreId = request.getParameter("genre");
    int ratingValue = 0;
    //TODO: Need to get genres
    if(session.getAttribute("user") != null){
        //Rating rating = OracleDAO.ratingOfUserToMovie((int)session.getAttribute("user"), id);
        //int ratingValue = rating.rating;
    }else{
        ratingValue = 0;
    }
%>
<jsp:include page="includes/header.jsp" />
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
                <div class="small-6 medium-4 large-3">
                    <div class="">
                        <img src="<% out.print(imgSrc); %>" >
                    </div>
                    <span class="left-align"><% out.print(title); %></span><span class="right-align"><cite>Genres</cite></span>
                    <input class="text-center" id="<% out.print(id); %>-rating" value="<% out.print(ratingValue); %>">
                    <script>
                        $(document).ready(function(){
                            $("#<% out.print(id); %>-rating").rating({
                                step : 0.1,
                                stars : 5,
                                size : 'xs',
                                displayOnly : true
                            });
                        });
                    </script>
                </div>
                <%

                %>
            </div>
        </div>
    </div>
</div>
<jsp:include page="includes/footer.jsp" />
