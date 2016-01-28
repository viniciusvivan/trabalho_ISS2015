/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import DAO.EstornoPedidoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Larissa-PC
 */
public class EstornoPedido {
    
    int cod_Pedido;
    String data_fechamento, nome_cliente,forma_entrega;
    Double valor_total;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public int getCod_Pedido() {
        return cod_Pedido;
    }

    public void setCod_Pedido(int cod_Pedido) {
        this.cod_Pedido = cod_Pedido;
    }

    public String getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(String data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getForma_entrega() {
        return forma_entrega;
    }

    public void setForma_entrega(String forma_entrega) {
        this.forma_entrega = forma_entrega;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    
    public ArrayList<EstornoPedido> RecuperaObjetos(String Campo, String id) {
        String nomeCampo;
        if (Campo.equals("0")){
            nomeCampo = "id_venda";    
        }
        else{
            nomeCampo = "id_cliente";                  
        }
        
        return EstornoPedidoDAO.PesquisaObjeto(nomeCampo, id);
    }

    public void Concluir(int codigo) {
        EstornoPedidoDAO.Concluir(codigo);
    }

    public void Excluir_PedidoEntregue(int codigo) {
        EstornoPedidoDAO.Excluir_PedidoEntregue(codigo);
    }
    
}
