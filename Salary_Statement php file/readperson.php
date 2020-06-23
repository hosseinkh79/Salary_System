<?php
include "connect.php";


$person_id = $_POST["person_id"];


$query="SELECT * FROM person WHERE person_id=:person_id ";
$res=$connect->prepare($query);
$res->bindParam(":person_id", $person_id);
$res->execute();
$products=array();
while($row=$res->fetch(PDO::FETCH_ASSOC)){
	$record=array();
	$record["id"]=$row["person_id"];
	$record["name"]=$row["fname"];
	$record["lname"]=$row["lname"];
	$record["job_status"]=$row["job_status"];
	$record["national_code"]=$row["national_code"];
	$record["birth_place"]=$row["birth_place"];
	$record["persnality_code"]=$row["persnality_code"];
	$record["city_name"]=$row["city_id"];
	$record["departman"] = null;
	$record["degree"] = null;
	$record["since_com"]=null;
	$record["role"]=null;
	
	
	$sql="SELECT * FROM city WHERE city_id=:city_id";
	$res2=$connect->prepare($sql);
	$res2->bindParam(":city_id",$record["city_name"]);
	$res2->execute();
	$row2=$res2->fetch(PDO::FETCH_ASSOC);
	$record["city_name"]=$row2["name"];
	
}

$job = $record["job_status"];
$id = $record["id"];

if($job == "استاد"){
	$sql1="SELECT * FROM professor WHERE person_id=$id";
	$res1=$connect->prepare($sql1);
	$res1->execute();
	while($row1=$res1->fetch(PDO::FETCH_ASSOC)){
	$record1=array();
	$record1["departman"]=$row1["dep_id"];
	$record1["degree"]=$row1["degree_id"];
	$record1["fstatus"]=$row1["fstatus_id"];
	$record1["since_com"]=$row1["since_com_id"];

	
	$sql2="SELECT * FROM department WHERE dep_id=:dep_id";
	$res2=$connect->prepare($sql2);
	$res2->bindParam(":dep_id",$record1["departman"]);
	$res2->execute();
	$row2=$res2->fetch(PDO::FETCH_ASSOC);
	$record1["departman"]=$row2["name"];
	
	
	
	$sql="SELECT * FROM deg WHERE degree_id=:degree_id";
	$res2=$connect->prepare($sql);
	$res2->bindParam(":degree_id",$record1["degree"]);
	$res2->execute();
	$row2=$res2->fetch(PDO::FETCH_ASSOC);
	$record1["degree"]=$row2["name"];
	
	
	$sql="SELECT * FROM since_commite WHERE since_com_id=:since_com_id";
	$res2=$connect->prepare($sql);
	$res2->bindParam(":since_com_id",$record1["since_com"]);
	$res2->execute();
	$row2=$res2->fetch(PDO::FETCH_ASSOC);
	$record1["since_com"]=$row2["status"];
	
	
	$record["departman"]=$record1["departman"];
	$record["degree"]=$record1["degree"];
	$record["since_com"]=$record1["since_com"];
	
	
	
	$products[]=$record;
	}
	
	
}elseif($job == "مدیریت"){

	$sql1="SELECT * FROM management_committe WHERE person_id=$id";
	$res1=$connect->prepare($sql1);
	$res1->execute();
	while($row1=$res1->fetch(PDO::FETCH_ASSOC)){
	$record2=array();
	$record2["departman"]=$row1["dep_id"];
	$record2["degree"]=$row1["degree_id"];
	$record2["fstatus"]=$row1["fstatus_id"];
	$record2["role"]=$row1["role_id"];

	
	$sql="SELECT * FROM department WHERE dep_id=:dep_id";
	$res2=$connect->prepare($sql);
	$res2->bindParam(":dep_id",$record2["departman"]);
	$res2->execute();
	$row2=$res2->fetch(PDO::FETCH_ASSOC);
	$record2["departman"]=$row2["name"];
	
	
	$sql="SELECT * FROM deg WHERE degree_id=:degree_id";
	$res2=$connect->prepare($sql);
	$res2->bindParam(":degree_id",$record2["degree"]);
	$res2->execute();
	$row2=$res2->fetch(PDO::FETCH_ASSOC);
	$record2["degree"]=$row2["name"];
	
	
	$sql="SELECT * FROM manage_role WHERE role_id=:role_id";
	$res2=$connect->prepare($sql);
	$res2->bindParam(":role_id",$record2["role"]);
	$res2->execute();
	$row2=$res2->fetch(PDO::FETCH_ASSOC);
	$record2["role"]=$row2["status"];
	
	$record["departman"]=$record2["departman"];
	$record["degree"]=$record2["degree"];
	$record["role"]=$record2["role"];
	
	
	$products[]=$record;
	
	}
	
}elseif($job == "کارمند"){
	$sql1="SELECT * FROM employes WHERE person_id=$id";
	$res=$connect->prepare($sql1);
	$res->execute();
	while($row=$res->fetch(PDO::FETCH_ASSOC)){
	$record1=array();
	$record1["departman"]=$row["dep_id"];
	$record1["degree"]=$row["degree_id"];
	$record1["fstatus"]=$row["fstatus_id"];


	
	$sql="SELECT * FROM department WHERE dep_id=:dep_id";
	$res2=$connect->prepare($sql);
	$res2->bindParam(":dep_id",$record1["departman"]);
	$res2->execute();
	$row2=$res2->fetch(PDO::FETCH_ASSOC);
	$record1["departman"]=$row2["name"];
	
	
	$sql="SELECT * FROM deg WHERE degree_id=:degree_id";
	$res2=$connect->prepare($sql);
	$res2->bindParam(":degree_id",$record1["degree"]);
	$res2->execute();
	$row2=$res2->fetch(PDO::FETCH_ASSOC);
	$record1["degree"]=$row2["name"];
	
	
	$sql="SELECT * FROM manage_role WHERE role_id=:role_id";
	$res2=$connect->prepare($sql);
	$res2->bindParam(":role_id",$record1["role"]);
	$res2->execute();
	$row2=$res2->fetch(PDO::FETCH_ASSOC);

	
	$record["departman"]=$record1["departman"];
	$record["degree"]=$record1["degree"];
	$record["fstatus"]=$record1["fstatus"];
	
	
	$products[]=$record;
	}
	
}
echo JSON_encode($products);

?>