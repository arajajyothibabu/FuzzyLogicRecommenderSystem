<%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 20-Mar-16
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>MRND Project | Search</title>
    <link rel="stylesheet" href="css/foundation.css" />
    <link rel="stylesheet" href="css/foundation.min.css" />
    <link rel="stylesheet" href="css/custom.css" type="text/css">
    <script src="js/vendor/modernizr.js"></script>
    <script src="js/vendor/jquery.js"></script>
    <script src="js/foundation/foundation.js"></script>
    <script src="js/foundation/foundation.orbit.js"></script>
    <script src="js/foundation/foundation.dropdown.js"></script>
    <script src="js/foundation/foundation.tab.js"></script>
</head>
<body>
<!-- Header -->
<div class="row fullWidth" style="position:fixed; z-index:100; width:100%;">
    <div class="contain-to-grid sticky">
        <nav class="top-bar" data-topbar role="navigation" data-options="sticky_on: large">
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
                    <li class=""><a href="home.html">Home</a></li>
                    <li class=""><a href="signup.html">Register</a></li>
                    <li class="active"><a href="#">Search</a>
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
    </div>
    <!-- Subscribe -->
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

<!-- Main Page -->
<div class="row fullWidth">
    <div class="large-12 columns">
        <!-- DUmmy Header -->
        <div class="row fullWidth" style="width:100%;">
            <div class="contain-to-grid sticky">
                <nav class="top-bar" data-topbar role="navigation" data-options="sticky_on: large">
                    <section class="top-bar-section"></section>
                </nav>
            </div>
        </div>
        <!-- heading -->
        <div class="row">
            <div class="large-12 column">
                <h1 align="center" style="font-family:'Lucida Calligraphy'; text-decoration:solid; border-bottom:ridge; border-bottom-color:aqua;">Student Search</h1>
            </div>
        </div>

        <!-- Search -->
        <div class="row">
            <div class="large-9 columns" style="padding-left:50px; padding-right:50px; border-radius:6px; border-right:groove;">
                <div class="row" id="searchBar">
                    <div class="large-12 columns">
                        <div class="panel">
                            <div class="row collapse">
                                <div class="small-10 columns">
                                    <input type="text" required name="id" id="id" pattern="[0-9 A-z]+.{10}" title="Please AlphaNumeric Charecters" placeholder="Registration Number">
                                </div>
                                <div class="small-2 columns">
                                    <a href="#" id="search" class="button postfix"><img src="img/search.svg" width="40px" height="40px" /></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- -->
                <div class="row">
                    <div class="large-12 columns" >
                        <h6 class="round text-center" style="background-color:red" id="error"></h6>
                    </div>
                </div>

                <!-- Details -->

                <div class="row">
                    <div class="large-4 columns">
                        <img src="img/dp.jpg" />
                    </div>
                    <div class="large-8 columns">
                        <div class="row">
                            <div class="large-5 columns text-right">
                                <h3>Regd Number:</h3>
                            </div>
                            <div class="large-7 columns">
                                <h4 id="sid"></h4>
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-5 columns text-right">
                                <h3>Name:</h3>
                            </div>
                            <div class="large-7 columns">
                                <h4 id="name"></h4>
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-5 columns text-right">
                                <h4>Father Name:</h4>
                            </div>
                            <div class="large-7 columns">
                                <h4 id="fname"></h4>
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-5 columns text-right">
                                <h3>Mother Name:</h3>
                            </div>
                            <div class="large-7 columns">
                                <h4 id="mname"></h4>
                            </div>
                        </div>
                        <div class="row">
                            <div class="large-5 columns text-right">
                                <h3>Address:</h3>
                            </div>
                            <div class="large-7 columns">
                                <h4 id="address"></h4>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="large-12 columns" style="border-bottom:ridge; border-top:ridge;">
                        <h3 align="center">Academics</h3>
                    </div>
                </div>

                <div class="row">
                    <div class="large-12 columns">
                        <ul class="tabs" data-tab>
                            <li class="tab-title active" style="width:50%;"><a href="#panel11" style="" >First Year</a></li>
                            <li class="tab-title" style="width:50%;"><a href="#panel21">Second Year</a></li>
                        </ul>
                        <div class="tabs-content">
                            <div class="content active" id="panel11" style="padding:20px;">
                                <div class="row" style="border-bottom:inset;">
                                    <div class="large-8 columns">
                                        <h4>Sub 1</h4>
                                    </div>
                                    <div class="large-4 columns">
                                        <h4 id="s1"></h4>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="large-8 columns">
                                        <h4>Sub 1</h4>
                                    </div>
                                    <div class="large-4 columns">
                                        <h4 id="s2"></h4>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="large-8 columns">
                                        <h4>Sub 1</h4>
                                    </div>
                                    <div class="large-4 columns">
                                        <h4 id="s3"></h4>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="large-8 columns">
                                        <h4>Sub 1</h4>
                                    </div>
                                    <div class="large-4 columns">
                                        <h4 id="s4"></h4>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="large-8 columns">
                                        <h4>Sub 1</h4>
                                    </div>
                                    <div class="large-4 columns">
                                        <h4 id="s5"></h4>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="large-8 columns">
                                        <h4>Sub 1</h4>
                                    </div>
                                    <div class="large-4 columns">
                                        <h4 id="s6"></h4>
                                    </div>
                                </div>
                            </div>
                            <div class="content" id="panel21" style="padding:20px;">
                                <div class="row">
                                    <div class="large-8 columns">
                                        <h4>Sub 6</h4>
                                    </div>
                                    <div class="large-4 columns">
                                        <h4 id="s7"></h4>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="large-8 columns">
                                        <h4>Sub 7</h4>
                                    </div>
                                    <div class="large-4 columns">
                                        <h4 id="s8"></h4>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="large-8 columns">
                                        <h4>Sub 8</h4>
                                    </div>
                                    <div class="large-4 columns">
                                        <h4 id="s9"></h4>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="large-8 columns">
                                        <h4>Sub 9</h4>
                                    </div>
                                    <div class="large-4 columns">
                                        <h4 id="s10"></h4>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="large-8 columns">
                                        <h4>Sub 10</h4>
                                    </div>
                                    <div class="large-4 columns">
                                        <h4 id="s11"></h4>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="large-8 columns">
                                        <h4>Sub 11</h4>
                                    </div>
                                    <div class="large-4 columns">
                                        <h4 id="s12"></h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

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
<div class="row fullWidth" style="margin-bottom:0px;">
    <div class="icon-bar five-up" role="navigation">
        <a class="item" aria-labelledby="#itemlabel1" href="home.html">
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
            timer_speed: 1500,
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
    $(document).foundation({
        tab: {
            callback: function (tab) {
                console.log(tab);
            }
        }
    });
    $(document).ready(function(){
        var id = window.location.search.split('=')[1];
        if(id != null)
        {
            $("#searchBar").hide();
            getDetails(id);
        }
    });

    $("#search").click(function(){
        getDetails($("#id"),val());
    });
    $("#error").css("display","block");
    function getDetails(id)
    {
        //$("#error").show(100);
        $.get("/contacts/www/"+id, function(res){
            if(res.id != null){
                $("#error").css("display","none");
                $("#sid").text(res.id);
                $("#name").text(res.name);
                $("#fname").text(res.fname);
                $("#mname").text(res.mname);
                //$("#clg").text(res.clg);
                $("#address").text(res.address);
                for(var i=0;i<12;i++)
                    $("h4[id="+i+"]").text(res.s[i]);
            }
            else
            {
                $("#error").css("display","block");
                $("#error").text("No details found..!");
            }
        });
    }
</script>
</body>
</html>