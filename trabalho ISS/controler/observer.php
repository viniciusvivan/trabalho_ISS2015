<?php
include("../DAO/conexao.php");

$sql_observer = "SELECT qnt_produto, quantidade, id_venda, status FROM iss.observer inner join produto on cod_produto = id_produto ORDER BY id_venda";
$qry_observer = mysqli_query($conexao, $sql_observer);
$flag = false;
$id_ant = 0;
$i = 0;

while($observer = mysqli_fetch_assoc($qry_observer)){
    $status = $observer['status'];
    if($status == 0) continue;
    $id_venda = $observer['id_venda'];
    if($id_venda != $id_ant){
        $id_ant = $observer['id_venda'];
        $i = 0;
    }
    if($id_venda == $id_ant or $id_ant == 0) {
        $estoque = $observer['qnt_produto'];
        $venda = $observer['quantidade'];
        if ($estoque > $venda) {
            $id_ant = $observer['id_venda'];
            $i++;
        } else {
            $id_ant = $observer['id_venda'];
        }
        $sql_count = "SELECT id_venda FROM observer WHERE id_venda = $id_ant";
        $qry_count = mysqli_query($conexao, $sql_count);
        $count = mysqli_num_rows($qry_count);
        if($i == $count) {
            $sql_chegou = "UPDATE venda SET status_Venda= '10' WHERE id_venda = '$id_venda'";
            $qry_chegou = mysqli_query($conexao, $sql_chegou);
            print "<script type = 'text/javascript'> alert('Os produtos da venda #$id_ant chegaram!');</script>";
            $i = 0;
            $id_ant = $observer['id_venda'];
        }
    }
}