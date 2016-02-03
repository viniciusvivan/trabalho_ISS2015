<?php
date_default_timezone_set('America/Sao_Paulo');
$data = date('d/m/Y', strtotime(date('d-m-Y')));
$nome = $_GET['nome'];
$total = $_GET['total'];
$frete = $_GET['frete'];
$id_venda = $_GET['id_venda'];

?>

<!DOCTYPE html>
<html>
<head lang="pt-br">
    <meta charset="UTF-8">
    <title>Cartão</title>
    <link href="../bootstrap-3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="../bootstrap-3.3.4/css/bootstrap-select.css">
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
</head>
<body>
<header>
    <span class="texto_pequeno" style="margin: 10px 0 0 790px; position: absolute">Sistema de distribuição de geladinhos</span>

    <script type="text/javascript">
        /* Máscaras ER */
        function mascara(o,f){
            v_obj=o
            v_fun=f
            setTimeout("execmascara()",1)
        }
        function execmascara(){
            v_obj.value=v_fun(v_obj.value)
        }
        function mcc(v){
            v=v.replace(/\D/g,"");
            v=v.replace(/^(\d{4})(\d)/g,"$1 $2");
            v=v.replace(/^(\d{4})\s(\d{4})(\d)/g,"$1 $2 $3");
            v=v.replace(/^(\d{4})\s(\d{4})\s(\d{4})(\d)/g,"$1 $2 $3 $4");
            return v;
        }
        function id( el ){
            return document.getElementById( el );
        }
        window.onload = function(){
            id('cc').onkeypress = function(){
                mascara( this, mcc );
            }
        }
    </script>


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
    <h1 class="texto_grande" style="display: inline-block; margin-left: 25px">Pagamento com cartão de crédito</h1>
    <hr>

    <form role="form" method="get" action="../DAO/DAOpagamento.php">
        <h3 style="margin-left: 10px">Dados do pagamento</h3>

        <div class="dados_cliente_dois">
            <label>Data</label>
            <input class="form-control" id="data_inicial" name="data_inicial" type="text" value="<?php echo $data?>" disabled>
        </div>

        <div class="dados_cliente_dois">
            <label>Nome (dono do cartão)</label>
            <input class="form-control" id="nome" name="nome" type="text" required>
        </div>

        <div class="dados_cliente_dois">
            <label>Numero do cartão</label>
            <input class="form-control" id="cc" name="cc" type="tel" maxlength="19" required/>
        </div>

        <div class="dados_cliente_dois">
            <label>Código de segurança</label>
            <input class="form-control" id="seguranca" name="seguranca" type="text" maxlength="3" required>
        </div>

        <div class="dados_cliente_dois">
            <label>Válidade</label>
            <input class="form-control" id="validade" name="validade" type="date" required>
        </div>

        <div class="dados_cliente_dois">
            <label>Valor (R$)</label>
            <input class="form-control" id="valor" name="valor" type="text" value="<?php echo number_format($total, 2, ',', '.')?>" disabled>
        </div>

        <div class="dados_cliente_dois">
            <label>Formas de pagamento</label>
            <select class="form-control" id="forma_pag" name="forma_pag">
                <option id="parcela" value="1">1x <?php echo number_format($total, 2, ',', '.')?></option>
                <option id="parcela" value="2">2x <?php echo number_format($total/2, 2, ',', '.')?></option>
                <option id="parcela" value="3">3x <?php echo number_format($total/3, 2, ',', '.')?></option>
                <option id="parcela" value="4">4x <?php echo number_format($total/4, 2, ',', '.')?></option>
                <option id="parcela" value="5">5x <?php echo number_format($total/5, 2, ',', '.')?></option>
            </select>
        </div>

        <input type="hidden" id="id_venda" name="id_venda" value="<?php echo $id_venda?>">
        <input type="hidden" id="acao" name="acao" value="cartao">

        <a href="pagamento_opcao.php?id_venda=<?php echo $id_venda?>&cliente=<?php echo $nome?>&total=<?php echo $total?>&frete=<?php echo $frete?>"><input style='position: relative; margin: 38px 0 0 200px' type="button" class="btn btn-default" value="Cancelar"></a>
        <input class="btn btn-success" type='submit' name='submit' id='submit' value='Concluir Pagamento' style='color:white;font-weight: bolder;position: relative; margin: -70px 0 0 600px'/>
        <hr>
    </form>
    <img style="width: 400px" src="../imagens/bandeiras.png">
</section>
</body>
</html>