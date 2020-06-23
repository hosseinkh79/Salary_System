<?php
include "connect.php";
$national_code = $_POST["national_code"];
$persnality_code = $_POST["persnality_code"];
$query = "SELECT * FROM person WHERE national_code=:national_code AND persnality_code=:persnality_code";
$res = $connect->prepare($query);
$res->bindParam(":national_code", $national_code);
$res->bindParam(":persnality_code", $persnality_code);
$res->execute();
$row = $res->fetch(PDO::FETCH_ASSOC);
if (!$row) {
    echo '{"status":"error","message":"not found"}';
} else {
	
	$query1="SELECT * FROM person WHERE national_code=:national_code";
	$res1=$connect->prepare($query1);
	$res1->execute();
	$row1 = $res1->fetch(PDO::FETCH_ASSOC);
	
	echo '{"status":"success","message":"'.$row["person_id"].'"}';
	
    // echo '{"status":"success","message":"'.$row["national_code"].'"}';
}






