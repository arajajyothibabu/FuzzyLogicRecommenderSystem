<%@ page import="utils.Utils" %>
<%@ page import="controllers.OracleDAO" %>
<%@ page import="models.Rating" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %><%--
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
        Rating currentRating = new Rating(userId, movieId, rating, new java.sql.Date(Calendar.getInstance().getTimeInMillis()).toString());
        out.print(OracleDAO.addRating(currentRating));
    }catch (Exception e){
        out.print(e);
    }
%>
