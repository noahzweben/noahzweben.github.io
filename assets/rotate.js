function hexToRgba(hex,a) {
    var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
    return result ? 
        "rgba("+parseInt(result[1], 16)+","+parseInt(result[2],16)+","+parseInt(result[3], 16)+","+a+")"
     : null;
}

var inc = 0;
var css_text;
var update;

$(document).ready(function(){
	 update = setInterval(spinIntroBlock,10);
});

function spinIntroBlock(){
	inc += .05;
	inc = inc % 360;
	css_text ="linear-gradient("+ (-135-inc) +"deg, rgba(0,0,0,.1),rgba(0,0,0,.8)),"; //black
	css_text += "linear-gradient("+(180+inc)+"deg, rgba(0,100,100,0),rgba(0,255,255,.2)),"; //green
	css_text += "linear-gradient("+(45+inc)+"deg, rgba(100,0,0,0),rgba(255,0,0,.3)),"; //red
	css_text += "linear-gradient("+(-45-inc)+"deg,"+hexToRgba("#4175fc",.98)+","+hexToRgba("#221dc1",.95)+"),"; //blue/purp
	css_text += "url('assets/triangles.jpg')";
	$(".introBlock").css("background-image",css_text);
}