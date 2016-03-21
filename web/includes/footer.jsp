<%--
  Created by IntelliJ IDEA.
  User: Araja Jyothi Babu
  Date: 21-Mar-16
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<!-- Footer -->
    </div>
</div>
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
