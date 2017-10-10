window.sr = ScrollReveal({reset:true});
sr.reveal('.title',{origin: 'left', duration: 1000});
sr.reveal('.name',{origin: 'left', duration: 1000});
sr.reveal('.aboutText',{origin:'left',duration: 1000});


$('a[href^="#"]').on('click', function(event) {
    var target = $(this.getAttribute('href'));
    if( target.length ) {
        event.preventDefault();
        $('html, body').stop().animate({
            scrollTop: target.offset().top-70
        }, 500);
    }
});


$(document).ready(function(){
	$(window).scroll(function() {
	    var height = $(window).scrollTop();

	    // console.log(height);
	if (height >20){
		$(".mustache").fadeIn(250);
	}
    if (height <= 420){
	    	$("#nzdawg").css("color", "#ff9d00");
	    }
	   if (height > 420 && height <=965){
	   	 	$("#nzdawg").css("color", "#4175fc");
	   }
	if (height > 965 && height <1500){
		$("#nzdawg").css("color", "#3ca365");
	} 
	if (height > 1500){
		$("#nzdawg").css("color", "#ad0938");
	} 
	
	 
	});
});