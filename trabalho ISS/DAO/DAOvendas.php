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

                $sql_quant_produto = "SELECT qnt_produto FROM produto WHERE cod_Produto = $id_produto";
                $qry_quant_produto = mysqli_query($conexao, $sql_quant_produto);
                $p_estoque = mysqli_fetch_assoc($qry_quant_produto);
                $estoque = $p_estoque['qnt_produto'];

                if($estoque < $quantidade){
                    $sql_aguarda = "INSERT INTO observer(id_venda, id_produto, quantidade, status)
                            VALUES ('$id_ultima_venda', '$id_produto', '$quantidade', '1')";
                    $qry_aguarda = mysqli_query($conexao, $sql_aguarda);

                    $sql_set_espera = "UPDATE venda SET status_Venda= '6' WHERE id_venda = '$id_ultima_venda'";
                    $qry_set_espera = mysqli_query($conexao, $sql_set_espera);
                }else{
                    $sub = $estoque-$quantidade;
                    $sql_set_espera = "UPDATE produto SET qnt_produto= $sub WHERE cod_Produto = '$id_produto'";
                    $qry_set_espera = mysqli_query($conexao, $sql_set_espera);
                }

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
        $sql = "UPDATE venda SET status_Venda= '5' WHERE id_venda = '$id'";
        $qry = mysqli_query($conexao, $sql);
        $sql_del = "DELETE FROM produtos_venda WHERE id_venda = '$id'";
        $qry_del = mysqli_query($conexao, $sql_del);
        print "<script type = 'text/javascript'> alert('Venda excluida com sucesso!'); location.href='../controler/listar_vendas.php'</script>";
        break;
    case('devolver'):
        $id = $_GET['id'];
        $sql = "UPDATE venda SET status_Venda= '4' WHERE id_venda = '$id'";
        $qry = mysqli_query($conexao, $sql);
        print "<script type = 'text/javascript'> alert('Venda devolvida com sucesso!'); location.href='../controler/listar_vendas.php'</script>";
        break;
    case('efetivar'):
        $id = $_GET['id_venda'];
        $sql = "UPDATE venda SET status_Venda= '1' WHERE id_venda = '$id'";
        $qry = mysqli_query($conexao, $sql);

        $sql_id_observer = "SELECT * FROM observer WHERE id_venda = '$id'";
        $qry_id_observer = mysqli_query($conexao, $sql_id_observer);
        while($dados_observer = mysqli_fetch_assoc($qry_id_observer)){
            $id_produto_observer = $dados_observer['id_produto'];
            $quant_produto_observer = $dados_observer['quantidade'];

            $sql_quant_produto = "SELECT qnt_produto FROM produto WHERE cod_Produto = $id_produto_observer";
            $qry_quant_produto = mysqli_query($conexao, $sql_quant_produto);
            $p_estoque = mysqli_fetch_assoc($qry_quant_produto);
            $estoque = $p_estoque['qnt_produto'];

            $sub = $estoque-$quant_produto_observer;
            $sql_set_espera = "UPDATE produto SET qnt_produto= $sub WHERE cod_Produto = '$id_produto_observer'";
            $qry_set_espera = mysqli_query($conexao, $sql_set_espera);
        }

        $sql_del = "DELETE FROM observer WHERE id_venda = '$id'";
        $qry_del = mysqli_query($conexao, $sql_del);

        print "<script type = 'text/javascript'> alert('Venda efetivada com sucesso!'); location.href='../controler/listar_observadores.php'</script>";
        break;
    case('cancelar'):
        $id = $_GET['id_venda'];
        $sql = "UPDATE observer SET status= '0' WHERE id_venda = '$id'";
        $qry = mysqli_query($conexao, $sql);

        $sql_cancela = "UPDATE venda SET status_Venda= '7' WHERE id_venda = '$id'";
        $qry_calcela = mysqli_query($conexao, $sql_cancela);

        print "<script type = 'text/javascript'> alert('Venda suspensa com sucesso!'); location.href='../controler/listar_observadores.php'</script>";
        break;
    case('reativar'):
        $id = $_GET['id_venda'];
        $sql = "UPDATE observer SET status= '1' WHERE id_venda = '$id'";
        $qry = mysqli_query($conexao, $sql);

        $sql_reativa = "UPDATE venda SET status_Venda= '6' WHERE id_venda = '$id'";
        $qry_reativa = mysqli_query($conexao, $sql_reativa);

        include('../controler/observer.php');

        print "<script type = 'text/javascript'> alert('Venda reativada com sucesso!'); location.href='../controler/listar_observadores.php'</script>";
        break;
}
