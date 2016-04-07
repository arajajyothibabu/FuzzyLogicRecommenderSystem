<%@ page import="utils.Utils" %>
<%@ page import="controllers.services.RatingService" %><%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 26-Mar-16
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int userId = Integer.parseInt(Utils.replaceNull(session.getAttribute("user").toString()));
    int movieId =  Integer.parseInt(Utils.replaceNull(request.getParameter("movie").toString()));
    int rating =  Integer.parseInt(Utils.replaceNull(request.getParameter("rating").toString()));
    try{
        RatingService ratingService = new RatingService(userId, movieId, rating);
        out.print(ratingService.doRating());
    }catch (Exception e){
        out.print(e);
    }
%>
