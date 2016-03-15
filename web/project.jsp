<html>
<head>
<link rel="stylesheet" href="foundation.css" />
</head>
<body>
 <center> <h3> FEED BACK FORM</h3></center>
  <form method="post">
  <div class="row">
	<div class="small-2 large-4 columns"><label>QUESTION 1<input type="radio" name="c1" value="1"/>yes</label></div>
	<div class="small-4 large-4 columns"><label>QUESTION 2<input type="radio" name="c2" value="1"/>yes</label></div>
	<div class="small-6 large-4 columns"><label>QUESTION 3<input type="radio" name="c3" value="1"/>yes</label></div>
  </div>
  <div class="row">
  <div class="small-2 large-4 columns">QUESTION 4<input type="radio" name="c4" value="1">yes
    <input type="radio" name="c4" value="0">no<br><br></div>
  <div class="small-4 large-4 columns">QUESTION 5<input type="radio" name="c5" value="1">yes
    <input type="radio" name="c5" value="0">no<br><br></div>
  <div class="small-6 large-4 columns">QUESTION 6<input type="radio" name="c6" value="0">yes
    <input type="radio" name="c6" value="1">no<br><br></div>
</div>
    <input type="submit" value="Query">
  </form>
 
  <%String[] s1 = request.getParameterValues("c1");
String[] s2 = request.getParameterValues("c2");
String[] s3 = request.getParameterValues("c3");
String[] s4 = request.getParameterValues("c4");
String[] s5 = request.getParameterValues("c5");
String[] s6 = request.getParameterValues("c6");
String[] s7 = request.getParameterValues("c7");
String[] s8 = request.getParameterValues("c8");
String[] s9 = request.getParameterValues("c9");
String[] s10 = request.getParameterValues("c10");
String[] s11 = request.getParameterValues("c11");
String[] s12 = request.getParameterValues("c12");
String[] s13 = request.getParameterValues("c13");
String[] s14 = request.getParameterValues("c14");
String[] s15 = request.getParameterValues("c15");
%>

    <a href="<%= request.getRequestURI() %>">BACK</a>
</body>
</html>