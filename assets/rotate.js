var inc = 0;
var css_text;
var update;

$(document).ready(function(){
	 update = setInterval(spinIntroBlock,200);
});

function spinIntroBlock(){
	inc += 1;
	inc = inc % 360;
	css_text ="linear-gradient("+ (-135-inc) +"deg, rgba(0,0,0,0),rgba(0,0,0,.6)),linear-gradient("+(180+inc)+"deg, rgba(0,0,255,0),rgba(0,0,255,.2)),linear-gradient("+(45+inc)+"deg, rgba(100,0,0,0),rgba(255,0,0,.3)),linear-gradient("+(-45-inc)+"deg, #4175fc, #221dc1)";
	$(".introBlock").css("background-image",css_text);
}