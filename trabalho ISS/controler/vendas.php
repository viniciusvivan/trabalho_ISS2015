<?php
session_start();

include("../DAO/conexao.php");

date_default_timezone_set('America/Sao_Paulo');
$data = date('d/m/Y', strtotime(date('d-m-Y')));

$flag_repeticao = true;

$cli_selecionado = false;
if(isset($_POST['id_cliente'])){
    $id_select = $_POST['id_cliente'];
    $cli_selecionado = true;
}elseif(isset($_GET['id_cliente'])){
    $id_select = $_GET['id_cliente'];
    $cli_selecionado = true;
}

if($cli_selecionado){
    $sql_frete = "SELECT frete_cliente FROM cliente WHERE id_cliente = $id_select";
    $qry_frete = mysqli_query($conexao, $sql_frete);
    $cliente_frete = mysqli_fetch_assoc($qry_frete);
    $frete = $cliente_frete['frete_cliente'];
}

if(isset($_GET['flag'])){
    $quantidade = $_GET['quant'];
    $preco_custo = $_GET['custo'];
    $i = $_GET['i'];

    $_SESSION['lista_produtos'][$i] = "-1";
    $_SESSION['quantidade_produtos'][$i] = "-1";

    $preco_total = $preco_custo * $quantidade;

    if($_SESSION['total_custo'] >= $preco_total){
        $_SESSION['total_custo'] -= $preco_total;
    }

}else {
    if(isset($_POST['produto'])){
        $id_post = $_POST['produto'];
        if ($_POST['txt_quantidade'] != null and $_POST['txt_quantidade'] > 0) {
            for($i=-1; $i <= count($_SESSION['lista_produtos']) - 2; $i++){
                if($id_post == $_SESSION['lista_produtos'][$i]){
                    print "<script type = 'text/javascript'> alert('Este produto já foi inserido!')</script>";
                    $flag_repeticao = false;
                    break;
                }
                //echo $_SESSION['lista_produtos'][$i];
                //echo "i= ".$i." ------- tam=".count($_SESSION['lista_produtos'])."</br>";
            }
            if($flag_repeticao){
                $quantidade = $_POST['txt_quantidade'];
                $sql_quant_produto = "SELECT qnt_produto FROM produto WHERE cod_Produto = $id_post";
                $qry_quant_produto = mysqli_query($conexao, $sql_quant_produto);
                $p_estoque = mysqli_fetch_assoc($qry_quant_produto);
                $estoque = $p_estoque['qnt_produto'];
                $_SESSION['lista_produtos'][$_SESSION['indice']] = $id_post;
                $_SESSION['quantidade_produtos'][$_SESSION['indice']] = $quantidade;
                if($estoque < $quantidade){
                    print "<script type = 'text/javascript'> alert('Atenção: possuímo apenas $estoque unidades deste produto em estoque. Caso não queira esperar, escolha uma quantidade menor ou remova este produto deste pedido')</script>";
                }
                $sql_preco_custo = "SELECT preco_Produto FROM produto WHERE cod_Produto = $id_post";
                $qry_preco_custo = mysqli_query($conexao, $sql_preco_custo);
                $preco_custo_post = mysqli_fetch_assoc($qry_preco_custo);
                $_SESSION['total_custo'] += $preco_custo_post['preco_Produto'] * $quantidade;
                $_SESSION['indice']++;
            }
        } elseif ($_POST['txt_quantidade'] == null) {
            print "<script type = 'text/javascript'> alert('Digite a quantidade!')</script>";
        } elseif ($_POST['txt_quantidade'] <= 0) {
            print "<script type = 'text/javascript'> alert('Quantidade invalida!')</script>";
        }
    }else{
        $_SESSION['indice'] = -1;
        $_SESSION['lista_produtos'] = array();
        $_SESSION['quantidade_produtos'] = array();
        $_SESSION['total_custo'] = 0;
    }
}
?>

