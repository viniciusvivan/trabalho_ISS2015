<?php
$host = "localhost";
$usuario= "root";
$senha= "GUItar1234Solo";
$banco = "iss";

$conexao = mysqli_connect($host, $usuario, $senha) or die("Não foi Possivel se conectar ao servidor");
mysqli_select_db($conexao, $banco) or die("Erro ao conextar");