<?php

include("../DAO/conexao.php");
?>

<!DOCTYPE html>
<html>
<head lang="pt-br">
    <meta charset="UTF-8">
    <title>Vendas Feitas</title>
    <link href="../bootstrap-3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="../bootstrap-3.3.4/css/bootstrap-select.css">
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">

    <SCRIPT LANGUAGE="JavaScript" TYPE="text/javascript">
        function confirma(id) {
            decisao = confirm("Deseja realmente excluir?");
            if(decisao){
                window.location.href="../DAO/DAOvendas.php?acao=excluir&id="+id;
            }
        }

        function confirma_entrega(id) {
            decisao = confirm("Marcar como entregue?");
            if(decisao){
                window.location.href="../DAO/DAOentrega.php?id_venda="+id;
            }
        }
    </SCRIPT>

</head>
<body>
<header>
    <span class="texto_pequeno" style="margin: 10px 0 0 790px; position: absolute">Sistema de distribuição de geladinhos</span>
</header>
<nav style="width: 100%; background-color: #f1f1f1; height: 40px">
    <table style=" position: absolute; margin: 0 870px 0 870px">
        <tr>
            <td><a href="vendas.php"><input style="margin-right: 10px" type="button" class="btn btn-default" value="Vendas"></a></td>
            <td><a href="relatorio.php"><input style="margin-left: 10px" type="button" class="btn btn-default" value="Relatórios"></a></td>
        </tr>
    </table>
</nav>
<section style="width: 1300px" class="corpo">
    <h1 class="texto_grande" style="display: inline-block; margin-left: 25px">Consulta de vendas</h1>
    <a href="vendas.php" style="display: inline; margin-top: 10px; position: absolute; margin-left: 860px"><button type="button" class="btn btn-default navbar-btn" style="color:#333333;">Voltar para vendas</button></a>
    <hr>
    <table border='1' bordercolor='#484848' class="produtos-adicionados">
        <tr style="font-weight:bold;background:#484848;color:#FFF;">
            <td colspan="13"><p class="txt-produto"><p align="center"><b>Vendas Feitas</b></p></td>
        </tr>
        <tr>
            <td width="100" align="center"><p class="txt-produto"><b>Protocolo</b></p></td>
            <td width="450" align="center"><p class="txt-produto"><b>Cliente</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Data</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Subtotal</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Frete</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Total</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Status</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Forma de pagamento</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Produtos</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Excluir Venda</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Pagar</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Entrega</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Comprovante de pagamento</b></p></td>
        </tr>
        <?php
        $slq = "SELECT * FROM venda";
        $qry = mysqli_query($conexao, $slq);
        while($vendas = mysqli_fetch_assoc($qry)){
            $data = date('d/m/Y', strtotime($vendas['data_Venda']));
            $total = $vendas['valortotal_Venda'];
            $frete = $vendas['entrega_Venda'];
            $subtotal = $total-$frete;
            $total_float = $total;
            $frete_float = $frete;
            $total = number_format($total, 2, ',', '.');
            $frete = number_format($frete, 2, ',', '.');
            $subtotal = number_format($subtotal, 2, ',', '.');

            $slq_cliente = "SELECT nome_cliente FROM cliente WHERE id_cliente = $vendas[cod_Cliente]";
            $qry_cliente = mysqli_query($conexao, $slq_cliente);
            $cliente = mysqli_fetch_assoc($qry_cliente);
            $nome = $cliente['nome_cliente'];?>
                <tr>
                    <td align='center'><p class='txt-produto'><?php echo $vendas['id_venda'] ?></p></td>
                    <td align='center'><p class='txt-produto'><?php echo $nome?></p></td>
                    <td align='center'><p class='txt-produto'><?php echo $data?></p></td>
                    <td align='center'><p class='txt-produto'><?php echo 'R$'.$subtotal?></p></td>
                    <td align='center'><p class='txt-produto'><?php echo 'R$'.$frete?></p></td>
                    <td align='center'><p class='txt-produto'><?php echo 'R$'.$total?></p></td>
                    <td align='center'><p class='txt-produto'><?php if($vendas['status_Venda'] == 1){echo "Aguardando pagamento";}elseif($vendas['status_Venda'] == 2){echo "Aguando entrega";}else{echo "Concluido";}?></p></td>
                    <td align='center'><p class='txt-produto'><?php if($vendas['pagamento_Venda'] == 'Boleto'){echo "Boleto à Vista";}elseif($vendas['pagamento_Venda'] == '0'){echo "Aguardando pagamento";}else{echo $vendas['pagamento_Venda'].'x no cartão';}?></p></td>
                    <td align='center'><a href="produtos.php?id_venda=<?php echo $vendas['id_venda']?>&id_cliente=<?php echo $vendas['cod_Cliente']?>" target="_blank"><button type='button' class='btn btn-info' style='color:white; font-weight: bolder'>Produtos</button></a></td>
                    <td align='center'><button type='button' class='btn btn-danger navbar-btn' style='color:white; font-weight: bolder'; onclick='confirma(<?php echo $vendas['id_venda'] ?>)'>Excluir</button>
                    <?php if($vendas['status_Venda'] == 1){?>
                        <td align='center'><a href="pagamento_opcao.php?id_venda=<?php echo $vendas['id_venda']?>&cliente=<?php echo $nome?>&total=<?php echo $total_float?>&frete=<?php echo $frete_float?>"><button type='button' class='btn btn-success' style='color:white; font-weight: bolder'>À pagar</button></a></td>
                    <?php }else{?>
                        <td align='center'><button type='button' class='btn btn-success' style='color:white; font-weight:bolder' disabled>Pago</button></td>
                    <?php } ?>
                    <?php if($vendas['status_Venda'] == 2){?>
                        <td align='center'><button type='button' class='btn btn-warning' style='color:white; font-weight: bolder'; onclick='confirma_entrega(<?php echo $vendas['id_venda'] ?>)'>Confirmar</button></td>
                    <?php }else if($vendas['status_Venda'] == 1){?>
                        <td align='center'><button type='button' class='btn btn-warning' style='color:white; font-weight: bolder' disabled>Aguardando</button></td>
                    <?php }else{?>
                        <td align='center'><button type='button' class='btn btn-warning' style='color:white; font-weight: bolder' disabled>Entregue</button></td>
                    <?php } ?>
                    <?php if($vendas['status_Venda'] == 2 or $vendas['status_Venda'] == 3){?>
                        <td align='center'><a href="../gerarpdf/comprovante.php?id_venda=<?php echo $vendas['id_venda']?>&cliente=<?php echo $nome?>&total=<?php echo $total_float?>&frete=<?php echo $frete_float?>" target="_blank"><button type='button' class='btn btn-primary' style='color:white; font-weight: bolder'>Solicitar</button></a></td>
                    <?php }else{?>
                        <td align='center'><button type='button' class='btn btn-primary' style='color:white; font-weight: bolder' disabled>Indisponivel</button></td>
                    <?php } ?>
                </tr>
        <?php } ?>
    </table>
</section>
</body>
</html>