<%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 21-Mar-16
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Movie Recommender System</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/foundation.min.css" />
    <link rel="stylesheet" href="css/star-rating.min.css" type="text/css">
    <link rel="stylesheet" href="css/custom.css" type="text/css">
    <script src="js/vendor/modernizr.js"></script>
    <script src="js/vendor/jquery.js"></script>
    <script src="js/foundation.min.js"></script>
    <script src="js/custom.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/star-rating.min.js"></script>
</head>
<body>
<!-- Header -->
<div class="row fullWidth" style="position:fixed; z-index:100; width:100%;">
    <nav class="top-bar" data-topbar role="navigation">
        <section class="top-bar-section">
            <ul class="title-area">
                <li class="name">
                    <h1><a href="index.jsp">Movie Recommender System</a></h1>
                </li>
                <!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
                <li class="toggle-topbar menu-icon"><a href="#"><span></span></a></li>
            </ul>
            <!-- Right Nav Section -->
            <ul class="right">
                <li><a href="index.jsp">Home</a></li>
                <% if(session.getAttribute("user") == null) {%>
                    <li><a href="#" data-dropdown="signin">Login</a></li>
                <% }else {%>
                <li class="has-dropdown">
                    <a href="#">Algorithms</a>
                    <ul class="dropdown">
                        <li><a href="index.jsp?method=Euclidean">Euclidean</a></li>
                        <li><a href="index.jsp?method=Manhattan">Manhattan</a></li>
                        <li><a href="index.jsp?method=Cosine">Cosine</a></li>
                        <li><a href="index.jsp?method=Pearson">Pearson Coefficient</a></li>
                    </ul>
                </li>
                <li class="has-dropdown">
                    <a href="#"><% out.print(session.getAttribute("user")); %></a>
                    <ul class="dropdown">
                        <li><a href="logout.jsp">Logout</a></li>
                    </ul>
                </li>
                <% } %>
            </ul>
        </section>
    </nav>
</div>
<div id="signin" class="f-dropdown small content" data-dropdown-content>
    <!-- signin form here -->
    <form action="login.jsp" method="post" >
        <div class="row" style="border-radius:5px;">
            <div class="large-12 columns">
                <div class="form-group">
                    <input class="form-control" type="number" name="user" placeholder="Username" required />
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="pass" placeholder="P@$$w0rd" required />
                </div>
                <div class="form-group">
                    <input type="submit" class="btn-success form-control" value="Submit">
                </div>
            </div>
        </div>
    </form>
</div>
<div class="row fullWidth">
    <div class="large-12 columns">
        <!-- DUmmy Header -->
        <div class="row" style="width:100%;">
            <div class="contain-to-grid sticky">
                <nav class="top-bar" data-topbar role="navigation" data-options="sticky_on: large">
                    <section class="top-bar-section"></section>
                </nav>
            </div>
        </div>