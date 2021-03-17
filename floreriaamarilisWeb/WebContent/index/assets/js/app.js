$(document).ready(function() { 

	var beepOne = $("#beep-one")[0];
	$("#nav a").mouseenter(function() {
		beepOne.play();
	});


}); 