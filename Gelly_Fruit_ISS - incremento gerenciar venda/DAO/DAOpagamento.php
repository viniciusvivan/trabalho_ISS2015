<?php
include('../DAO/conexao.php');
$acao = $_GET['acao'];
$id_venda = $_GET['id_venda'];

switch($acao){
    case "cartao":
        $parcela = $_GET['forma_pag'];
        $sql = "UPDATE venda SET pagamento_Venda = '$parcela', status_Venda= '2' WHERE id_venda = '$id_venda'";
        if($qry = mysqli_query($conexao, $sql)){
            print "<script type = 'text/javascript'> alert('Pagamento feito com sucesso!'); location.href='../controler/listar_vendas.php'</script>";
        }
}