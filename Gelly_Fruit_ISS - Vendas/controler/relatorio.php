<?php
include("../DAO/conexao.php");
$data_inicial = "";
$data_final = "";
$cliente = "";
$produto = "";
$status = "";

if(isset($_GET['data_inicial'])){
    $data_inicial = $_GET['data_inicial'];
}if(isset($_GET['data_final'])){
    $data_final = $_GET['data_final'];
}if(isset($_GET['id_cliente'])){
    $cliente = $_GET['id_cliente'];
}if(isset($_GET['id_produto'])){
    $produto = $_GET['id_produto'];
}if(isset($_GET['status'])){
    $status = $_GET['status'];
}

if(strtotime($data_inicial) > strtotime($data_final)){
    print "<script>location.href='relatorio.php?data_inicial=&data_final=&id_cliente=$cliente&id_produto=$produto&status=$status'; alert('Erro: Data inicial maior que data final');</script>";
}

//*************Formulario da clausula WHERE de acordo com os parametros setados***********************************
$where = "WHERE";
$flag = "n";
if($data_inicial != ""){
    $data_inicial = date("Y-m-d", strtotime(str_replace('/', '-', $_GET["data_inicial"])));
    $where = $where." data_Venda >= '$data_inicial'";
    $flag = "y";
}
if($data_final != ""){
    $data_final = date("Y-m-d", strtotime(str_replace('/', '-', $_GET["data_final"])));
    if($flag == "y") $where = $where." AND data_Venda <= '$data_final'";
    else $where = $where." data_Venda <= '$data_final'";
    $flag = "y";
}
if($cliente != ""){
    $cliente = $_GET["id_cliente"];
    if($flag == "y") $where = $where." AND cod_Cliente = $cliente";
    else $where = $where." cod_Cliente = $cliente";
    $flag = "y";
}
if($produto != ""){
    $produto = $_GET["id_produto"];
    if($flag == "y") $where = $where." AND id_venda in(select id_venda from produtos_venda where id_produto = $produto)";
    else $where = $where." id_venda in(select id_venda from produtos_venda where id_produto = $produto)";
    $flag = "y";
}
if($status != ""){
    $status = $_GET["status"];
    if($flag == "y") $where = $where." AND status_Venda = $status";
    else $where = $where." status = $status";
    $flag = "y";
}
if($where == "WHERE") $where = "";
//***************************FIM Formula��o da clausula WHERE******************************


?>

