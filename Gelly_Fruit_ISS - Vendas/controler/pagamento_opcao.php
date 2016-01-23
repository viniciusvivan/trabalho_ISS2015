<?php
    $id_venda = $_GET['id_venda'];
    $nome = $_GET['cliente'];
    $total = $_GET['total'];
    $frete = $_GET['frete'];
?>

<!DOCTYPE html>
<html>
<head lang="pt-br">
    <meta charset="UTF-8">
    <title>Vendas Feitas</title>
    <link href="../bootstrap-3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="../bootstrap-3.3.4/css/bootstrap-select.css">
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">

    <style>
        h1{
            font-size: 30px;
            color: white;
            margin: 100px 0 0 745px;
        }
        #botoes{
            margin: 100px 0 0 710px;
        }

        a{
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 40px;
            background-color: #e6e6e6;
            margin: 10px;
            font-size: 15pt;
            color: black;
        }

        a:hover{
            background-color: #eeeeee;
            text-decoration: none;
            color: black;
        }
    </style>

</head>
<body>
<header>
    <span class="texto_pequeno" style="margin: 10px 0 0 790px; position: absolute">Sistema de distribuição de geladinhos</span>
</header>
<section>
    <h1>Escolha a forma de pagamento:</h1>
    <div id="botoes">
        <a href="../gerarpdf/index.php?id_venda=<?php echo $id_venda?>&nome=<?php echo $nome?>&total=<?php echo $total?>&frete=<?php echo $frete?>" target="_blank">Boleto à vista</a>
        <a href="pagamento_cartao.php?id_venda=<?php echo $id_venda?>&nome=<?php echo $nome?>&total=<?php echo $total?>&frete=<?php echo $frete?>"">Cartão de crédito</a>
    </div>
    <a href="listar_vendas.php" style="margin: 50px 0 0 705px; padding: 0; background-color: transparent; border: none; position: absolute"><input style='position: relative; margin: 38px 0 0 200px' type="button" class="btn btn-default" value="Voltar"></a>
</section>
</body>
</html>