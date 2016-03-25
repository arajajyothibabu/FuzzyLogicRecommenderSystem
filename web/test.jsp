<%@ page import="java.sql.Connection" %>
<%@ page import="utils.DB" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="models.Movie" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="utils.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 25-Mar-16
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Connection connection = DB.openConnection();
    Statement statement = connection.createStatement();
    ResultSet moviesFromDB = statement.executeQuery("SELECT * FROM movies");
    while(moviesFromDB.next()) {
        String[] strings = (String [])moviesFromDB.getArray(3).getArray();
        for(String x : strings)
            out.print(x + "\t");
        out.println("<br>");
    }
%>
</body>
</html>
