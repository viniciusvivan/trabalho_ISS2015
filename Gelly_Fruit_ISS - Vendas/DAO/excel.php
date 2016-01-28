<?php

include("conexao.php");
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
/*if($produto != ""){
    $produto = $_GET["id_produto"];
    if($flag == "y") $where = $where." AND  = $produto";
    else $where = $where." TABELA = $produto";
    $flag = "y";
}*/
if($status != ""){
    $status = $_GET["status"];
    if($flag == "y") $where = $where." AND status_Venda = $status";
    else $where = $where." status = $status";
    $flag = "y";
}
if($where == "WHERE") $where = "";
//***************************FIM Formula��o da clausula WHERE******************************

$sql = "SELECT * FROM venda $where";
$qry = mysqli_query($conexao, $sql);

//********************************************************************************************
date_default_timezone_set('America/Sao_Paulo');
$data_atual = date('d-m-Y');
$arquivo = "planilha de $data_atual.xls";

// tabela HTML com o formato da planilha
$html = '';
$html .= '<table>';
$html .= '<tr style="background-color: dimgrey">';
$html .= '<td><b>Protocolo</b></td>';
$html .= '<td><b>Cliente</b></td>';
$html .= '<td><b>Data</b></td>';
$html .= '<td><b>Subtotal (R$)</b></td>';
$html .= '<td><b>Frete (R$)</b></td>';
$html .= '<td><b>Total (R$)</b></td>';
$html .= '<td><b>Status</b></td>';
$html .= '</tr>';

while($linha = mysqli_fetch_assoc($qry)){
    $valortotal = $linha['valortotal_Venda'];
    $frete = $linha['entrega_Venda'];
    $subtotal = $valortotal-$frete;

    $slq_cliente = "SELECT nome_cliente FROM cliente WHERE id_cliente = $linha[cod_Cliente]";
    $qry_cliente = mysqli_query($conexao, $slq_cliente);
    $cliente = mysqli_fetch_assoc($qry_cliente);
    $nome = $cliente['nome_cliente'];

    if($linha['status_Venda'] == 1){
        $situacao = "Aguardando pagamento";
    }elseif($linha['status_Venda'] == 2){
        $situacao = "Aguando entrega";
    }else{
        $situacao = "Concluido";
    }

    $html .= "<tr>";
    $html .= "<td>$linha[id_venda]</td>";
    $html .= "<td>$nome</td>";
    $html .= "<td>$linha[data_Venda]</td>";
    $html .= "<td>$subtotal</td>";
    $html .= "<td>$frete</td>";
    $html .= "<td>$valortotal</td>";
    $html .= "<td>$situacao</td>";
    $html .= "</tr>";
}

// Configuracoes header para formatar o download
header ("Expires: Mon, 26 Jul 1997 05:00:00 GMT");
header ("Last-Modified: " . gmdate("D,d M YH:i:s") . " GMT");
header ("Cache-Control: no-cache, must-revalidate");
header ("Pragma: no-cache");
header ("Content-type: application/x-msexcel");
header ("Content-Disposition: attachment; filename=\"{$arquivo}\"" );
header ("Content-Description: PHP Generated Data" );

// Envia o conteudo do arquivo
echo $html;
exit;
