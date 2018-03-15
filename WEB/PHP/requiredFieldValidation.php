<!DOCTYPE html>
<html>
<head>
	<title>Required Field Validation</title>
</head>
<body>

<?php 

	$nameErr = "";

	if($_SERVER["REQUEST_METHOD"] == "POST") {
		if (empty($_POST["name"])){
			$nameErr = "Name is required";
		}
	}
		
?>
<form method = "POST" action="">
	Name : <input type="text" name="name"><?php echo $nameErr; ?><br/>

	<input type="submit" name="submit" value="submit">
</form>

</body>
</html>
