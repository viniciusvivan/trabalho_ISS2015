<?php
include('../DAO/conexao.php');
date_default_timezone_set('America/Sao_Paulo');
$data = date('d/m/Y', strtotime(date('d-m-Y')));
$nome = $_GET['cliente'];
$total = $_GET['total'];
$frete = $_GET['frete'];
$id_venda = $_GET['id_venda'];
$data_hora = date('d/m/Y H:i', strtotime(date('d-m-Y H:i:s')));

$sql_venda = "SELECT * FROM venda WHERE id_venda = $id_venda";
$qry_venda = mysqli_query($conexao, $sql_venda);
$forma = mysqli_fetch_assoc($qry_venda);
$pagamento = $forma['pagamento_Venda'];

if($pagamento == "0") {
 $forma_pagamento = "Aguardando";
}else if($pagamento != "Boleto") {
 $forma_pagamento = $pagamento . "x no cartão";
}else{
 $forma_pagamento = "Boleto à vista";
}


ob_start(); //inicia o buffer
?>
 <html lang="pt-br">
 <head>
  <meta charset="UTF-8">
  <title>Nota Fiscal</title>
  <style>
   td{
    border: 1px solid black;
    padding: 4px 0;
    margin: 0;
   }
   tr{
    margin: 0;
   }
   table{
    margin: 0;
   }
  </style>
 </head>
 <body>
 <section>
  <h1 style="text-align: center; font-size: 30px">Sistema de distribuição de geladihos</h1>
  <h2 style="text-align: center; font-size: 25px">Nota Fiscal</h2>
  <hr>
  <h3>Código da nota fical: <b><?php echo $id_venda ?></b></h3>
  <h3>Cliente: <b><?php echo $nome ?></b></h3>
  <h4>Data de emissão: <b><?php echo $data_hora ?></b></h4>
  <table style="margin: auto">
   <tr><td colspan="5" style="font-size: 14pt; text-align: center; background-color: #2d2d2d; color: white"><b>Lista de produtos<b></td></tr>
   <tr>
    <td style="font-size: 13pt; text-align: center; background-color: #d5d5d5" colspan='2'><b>Produto</b></td>
    <td style="font-size: 13pt; text-align: center; background-color: #d5d5d5" colspan='1'><b>Quantidade</b></td>
    <td style="font-size: 13pt; text-align: center; background-color: #d5d5d5" colspan='1'><b>Valor Uni.</b></td>
    <td style="font-size: 13pt; text-align: center; background-color: #d5d5d5" colspan='1'><b>Total Prod.</b></td>
   </tr>
   <?php
   $sql= "SELECT * FROM produtos_venda WHERE id_venda = $id_venda";
   $qry = mysqli_query($conexao, $sql);
   while($linha = mysqli_fetch_assoc($qry)){
    $codigo_produto = $linha['id_produto'];
    $quantidade = $linha['quantidade'];
    $sql_produto = "SELECT * FROM produto WHERE cod_Produto = $codigo_produto";
    $qry_produto = mysqli_query($conexao, $sql_produto);
    $nome_produto = mysqli_fetch_assoc($qry_produto);
    $preco = number_format($nome_produto['preco_Produto'], 2, ',', '.');
    $total_local = $preco*$quantidade;
    $total_local = number_format($total_local, 2, ',', '.');
    echo"
                    <tr>
                        <td width='500px' style='font-size: 13pt; text-align: center' colspan='2'>$nome_produto[desc_Produto]</td>
                        <td width='50px'  style='font-size: 13pt; text-align: center' colspan='1'>$quantidade</td>
                        <td width='150px' style='font-size: 13pt; text-align: center' colspan='1'>R$ $preco</td>
                        <td width='150px' style='font-size: 13pt; text-align: center' colspan='1'>R$ $total_local</td>
                    </tr>";
   } ?>
   <tr>
    <td width="150px" align="center" colspan="1" style="font-size: 13pt; background-color: #D5D5D5"><b>Forma de pagamento: <?php echo $forma_pagamento ?></td>
    <td width="150px" align="center" colspan="1" style="font-size: 13pt; background-color: #D5D5D5"><b>Subtotal: <?php echo 'R$ '.number_format($total-$frete, 2, ',', '.')?></b></td>
    <td width="150px" align="center" colspan="1" style="font-size: 13pt; background-color: #D5D5D5"><b>Frete: <?php echo 'R$ '.number_format($frete, 2, ',', '.') ?></td></b>
    <td width="150px" align="center" colspan="2" style="font-size: 13pt; background-color: #D5D5D5"><b>Total: <?php echo 'R$ '.number_format($total, 2, ',', '.') ?></td></b>
   </tr>
  </table>
 </section>
 </body>
 </html>
<?php
$saida = ob_get_clean();;

include('mpdf60/mpdf.php');
$arquivo = "Boleto - ".$nome.".pdf";

$mpdf = new mPDF();
$mpdf->WriteHTML($saida);
/*
 * F - salva o arquivo NO SERVIDOR
 * I - abre no navegador E NÃO SALVA
 * D - chama o prompt E SALVA NO CLIENTE
 */

$mpdf->Output($arquivo, 'I');
?>