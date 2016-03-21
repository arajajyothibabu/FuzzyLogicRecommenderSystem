$("#details").on('click', dynamicStyles);
function validate() {
    var name = $("#name").val();
    var fname = $("#fname").val();
    var mname = $("#mname").val();
    var clg = $("#clg").val();
    var address = $("#address").val();
    var reg = new RegExp("^[A-Z ( ) a-z]+$");
    var regAdd = new RegExp("^[A-Z 0-9 , / - a-z]+$");
    var regComma = new RegExp("[, ]*");
    //var text = name + ", " + fname + ", " + mname + ", " + clg + ", " + address;
    //console.log(text);
    var text = "Error in ";
    $("#details").show();
    if (!name.match(reg)) text += ", " + "Name";
    if (!fname.match(reg)) text += ", " + "Father Name";
    if (!mname.match(reg)) text += ", " + "Mother Name";
    if (!clg.match(reg)) text += ", " + "College";
    if (!address.match(regAdd)) text += ", " + "Address";
    if (text == "Error in ")
    {
        var obj = new Object();
        obj.id = $("#id").val();
        obj.name = $("#name").val();
        obj.fname = $("#fname").val();
        obj.mname = $("#mname").val();
        obj.address = $("#address").val();
        obj.s=[];
        for(var i=0;i<12;i++)
            obj.s.push();
        $.post("http://localhost:3000/contacts/www",obj, function(res){
            window.location.replace("http://localhost:3000/login.html?id="+res);
        });
    }
    document.getElementById("details").innerHTML = text;
}
// $("#submit").on("click", validate);
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
//marks hiding
$(document).ready(function(){
    $("#link").click(function () {
        $("#marks").show(1000);
        $("#linkMarks").hide(1000);
    });
} );


$(document).foundation({
    dropdown: {
        // specify the class used for active dropdowns
        active_class: 'open'
    }
});

function dynamicStyles()
{
    var inputs = $(":input");
    //var form = $("input[@name^=myname]");
    inputs.css("border-color","red");
}
$("#submit").on('click', dynamicStyles);

