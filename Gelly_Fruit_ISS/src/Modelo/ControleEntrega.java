/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import DAO.ControleEntregaDAO;
import java.util.ArrayList;
/**
 *
 * @author Larissa-PC
 */
public class ControleEntrega {
    
    String nome_cliente,pagto, entrega,desc_produto;
    double valor,quantidade_venda,valorprod_venda,valortotal_venda;   
    int pedido,cod_produto,cod_cliente;

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getDesc_produto() {
        return desc_produto;
    }

    public void setDesc_produto(String desc_produto) {
        this.desc_produto = desc_produto;
    }

    public double getQuantidade_venda() {
        return quantidade_venda;
    }

    public void setQuantidade_venda(double quantidade_venda) {
        this.quantidade_venda = quantidade_venda;
    }

    public double getValorprod_venda() {
        return valorprod_venda;
    }

    public void setValorprod_venda(double valorprod_venda) {
        this.valorprod_venda = valorprod_venda;
    }

    public double getValortotal_venda() {
        return valortotal_venda;
    }

    public void setValortotal_venda(double valortotal_venda) {
        this.valortotal_venda = valortotal_venda;
    }

    
    
            
            
                    
                    

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getPagto() {
        return pagto;
    }

    public void setPagto(String pagto) {
        this.pagto = pagto;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
     public ArrayList<ControleEntrega> RecuperaObjetos() {
        return ControleEntregaDAO.PesquisaObjeto();
    }
     
    public ArrayList<ControleEntrega> RecuperaObjetosProduto(int codigo) {
        return ControleEntregaDAO.PesquisaObjetoProduto(codigo);
    }

    public void Atualiza(int codigo) {
        ControleEntregaDAO.Atualiza(codigo);
    }

    public void Insere_PedidoEntregue(int codigo) {
        ControleEntregaDAO.Insere_PedidoEntregue(codigo);
    }
    
}