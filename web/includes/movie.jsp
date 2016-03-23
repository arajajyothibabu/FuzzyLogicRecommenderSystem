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
<link rel="stylesheet" href="../css/foundation.min.css" />
<link rel="stylesheet" href="../css/star-rating.min.css" type="text/css">
<link rel="stylesheet" href="../css/custom.css" type="text/css">
<script src="../js/vendor/modernizr.js"></script>
<script src="../js/vendor/jquery.js"></script>
<script src="../js/foundation/foundation.js"></script>
<script src="../js/foundation/foundation.orbit.js"></script>
<script src="../js/foundation/foundation.dropdown.js"></script>
<script src="../js/star-rating.min.js"></script>
<div class="small-6 medium-4 large-3">
    <div class="">
        <img src="<% out.print(imgSrc); %>" >
    </div>
    <span class="left-align"><% out.print(title); %></span><span class="right-align"><cite>Genres</cite></span>
    <input class="text-center" id="<% out.print(id); %>-rating" value="<% out.print(ratingValue); %>">
    <script>
        $(document).ready(function(){
            $("#<% out.print(id); %>-rating").rating({
                step : 1,
                stars : 5,
                size : 'xs',
                displayOnly : true
            });
        });
    </script>
</div>
