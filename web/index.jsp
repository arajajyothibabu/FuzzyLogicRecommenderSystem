<%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 20-Mar-16
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>MRND Project | Welcome</title>
    <link rel="stylesheet" href="css/foundation.css" />
    <link rel="stylesheet" href="css/foundation.min.css" />
    <link rel="stylesheet" href="css/custom.css" type="text/css">
    <script src="js/vendor/modernizr.js"></script>
    <script src="js/vendor/jquery.js"></script>
    <script src="js/foundation/foundation.js"></script>
    <script src="js/foundation/foundation.orbit.js"></script>
    <script src="js/foundation/foundation.dropdown.js"></script>
</head>
<body>
<!-- Header -->
<div class="row fullWidth" style="position:fixed; z-index:100; width:100%;">
    <nav class="top-bar" data-topbar>
        <section class="top-bar-section">
            <ul class="title-area">
                <li class="name">
                    <h1><a href="home.html">Mission R&D Project</a></h1>
                </li>
                <!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
                <li class="toggle-topbar menu-icon"><a href="#"><span></span></a></li>
            </ul>
            <!-- Right Nav Section -->
            <ul class="right">
                <li class="active"><a href="home.html">Home</a></li>
                <li class=""><a href="signup.html">Register</a></li>
                <li class=""><a href="login.html">Search</a>
                    <!--<ul class="dropdown">
                        <li><a href="#">First link in dropdown</a></li>
                        <li class="active"><a href="#">Active link in dropdown</a></li>
                    </ul>-->
                </li>
                <li class=""><a href="about.html">About</a></li>
                <li>
                    <a href="#" data-dropdown="signin">Subscribe</a>
                </li>
            </ul>
        </section>
    </nav>
    <div id="signin" class="f-dropdown small content" data-dropdown-content>
        <!-- signin form here -->
        <form action="#" method="post" >
            <div class="row" style="border-radius:5px; background-color:aqua;">
                <div class="large-12 columns">
                    <label>Email Address
                        <input type="text" placeholder="valid email" />
                    </label>
                </div>
            </div>
        </form>
    </div>
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
        <div class="row">
            <div class="orbit-container">
                <ul data-orbit data-options="   animation:slide;
                                                        pause_on_hover:true;
                                                        animation_speed:2000;
                                                        navigation_arrows:true;
                                                        bullets:false;">
                    <li>
                        <img src="img/s1.jpg" alt="slide 1" />
                        <div class="orbit-caption">
                            Caption One.
                        </div>
                    </li>
                    <li class="active">
                        <img src="img/s2.jpg" alt="slide 2" />
                        <div class="orbit-caption">
                            Caption Two.
                        </div>
                    </li>
                    <li>
                        <img src="img/s3.jpg" alt="slide 3" />
                        <div class="orbit-caption">
                            Caption Three.
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="large-12 column">
                <h1 align="center" style="font-family:'Lucida Calligraphy'; text-decoration:solid; border-bottom:ridge; border-bottom-color:aqua;">Welcome to the world of Innovation and Automation</h1>
            </div>
        </div>


        <div class="row">
            <div class="large-9 columns" style="padding-left:50px; padding-right:50px; border-right:groove;">
                <p class="text-justify">
                    &nbsp;&nbsp;&nbsp;Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                </p>
                <p class="text-justify">
                    &nbsp;&nbsp;&nbsp;Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.
                </p>
                <p class="text-justify">
                    &nbsp;&nbsp;&nbsp;It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
                </p>
                <p class="text-justify">
                    &nbsp;&nbsp;&nbsp;There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.
                </p>
            </div>

            <div class="large-3 columns" style="padding:15px;">
                <div class="row">
                    <div class="large-12 medium-12 columns">
                        <ul class="example-orbit-content" data-orbit>
                            <li data-orbit-slide="headline-1">
                                <div>
                                    <h2>Headline 1</h2>
                                    <h3>Subheadline</h3>
                                </div>
                            </li>
                            <li data-orbit-slide="headline-2">
                                <div>
                                    <h2>Headline 2</h2>
                                    <h3>Subheadline</h3>
                                </div>
                            </li>
                            <li data-orbit-slide="headline-3">
                                <div>
                                    <h2>Headline 3</h2>
                                    <h3>Subheadline</h3>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="row">
                    <div class="large-12 medium-12 columns">

                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
<!-- Footer -->
<div class="row fullWidth" id="footer" style="">
    <div class="icon-bar five-up" role="navigation">
        <a class="item" aria-labelledby="#itemlabel1">
            <img src="svg/fi-home.svg" >
            <label id='itemlabel1'>Home</label>
        </a>
        <a class="item" aria-labelledby="#itemlabel2">
            <img src="svg/fi-bookmark.svg" >
            <label id='itemlabel2'>Bookmark</label>
        </a>
        <a class="item" aria-labelledby="#itemlabel3">
            <img src="svg/fi-info.svg" >
            <label id='itemlabel3'>Info</label>
        </a>
        <a class="item" aria-labelledby="#itemlabel4">
            <img src="svg/fi-mail.svg" >
            <label id='itemlabel4'>Mail</label>
        </a>
        <a class="item" aria-labelledby="#itemlabel5">
            <img src="svg/fi-like.svg" >
            <label id='itemlabel5'>Like</label>
        </a>
    </div>
</div>
<script>
    $(document).foundation({
        orbit: {
            animation: 'slide',
            timer_speed: 500,
            pause_on_hover: false,
            animation_speed: 2000,
            navigation_arrows: true,
            bullets: false
        }
    });
    $(document).foundation({
        dropdown: {
            // specify the class used for active dropdowns
            active_class: 'open'
        }
    });
    $(window).bind("load", function () {
        var footer = $("#footer");
        var pos = footer.position();
        var height = $(window).height();
        height = height - pos.top;
        height = height - footer.height();
        if (height > 0) {
            footer.css({
                'margin-top': height + 'px'
            });
        }
    });
    $(document).foundation();
</script>
</body>
</html>
