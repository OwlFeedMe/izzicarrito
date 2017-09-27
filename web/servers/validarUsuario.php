<?php

    header("Access-Control-Allow-Origin: *");
    session_start();

    $servername = "localhost";
    $username = "id1879842_administrador";
    $dbname = "id1879842_librarysoft";
    $password ="21272004m";

    $conn = mysqli_connect($servername, $username, $password, $dbname) or die("Error " . mysqli_error($connection));

    

    $user = $_POST['valor1'];
    $pass = $_POST['valor2'];    
    $sql = "select * from usuarios where identificador ='$user' and clave='$pass'";
    $sql2 = "select nombreSol from usuarios where identificador='$user'";
    $_SESSION["identificador"] = $user;
    $_SESSION["clave"] = $pass;

    $result = mysqli_query($conn, $sql) or die("Error in Selecting " . mysqli_error($conn));
    $emparray = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $emparray[] = $row;
    }
    echo json_encode($emparray);
    mysqli_close($conn);


?>
