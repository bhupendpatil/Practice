<?php
	$client = new SoapClient("http://127.0.0.1:9876/mypackage?wsdl");
	echo $client -> getTimeAsString();
	echo $client -> getTimeAsElapsed();
?>