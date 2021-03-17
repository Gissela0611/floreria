$( document ).ready(function() {
    
	/*var navsound = $("#nav-sound")[0];
	
	$("#nav a").mouseenter(function() {
		navsound.play();
	});*/

    $(function(){
        var bgMusic = $('#audio-transition')[0],
            playing = true;

        //to loop the sound
        /*bgMusic.addEventListener('ended', function() {
            this.currentTime = 0;
            if (playing) {
                this.play();
            }
        }, false);*/

        bgMusic.play();

        
        //To create a pause/play bouton
        /*$('#paused').click(function() {
            if (!bgMusic.paused) {
                bgMusic.pause();
                playing = false;
                $(this).css({backgroundPosition: '0 -21px'})
            } else {
                bgMusic.play();
                playing = true;
                $(this).css({backgroundPosition: '0 0'})
            }
        });*/
    });
	


});
