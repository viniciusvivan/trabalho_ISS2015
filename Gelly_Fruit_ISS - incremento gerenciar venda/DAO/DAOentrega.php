<?php
include('../DAO/conexao.php');
$id_venda = $_GET['id_venda'];

$sql = "UPDATE venda SET status_Venda= '3' WHERE id_venda = '$id_venda'";
if($qry = mysqli_query($conexao, $sql)){
    print "<script type = 'text/javascript'> alert('Marcado como entregue!'); location.href='../controler/listar_vendas.php'</script>";
}