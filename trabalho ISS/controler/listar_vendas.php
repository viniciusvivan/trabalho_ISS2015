<?php

include("observer.php");
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

        function confirma_devolucao(id) {
            decisao = confirm("Marcar como devolvido?");
            if(decisao){
                window.location.href="../DAO/DAOvendas.php?acao=devolver&id="+id;
            }
        }
    </SCRIPT>

</head>
<body>
<header>
    <span class="texto_pequeno" style="margin: 10px 0 0 790px; position: absolute">Sistema de distribuição de geladinhos</span>
</header>
<nav style="width: 100%; background-color: #f1f1f1; height: 40px">
    <table style=" position: absolute; margin: 0 820px 0 820px">
        <tr>
            <td><a href="vendas.php"><input style="margin-right: 10px" type="button" class="btn btn-default" value="Vendas"></a></td>
            <td><a href="relatorio.php"><input style="margin-left: 10px" type="button" class="btn btn-default" value="Relatórios"></a></td>
            <td><a href="../view/ajuda.html" target="_blank"><input style="margin-left: 18px" type="button" class="btn btn-default" value="Ajuda"></a></td>
        </tr>
    </table>
</nav>
<section style="width: 1650px" class="corpo">
    <h1 class="texto_grande" style="display: inline-block; margin-left: 25px">Consulta de vendas</h1>
    <a href="vendas.php" style="display: inline; margin-top: 10px; position: absolute; margin-left: 1200px"><button type="button" class="btn btn-default navbar-btn" style="color:#333333;">Voltar para vendas</button></a>
    <a href="listar_observadores.php" style="display: inline; margin-top: 10px; position: absolute; margin-left: 1000px"><button type="button" class="btn btn-default navbar-btn" style="color:#333333;">Vendas em andamento</button></a>
    <hr>
    <table border='1' bordercolor='#484848' class="produtos-adicionados">
        <tr style="font-weight:bold;background:#484848;color:#FFF;">
            <td colspan="15"><p class="txt-produto"><p align="center"><b>Vendas Feitas</b></p></td>
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
            <td width="150" align="center"><p class="txt-produto"><b>Devolução</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Nota Fiscal</b></p></td>
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
            $nome = $cliente['nome_cliente'];
            if($vendas['status_Venda'] != 5 and $vendas['status_Venda'] != 6 and $vendas['status_Venda'] != 7 and $vendas['status_Venda'] != 10){
                if($vendas['status_Venda'] == 1){
                    echo "<tr style='background-color: rgba(92, 184, 92, 0.42)'>";
                }else if($vendas['status_Venda'] == 2){
                        echo "<tr style='background-color: rgba(255, 186, 80, 0.77)'>";
                }else if($vendas['status_Venda'] == 3){
                        echo "<tr style='background-color: rgba(59, 192, 255, 0.29)'>";
                }else if($vendas['status_Venda'] == 4){
                        echo "<tr style='background-color: rgb(255, 255, 255)'>";
                }else if($vendas['status_Venda'] == 6 or $vendas['status_Venda'] == 10){
                        echo "<tr style='background-color: rgba(219, 31, 255, 0.31)'>";
                }else{
                    echo "<tr>";
                }?>
                    <td align='center'><p class='txt-produto'><?php echo $vendas['id_venda'] ?></p></td>
                    <td align='center'><p class='txt-produto'><?php echo $nome?></p></td>
                    <td align='center'><p class='txt-produto'><?php echo $data?></p></td>
                    <td align='center'><p class='txt-produto'><?php echo 'R$'.$subtotal?></p></td>
                    <td align='center'><p class='txt-produto'><?php echo 'R$'.$frete?></p></td>
                    <td align='center'><p class='txt-produto'><?php echo 'R$'.$total?></p></td>
                    <td align='center'><p class='txt-produto'><?php if($vendas['status_Venda'] == 1){echo "Aguardando pagamento";}elseif($vendas['status_Venda'] == 2){echo "Aguardando entrega";}elseif($vendas['status_Venda'] == 3){echo "Concluído";}elseif($vendas['status_Venda'] == 4){echo "Devolvido";}elseif($vendas['status_Venda'] == 6){echo "Em andamento";}else{echo "Excluido";}?></p></td>
                    <td align='center'><p class='txt-produto'><?php if($vendas['pagamento_Venda'] == 'Boleto'){echo "Boleto à Vista";}elseif($vendas['pagamento_Venda'] == '0'){echo "Aguardando pagamento";}else{echo $vendas['pagamento_Venda'].'x no cartão';}?></p></td>
                    <td style="background-color: #ebebeb;" align='center'><a href="produtos.php?id_venda=<?php echo $vendas['id_venda']?>&id_cliente=<?php echo $vendas['cod_Cliente']?>" target="_blank"><button type='button' class='btn btn-info' style='color:white; font-weight: bolder'>Produtos</button></a></td>
                    <td style="background-color: #ebebeb;" align='center'><button type='button' class='btn btn-danger navbar-btn' style='color:white; font-weight: bolder'; onclick='confirma(<?php echo $vendas['id_venda'] ?>)'>Excluir</button>
                    <?php if($vendas['status_Venda'] == 1){
                        if($vendas['pagamento_Venda'] == 'Boleto'){?>
                            <td style="background-color: #ebebeb;" align='center'><a href="../DAO/DAOpagamento.php?acao=boleto&id_venda=<?php echo $vendas['id_venda']?>"><button type='button' class='btn btn-success' style='color:white; font-weight: bolder'>Boleto Pago</button></a></td>
                        <?php }else{ ?>
                            <td style="background-color: #ebebeb;" align='center'><a href="pagamento_opcao.php?id_venda=<?php echo $vendas['id_venda']?>&cliente=<?php echo $nome?>&total=<?php echo $total_float?>&frete=<?php echo $frete_float?>"><button type='button' class='btn btn-success' style='color:white; font-weight: bolder'>À pagar</button></a></td>
                        <?php } ?>
                    <?php }else{?>
                        <td style="background-color: #ebebeb;" align='center'><button type='button' class='btn btn-success' style='color:white; font-weight:bolder' disabled>Pago</button></td>
                    <?php } ?>

                    <?php if($vendas['status_Venda'] == 2){?>
                        <td style="background-color: #ebebeb;" align='center'><button type='button' class='btn btn-warning' style='color:white; font-weight: bolder'; onclick='confirma_entrega(<?php echo $vendas['id_venda'] ?>)'>Confirmar</button></td>
                    <?php }else if($vendas['status_Venda'] == 1){?>
                        <td style="background-color: #ebebeb;" align='center'><button type='button' class='btn btn-warning' style='color:white; font-weight: bolder' disabled>Aguardando</button></td>
                    <?php }else{?>
                        <td style="background-color: #ebebeb;" align='center'><button type='button' class='btn btn-warning' style='color:white; font-weight: bolder' disabled>Entregue</button></td>
                    <?php } ?>


                    <?php if($vendas['status_Venda'] == 1){?>
                        <td style="background-color: #ebebeb;" align='center'><button type='button' class='btn btn-default' style='color:black; font-weight: bolder' disabled>Devolver</button></td>
                    <?php }else if($vendas['status_Venda'] == 4){?>
                        <td style="background-color: #ebebeb;" align='center'><button type='button' class='btn btn-default' style='color:black; font-weight: bolder' disabled>Devolvido</button></td>
                    <?php }else{?>
                        <td style="background-color: #ebebeb;" align='center'><button type='button' class='btn btn-default' style='color:black; font-weight: bolder'; onclick='confirma_devolucao(<?php echo $vendas['id_venda'] ?>)'>Devolver</button></td>
                    <?php } ?>

                    <td style="background-color: #ebebeb;" align='center'><a href="../gerarpdf/nota_fiscal.php?id_venda=<?php echo $vendas['id_venda']?>&cliente=<?php echo $nome?>&total=<?php echo $total_float?>&frete=<?php echo $frete_float?>" target="_blank"><button type='button' class='btn btn-primary' style='color:white; font-weight: bolder'>Solicitar</button></a></td>

                    <?php if($vendas['status_Venda'] == 2 or $vendas['status_Venda'] == 3 or $vendas['status_Venda'] == 4){?>
                        <td style="background-color: #ebebeb;" align='center'><a href="../gerarpdf/comprovante.php?id_venda=<?php echo $vendas['id_venda']?>&cliente=<?php echo $nome?>&total=<?php echo $total_float?>&frete=<?php echo $frete_float?>" target="_blank"><button type='button' class='btn btn-primary' style='color:white; font-weight: bolder'>Solicitar</button></a></td>
                    <?php }else{?>
                        <td style="background-color: #ebebeb;" align='center'><button type='button' class='btn btn-primary' style='color:white; font-weight: bolder' disabled>Indisponivel</button></td>
                    <?php } ?>


                </tr>
        <?php }} ?>
    </table>
</section>
</body>
</html>