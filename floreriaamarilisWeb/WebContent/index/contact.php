<?php

$your_email = "gissela@gmail.com";

$headers= "From: ".$_POST['name']." <".$_POST['email'].">\r\n";
$headers.='Content-type: text/html; charset=utf-8';
mail($your_email, $_POST['subject'],  "
<html>
<head>
 <title>Contact Message</title>
</head>
<body>
	Contact Message<br><br>
	Name : ".$_POST['name']."<br>
	Email : ".$_POST['email']."<br>
	Telephone : ".$_POST['telephone']."<br><br>
	Subject : ".$_POST['subject']."<br>
	Message : <br>".$_POST['message']."<br>
</body>
</html>" , $headers);
header("Location: form_success.htm");

?>
