<?php
//Table employee
//id name
//1 abc 
//2 def 

$conn = mysqli_connect('localhost','demo','test','demo');

$sql = "select id,name from employee";

if($result=mysqli_query($conn,$sql)){
	echo "id name<br/>";
	while($row = mysqli_fetch_row($result)){
		printf("%s  %s \n",$row[0],$row[1]);
		echo "<br/>";
	}
}

mysqli_close($conn);

?>