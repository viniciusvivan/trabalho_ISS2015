<?php
session_start();
include "../DAO/conexao.php";
$acao = $_GET['acao'];

switch($acao){
    case('gravar'):
        $id_cli = $_GET['id_cli'];
        $frete = $_GET['frete'];
        $subtotal = $_GET['subt'];
        $total = $subtotal+$frete;
        date_default_timezone_set('America/Sao_Paulo');
        $data = date('Y-m-d');
        $sql = "INSERT INTO venda(status_Venda, data_Venda, cod_Cliente, entrega_Venda, valortotal_Venda, pagamento_Venda)
                            VALUES ('1', '$data', '$id_cli', '$frete', '$total', '0')";

        if (mysqli_query($conexao, $sql)) {
            $flag = true;
        } else {
            $flag = false;
        }

        $sql_busca_id = "SELECT id_venda FROM venda WHERE id_venda = (SELECT MAX(id_venda) FROM venda);";
        $qry_busca_id = mysqli_query($conexao, $sql_busca_id);
        $ultimo_id = mysqli_fetch_assoc($qry_busca_id);
        $id_ultima_venda = $ultimo_id['id_venda'];

        for($i=-1; $i < (count($_SESSION['lista_produtos']))-1; $i++)
            if($_SESSION['lista_produtos'][$i] != -1){
                $id_produto = $_SESSION['lista_produtos'][$i];
                $quantidade = $_SESSION['quantidade_produtos'][$i];
                $sql_produtos = "INSERT INTO produtos_venda(id_venda, id_produto, quantidade)
                            VALUES ('$id_ultima_venda', '$id_produto', $quantidade)";
                $qry_produtos = mysqli_query($conexao, $sql_produtos);
        }

        if($flag) print "<script type = 'text/javascript'> alert('Venda registrada, Aguardando pagamento!');</script>";
        else print "<script type = 'text/javascript'> alert('Erro ao cadastrar! - Renicie o Processo');</script>";

        if($_GET['pagar'] == 's'){
            $sql_cli = "SELECT nome_cliente FROM cliente WHERE id_cliente = $id_cli";
            $qry_cli = mysqli_query($conexao, $sql_cli);
            $cliente = mysqli_fetch_assoc($qry_cli);
            $nome = $cliente['nome_cliente'];
            print "<script type = 'text/javascript'>location.href='../controler/pagamento_opcao.php?id_venda=$id_ultima_venda&cliente=$nome&total=$total&frete=$frete'</script>";
        }
        else print "<script type = 'text/javascript'>location.href='../controler/listar_vendas.php'</script>";
        break;
    case('excluir'):
        $id = $_GET['id'];
        $sql = "DELETE FROM venda WHERE id_venda = '$id'";
        $qry = mysqli_query($conexao, $sql);
        print "<script type = 'text/javascript'> alert('Venda excluida com sucesso!'); location.href='../controler/listar_vendas.php'</script>";
        break;
}