<!DOCTYPE html>
<html>
<head lang="pt-br">
    <meta charset="UTF-8">
    <title>Vendas</title>
    <link href="../bootstrap-3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="../bootstrap-3.3.4/css/bootstrap-select.css">
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
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
<section class="corpo">
    <h1 class="texto_grande" style="display: inline-block; margin-left: 25px">Lançamento de venda</h1>
    <a href="listar_vendas.php" style="display: inline; margin-top: 10px; position: absolute; margin-left: 450px"><button type="button" class="btn btn-default navbar-btn" style="color:#333333;">Pesquisar venda</button></a>
    <hr>
    <div class="box_form">
        <div id="tam_cadastro_clientes">
            <form role="form" method="post" action="vendas.php">
                <div class="box_externo">
                    <h3>Dados da venda</h3>
                    <div class="dados_cliente_dois">
                        <label>Data:</label>
                        <input type="text" class="form-control-peq" id="data_venda" value="<?php echo $data?>" disabled>
                    </div>
                    <div class="dados_cliente_dois">
                        <label>Cliente:</label>
                        <select class="form-control" id="id_cliente" name="id_cliente" required>
                            <option id="cliente" value="">Selecione o cliente</option>
                            <?php
                            $sql_cliente = "SELECT * FROM cliente ORDER BY nome_cliente";
                            $qry_cliente = mysqli_query($conexao, $sql_cliente);
                            while($linha = mysqli_fetch_assoc($qry_cliente)){
                                $id_cliente = $linha['id_cliente'];
                                $nome_cliente = $linha['nome_cliente'];
                                ?>
                                <option id="cliente" value="<?php echo $id_cliente;?>" <?php if($cli_selecionado){if($id_cliente == $id_select) echo "selected";}?>><?php echo $nome_cliente ?></option>
                            <?php } ?>
                        </select>
                    </div>
                </div>
                <hr>

                <div id="box_externo">
                    <div class="dados_cliente_dois">
                        <label>Selecione os Produtos</label>
                                <select class="form-control" id="produto" name="produto" required>
                                    <option id="produto" value="">Selecione um produto</option>
                                    <?php
                                    $sql_produtos = "SELECT * FROM produto ORDER BY desc_produto";
                                    $qry_produtos = mysqli_query($conexao, $sql_produtos);
                                    while($linha = mysqli_fetch_assoc($qry_produtos)){
                                        $id_produto = $linha['cod_Produto'];
                                        $nome_produto = $linha['desc_Produto'];
                                        $preco_custo = $linha['preco_Produto'];
                                        ?>
                                        <option id="produto" value="<?php echo $id_produto ?>"><?php echo $nome_produto ?></option>
                                    <?php } ?>
                                </select>
                    </div>

                    <div class="dados_cliente_dois">
                        <label>Quantidade*</label>
                        <input type="number" id="txt_quantidade" name="txt_quantidade" class="form-control" placeholder="Digite a quantidade" required>
                    </div>
                    <div id="box_peq">
                        <h3 align="left" style="display: inline">Subtotal: R$ <?php echo number_format($_SESSION['total_custo'], 2, ',', '.');?></h3>
                        <?php
                            if($cli_selecionado){?>
                                <h3 align="right" style="display: inline; margin-left: 40px">Frete: R$ <?php echo number_format($frete, 2, ',', '.');?></h3>
                                <h3 align="left">Total: R$ <?php echo number_format($_SESSION['total_custo']+$frete, 2, ',', '.');?></h3>
                        <?php } ?>
                    </div>
                    <input class="btn btn-success" type='submit' name='acao' id='acao' value='Adicionar produto' style='color:white; font-weight: bolder;position: absolute; margin: -45px 0 0 422px'/>
                </div>
                <hr>
            </form>


            <table border='1' bordercolor='#484848' class="produtos-adicionados">
                <tr style="font-weight:bold;background:#484848;color:#FFF;">
                    <td colspan="3"><p class="txt-produto"><p align="center"><b>Produtos adicionados</b></p></td>
                </tr>
                <tr>
                    <td width="100" align="center"><p class="txt-produto"><b>Quantidade</b></p></td>
                    <td width="450" align="center"><p class="txt-produto"><b>Produto</b></p></td>
                    <td width="150" align="center"><p class="txt-produto"><b>Excluir</b></p></td>
                </tr>
                <?php
                for($i = -1; $i<$_SESSION['indice']; $i++){
                    if($_SESSION['lista_produtos'][$i] != "-1"){
                        $id_aux = $_SESSION['lista_produtos'][$i];
                        $slq_tabela_nome = "SELECT * FROM produto WHERE cod_Produto = $id_aux";
                        $qry_tabela_nome = mysqli_query($conexao, $slq_tabela_nome);
                        $produto_nome = mysqli_fetch_assoc($qry_tabela_nome);
                        $preco_custo_remove = $produto_nome['preco_Produto'];
                        $volume = $_SESSION['quantidade_produtos'][$i];
                        echo "
                    <tr>
                        <td align='center'><p class='txt-produto'>$volume</p></td>
                        <td align='center'><p class='txt-produto'>$produto_nome[desc_Produto]</p></td>
                        <td align='center'><p class='txt-produto'><a href='vendas.php?flag=true&custo=$preco_custo_remove&quant=$volume&i=$i&id_cliente=$id_select'><button type='button' class='btn btn-danger navbar-btn' style='color:white; font-weight: bolder'>Excluir</button></a></p></td>
                    </tr>
                ";
                    }
                }
                ?>
            </table>


            <?php if($cli_selecionado and $_SESSION['total_custo'] > $frete){?>
                <a href="../DAO/DAOvendas.php?id_cli=<?php echo $id_select?>&frete=<?php echo $frete?>&subt=<?php echo $_SESSION['total_custo']?>&acao=gravar&pagar=s"><button type="button" class="btn btn-default navbar-btn" style="color:#333333;float:right;margin-right:0px;">Concluir e pagar</button></a>
                <a href="../DAO/DAOvendas.php?id_cli=<?php echo $id_select?>&frete=<?php echo $frete?>&subt=<?php echo $_SESSION['total_custo']?>&acao=gravar&pagar=n"><button type="button" class="btn btn-default navbar-btn" style="color:#333333;float:right;margin-right:3px;">Concluir venda</button></a>
            <?php }else{?>
                <a href="#"><button type="button" class="btn btn-default navbar-btn" style="color:#333333;float:right;margin-right:0px;" disabled>Concluir e pagar</button></a>
                <a href="#"><button type="button" class="btn btn-default navbar-btn" style="color:#333333;float:right;margin-right:3px;" disabled>Concluir venda</button></a>
            <?php } ?>
        </div>
    </div>
</section>
</body>
</html>