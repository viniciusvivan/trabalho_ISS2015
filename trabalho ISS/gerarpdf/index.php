<?php
include('../DAO/conexao.php');
date_default_timezone_set('America/Sao_Paulo');
$data = date('d/m/Y', strtotime(date('d-m-Y')));
$nome = $_GET['nome'];
$total = $_GET['total'];
$frete = $_GET['frete'];

$id_venda = $_GET['id_venda'];

$sql = "UPDATE venda SET pagamento_Venda = 'Boleto' WHERE id_venda = '$id_venda'";
$qry = mysqli_query($conexao, $sql);

$data_hora = date('d/m/Y H:i', strtotime(date('d-m-Y H:i:s')));

ob_start(); //inicia o buffer
?>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Boleto</title>
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
    <h2 style="text-align: center; font-size: 25px">Boleto à vista</h2>
    <hr>
    <h3>Cliente: <b><?php echo $nome ?></b></h3>
    <h4>Data de emissão: <b><?php echo $data_hora ?></b></h4>
    <table>
        <tr>
            <td width="100px"><b>Logo banco</b></td>
            <td width="50px" style="font-size: 20px"><b>001-9</b></td>
            <td width="500px" colspan="4" style="font-size: 15px; text-align: center"><b>00190.00009 01490.336003 00000.001016 9 4103000000<?php echo number_format($total, 2, '', '')?></b></td>
        </tr>
        <tr>
            <td width="400px" colspan="5">Local do pagamento: <b>Até o vencimento pode ser pago em qualquer banco</b></td>
            <td width="100px">Vencimento: <b>09/02/2016</b></td>
        </tr>
        <tr>
            <td width="100px" colspan="5">Cedente: <b>Sistema de distribuição de geladinhos</b></td>
            <td width="100px">Agência:  <b>077/080158</b></td>
        </tr>
        <tr>
            <td width="50px">Data do documento: <b><?php echo $data ?></b></td>
            <td width="50px">Numero do documento:  <b>789</b></td>
            <td width="100px">Espécie Doc.: <b>RC</b></td>
            <td width="50px">Aceite: <b>N</b></td>
            <td width="50px">Data do processamento: <b><?php echo $data ?></b></td>
            <td width="200px">Nosso numero: <b>062</b></td>
        </tr>
        <tr>
            <td width="100px">Frete: <b><?php echo 'R$ '.number_format($frete, 2, ',', '.') ?></b></td>
            <td width="100px">Subtotal: <b><?php echo 'R$ '.number_format($total-$frete, 2, ',', '.') ?></b></td>
            <td width="50px">Espécie: <b>R$</b></td>
            <td width="100px" colspan="2">Quantidade: </td>
            <td width="200px" style="text-align: center">Valor total do documento:<b><?php echo 'R$ '.number_format($total, 2, ',', '.') ?></b></td>
        </tr>
        <tr>
            <td width="200px" colspan="6" style="height: 200px"><b>Seu pedido será entrege em até 5 dias úteis após o pagamento desde boleto. O pagamento pode demorar até 48 horas para ser efetivado</b></td>
    </table>
    <hr>
    <img style="margin-top: 60px; width: 500px; float: left" src="../imagens/codigo.jpg">
</section>
<footer style="margin-top: 50px">
    <hr>
    <p style="text-align: center; font-size: 15px">Sistema de distribuição de geladinhos</p></br>
    <p style="text-align: center; font-size: 15px">CNPJ: 32.581.578/0001-75</p></br>
</footer>
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