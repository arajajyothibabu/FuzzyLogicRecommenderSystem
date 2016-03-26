$("#details").on('click', dynamicStyles);
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
        active_class: 'active'
    }
});

function dynamicStyles()
{
    var inputs = $(":input");
    //var form = $("input[@name^=myname]");
    inputs.css("border-color","red");
}
$("#submit").on('click', dynamicStyles);

