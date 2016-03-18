<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recommender System</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/foundation.css" />
		<link rel="stylesheet" href="css/fonts/foundation-icons.css" />
    </head>
    <body>
	
	
		<nav class="top-bar" data-topbar role="navigation">
			<ul class="title-area">
				<li class="name">
					<h1><a href="#" style="left:600px;position:relative;">Login Page</a></h1>
				</li>
				<!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
				<li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
			</ul>
			
			<form style="width:25%;left:520px;position:relative;" method="post">
  <div class="row" >
    <div class="large-12 columns" >
        <label><b>Enter User Name</b>
        <input name="uname" type="text" placeholder="UserName"  />
      </label>
    </div>
  </div>&nbsp;
  <div class="row" >
    <div class="large-12 columns" >
        <label><b>Enter Password</b>
        <input name="pass" type="password" placeholder="Password"  />
      </label>
    </div>
  </div>&nbsp;
  <div class="row">
  <div class="large-6 columns"><button type="submit" formaction="registration.jsp" style="background-color:#000000;border-radius: 1500px;height:40px">Registration</button>
  </div>
  <div class="large-6 columns"><button type="submit" formaction="login.jsp" style="background-color:#000000;border-radius: 1500px;height:40px">Login</button>
  </div>
</div>
  
  
</form>

        <div id="content3" style="bottom:0px;width:100%;height:30px;position:fixed;background-color:#000000;"></div>
        <div id="myModal" class="reveal-modal" data-reveal aria-labelledby="modalTitle" aria-hidden="true" role="dialog">
    </body>
</html>