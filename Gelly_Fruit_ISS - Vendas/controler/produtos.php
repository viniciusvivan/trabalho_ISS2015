<?php
include("../DAO/conexao.php");
$id_venda = $_GET['id_venda'];
$id_cliente = $_GET['id_cliente'];

$slq_cliente = "SELECT nome_cliente FROM cliente WHERE id_cliente = $id_cliente";
$qry_cliente = mysqli_query($conexao, $slq_cliente);
$cliente = mysqli_fetch_assoc($qry_cliente);
$nome_cli = $cliente['nome_cliente'];?>

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
<section class="corpo">
    <h1 class="texto_grande" style="display: inline-block; margin-left: 25px">Produtos da venda <b>#<?php echo $id_venda?></b> cliente <b><?php echo $nome_cli?></b></h1>
    <hr>
    <table border='1' bordercolor='#484848' class="produtos-adicionados">
        <tr style="font-weight:bold;background:#484848;color:#FFF;">
            <td colspan="4"><p class="txt-produto"><p align="center"><b>Lista de produtos</b></p></td>
        </tr>
        <tr>
            <td width="700" align="center"><p class="txt-produto"><b>Nome</b></p></td>
            <td width="100" align="center"><p class="txt-produto"><b>quantidade</b></p></td>
            <td width="200" align="center"><p class="txt-produto"><b>Valor</b></p></td>
            <td width="200" align="center"><p class="txt-produto"><b>Subtotal</b></p></td>
        </tr>
        <?php
        $slq = "SELECT * FROM produtos_venda WHERE id_venda = $id_venda";
        $qry = mysqli_query($conexao, $slq);
        while($vendas = mysqli_fetch_assoc($qry)){
            $id_produto = $vendas['id_produto'];
            $quantidade = $vendas['quantidade'];

            $slq_produto = "SELECT * FROM produto WHERE cod_Produto = $id_produto";
            $qry_produto = mysqli_query($conexao, $slq_produto);
            $produto = mysqli_fetch_assoc($qry_produto);
            $nome = $produto['desc_Produto'];
            $valor = $produto['preco_Produto'];
            $subtotal = $valor*$quantidade;
            ?>
            <tr>
                <td align='center'><p class='txt-produto'><?php echo $nome ?></p></td>
                <td align='center'><p class='txt-produto'><?php echo $quantidade?></p></td>
                <td align='center'><p class='txt-produto'><?php echo 'R$ '.number_format($valor, 2, ',', '.')?></p></td>
                <td align='center'><p class='txt-produto'><?php echo 'R$ '.number_format($subtotal, 2, ',', '.')?></p></td>
            </tr>
        <?php } ?>
    </table>
</section>
</body>
</html>