<!DOCTYPE html>
<html>
<head lang="pt-br">
    <meta charset="UTF-8">
    <title>Vendas Feitas</title>
    <link href="../bootstrap-3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="../bootstrap-3.3.4/css/bootstrap-select.css">
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
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
<section class="corpo">
    <h1 class="texto_grande" style="display: inline-block; margin-left: 25px">Relatório Gerenciais</h1>
    <hr>

    <form role="form" method="get" action="relatorio.php">
        <h3 style="margin-left: 10px">Filtro</h3>

        <div class="dados_cliente_dois">
            <label>À partir de</label>
            <input class="form-control" id="data_inicial" name="data_inicial" type="date" value="<?php if(isset($_GET['data_inicial'])){echo "$data_inicial";}?>">
        </div>

        <div class="dados_cliente_dois">
            <label>Até</label>
            <input class="form-control" id="data_final" name="data_final" type="date" value="<?php if(isset($_GET['data_final'])){echo "$data_final";}?>">
        </div>

        <div class="dados_cliente_dois">
            <label>Filtrar por cliente</label>
            <select class="form-control" id="id_cliente" name="id_cliente">
                <option id="cliente" value="">Selecione</option>
                <?php
                $sql_cliente = "SELECT * FROM cliente ORDER BY nome_cliente";
                $qry_cliente = mysqli_query($conexao, $sql_cliente);
                while($linha = mysqli_fetch_assoc($qry_cliente)){
                    $id_cliente = $linha['id_cliente'];
                    $nome_cliente = $linha['nome_cliente'];
                    ?>
                    <option id="cliente" value="<?php echo $id_cliente;?>" <?php if(isset($_GET['id_cliente'])){if($id_cliente == $cliente) echo "selected";}?>><?php echo $nome_cliente ?></option>
                <?php } ?>
            </select>
        </div>

        <div class="dados_cliente_dois">
            <label>Filtrar por produto</label>
            <select class="form-control" id="id_produto" name="id_produto">
                <option id="produto" value="">Selecione</option>
                <?php
                $sql_produtos = "SELECT * FROM produto ORDER BY desc_produto";
                $qry_produtos = mysqli_query($conexao, $sql_produtos);
                while($linha = mysqli_fetch_assoc($qry_produtos)){
                    $id_produto = $linha['cod_Produto'];
                    $nome_produto = $linha['desc_Produto'];
                    $preco_custo = $linha['preco_Produto'];
                    ?>
                    <option id="cliente" value="<?php echo $id_produto;?>" <?php if(isset($_GET['id_produto'])){if($id_produto == $produto) echo "selected";}?>><?php echo $nome_produto ?></option>
                <?php } ?>
            </select>
        </div>

        <div class="dados_cliente_dois">
            <label>Filtrar por status</label>
            <select class="form-control" id="status" name="status">
                <option id="status" value="">Selecione</option>
                <option id="status" value="1" <?php if(isset($_GET['status'])){if($status == '1') echo "selected";}?>>Aguardando pagamento</option>
                <option id="status" value="2" <?php if(isset($_GET['status'])){if($status == '2') echo "selected";}?>>Aguardando entrega</option>
                <option id="status" value="3" <?php if(isset($_GET['status'])){if($status == '3') echo "selected";}?>>Concluido</option>
            </select>
        </div>
        <input class="btn btn-success" type='submit' name='acao' id='acao' value='Filtrar' style='color:white;font-weight: bolder;position: relative; margin: -70px 0 0 800px'/>
        <a href="relatorio.php" style="font-weight: bolder;position: absolute; margin: -41px 0 0 -146px"/><button type="button" class="btn btn-primary" style="color:white;font-weight: bold;float:right;margin-right:10px;">Limpar</button></a>
        <a href="../DAO/excel.php?data_inicial=<?php echo $data_inicial?>&data_final=<?php echo $data_final?>&id_cliente=<?php echo $cliente?>&id_produto=<?php echo $id_produto ?>&status=<?php echo $status?>" style="font-weight: bolder;position: absolute; margin: -41px 0 0 -270px"/><button type="button" class="btn btn-warning" style="color:white;font-weight: bold;float:right;margin-right:10px;">Gerar planilia</button></a>
        <hr>
    </form>

    <table border='1' bordercolor='#484848' class="produtos-adicionados">
        <tr style="font-weight:bold;background:#484848;color:#FFF;">
            <td colspan="8"><p class="txt-produto"><p align="center"><b>Vendas Feitas</b></p></td>
        </tr>
        <tr>
            <td width="100" align="center"><p class="txt-produto"><b>Protocolo</b></p></td>
            <td width="450" align="center"><p class="txt-produto"><b>Cliente</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Data</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Subtotal</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Frete</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Total</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Status</b></p></td>
            <td width="150" align="center"><p class="txt-produto"><b>Ver produtos</b></p></td>
        </tr>
        <?php

        $slq = "SELECT * FROM venda $where";
        $qry = mysqli_query($conexao, $slq);
        while($vendas = mysqli_fetch_assoc($qry)){
            $data = date('d/m/Y', strtotime($vendas['data_Venda']));
            $total = $vendas['valortotal_Venda'];
            $frete = $vendas['entrega_Venda'];
            $subtotal = $total-$frete;
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
                <td align='center'><a href="produtos.php?id_venda=<?php echo $vendas['id_venda']?>&id_cliente=<?php echo $vendas['cod_Cliente']?>" target="_blank"><button type='button' class='btn btn-info' style='color:white; font-weight: bolder; margin: 4px'>Produtos</button></a></td>

            </tr>
        <?php } ?>
    </table>
</section>
</body>
</html>