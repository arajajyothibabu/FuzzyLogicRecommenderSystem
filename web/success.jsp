<html class="no-js" lang="en">
  <head>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <title>Project</title>
      <link rel="stylesheet" href="css/foundation.css" />
      <link rel="stylesheet" href="css/fonts/foundation-icons.css" />
      <link rel="stylesheet" href="css/custom.css" />
  </head>
  <body>
	<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} else {
%>
<%session.setAttribute("userid",session.getAttribute("userid"));%>
    <nav class="top-bar" data-topbar role="navigation" >
  <ul class="title-area">
    <li class="name" style="width:225%;left:550px;position:relative;">
	<div class="row">
    <div class="large-4 columns"style="width:300px;" >
        <label><h3><a href="#" style="color:#ffffff;width:125%">Recommended system</a></h3></label>
    </div>
    <div class="large-4 columns"style="width:1px;">
        <label ><h2 style="color:#ffffff" name="name" ><%=session.getAttribute("userid")%></h2>
      </label>
    </div>
 <div class="large-4 columns">
        <label><h2><a href="logout.jsp" style="color:#ffffff">Log out</a></h2>
      </label>
    </div>
  </div>
    </li>
     <!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
    <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
  </ul>
<br><br>
<form method="post" style="width:50%;left:340px;position:relative;">
  <div class="row">
    <div class="large-4 columns">
        <img src="img/1.jpg" />
        <label>
            <input type="radio" name="c1" value="1"/><i class="fi fi-like"></i>
            <input type="radio" name="c1" value="0"/><i class="fi fi-dislike"></i>
      </label>
    </div>
    <div class="large-4 columns">
        <img src="img/2.jpg" />
        <label>
            <input type="radio" name="c2" value="1"/><i class="fi fi-like"></i>
            <input type="radio" name="c2" value="0"/><i class="fi fi-dislike"></i>
      </label>
    </div>
 <div class="large-4 columns">
        <img src="img/3.jpg"/>
        <label>
            <input type="radio" name="c3" value="1"/><i class="fi fi-like"></i>
            <input type="radio" name="c3" value="0"/><i class="fi fi-dislike"></i>
      </label>
    </div>
  </div>&nbsp;
<div class="row">
    <div class="large-4 columns" >
        <img src="img/4.jpg"/>
      <label>
          <input type="radio" name="c4" value="1"/><i class="fi fi-like"></i>
          <input type="radio" name="c4" value="0"/><i class="fi fi-dislike"></i>
      </label>
    </div>
<div class="large-4 columns">
        <img src="img/5.jpg"/>
      <label>
          <input type="radio" name="c5" value="1"/><i class="fi fi-like"></i>
          <input type="radio" name="c5" value="0"/><i class="fi fi-dislike"></i>
      </label>
    </div>
    <div class="large-4 columns">
        <img src="img/6.jpg"/>
        <label>
            <input type="radio" name="c6" value="1"/><i class="fi fi-like"></i>
            <input type="radio" name="c6" value="0"/><i class="fi fi-dislike"></i>
      </label>
    </div>
  </div>&nbsp;
  <div class="row">
  <div class="large-6 columns"><button type="submit" formaction="options.jsp" style="background-color:#000000;border-radius: 1500px;height:40px">submit</button>
  </div>
  <div class="large-6 columns"><button type="submit" formaction="cosine.jsp" style="background-color:#000000;border-radius: 1500px;height:40px">cosine similarity</button>
  </div>
<br>
<br>
<div class="large-6 columns"><button type="submit" formaction="manhattan.jsp" style="background-color:#000000;border-radius: 1500px;height:40px">manhattan method</button>
  </div>
<div class="large-6 columns"><button type="submit" formaction="euclidean.jsp" style="background-color:#000000;border-radius: 1500px;height:40px">euclidean</button>
  </div>
</div>
</form>
<%out.println(session.getAttribute("userid"));%>

 <%String[] s1 = request.getParameterValues("c1");
String[] s2 = request.getParameterValues("c2");
String[] s3 = request.getParameterValues("c3");
String[] s4 = request.getParameterValues("c4");
String[] s5 = request.getParameterValues("c5");
String[] s6 = request.getParameterValues("c6");
%>


        <div id="content3" style="bottom:0px;width:100%;height:30px;position:fixed;background-color:#000000;"></div>
        <div id="myModal" class="reveal-modal" data-reveal aria-labelledby="modalTitle" aria-hidden="true" role="dialog">
 
           
</div>  

	<%
    }
%>
  </body>
</html>

