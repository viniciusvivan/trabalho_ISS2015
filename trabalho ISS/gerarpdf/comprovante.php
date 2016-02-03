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

if($pagamento != "Boleto"){
    $forma_pagamento = $pagamento."x no cartão";
}else{
    $forma_pagamento = "Boleto à vista";
}


ob_start(); //inicia o buffer
?>
    <html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Comprovante</title>
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
<pre>

    <p align="center">
    Sistema de distribuição de geladihos
    Comprovante de pagamento

    Código do comprovante: <b><?php echo $id_venda ?></b>

    Cliente: <b><?php echo $nome ?></b>
    Data de emissão: <b><?php echo $data_hora ?></b>


    Subtotal: <b><?php echo "R$".number_format($total-$frete, 2 , ",", ".") ?></b>
    Frete: <b><?php echo "R$".number_format($frete, 2 , ",", ".") ?></b>
    Total do valor pago: <b><?php echo "R$".number_format($total, 2 , ",", ".") ?></b>
    Forma de pagamento: <b><?php echo $forma_pagamento ?></b>
    </p>

</pre>

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