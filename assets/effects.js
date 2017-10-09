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