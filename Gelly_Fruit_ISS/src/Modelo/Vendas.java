/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


import DAO.VendaDAO;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */


public class Vendas {
    
    int id_Venda;
    String status_Venda;
    String data_Venda;
    String entrega_Venda ;
    String pagamento_Venda;
    String quantidade_Venda;
    String cod_Cliente;
    String cod_Produto;
    String valorprod_Venda;
    String valortotal_Venda;
    
    
    public int getId_Venda() {
        return id_Venda;
    }

    public void setId_Venda(int id_Venda) {
        this.id_Venda = id_Venda;
    }
    
     public String getstatus_Venda() {
        return status_Venda;
    }

    public void setstatus_Venda(String status_Venda) {
        this.status_Venda = status_Venda;
    }
    
     public String getcod_Cliente() {
        return cod_Cliente;
    }

    public void setcod_Cliente(String cod_Cliente) {
        this.cod_Cliente = cod_Cliente;
    }
    
    public String getcod_Produto() {
        return cod_Produto;
    }

    public void setcod_Produto(String cod_Produto) {
        this.cod_Produto = cod_Produto;
    }
    

    public String getdata_Venda() {
        return data_Venda;
    }

    public void setdata_Venda(String data_Venda) {
        this.data_Venda = data_Venda;
    }
    
    public String getvalorprod_Venda() {
        return valorprod_Venda;
    }

    public void setvalorprod_Venda(String valorprod_Venda) {
        this.valorprod_Venda = valorprod_Venda;
    }
    
    public String getentrega_Venda() {
        return entrega_Venda;
    }

    public void setentrega_Venda(String entrega_Venda) {
        this.entrega_Venda = entrega_Venda;
    }
    
    public String getvalortotal_Venda() {
        return valortotal_Venda;
    }

    public void setvalortotal_Venda(String valortotal_Venda) {
        this.valortotal_Venda = valortotal_Venda;
    }
    
    public String getpagamento_Venda() {
        return pagamento_Venda;
    }

    public void setpagamento_Venda(String pagamento_Venda) {
        this.pagamento_Venda = pagamento_Venda;
    }
    
    public String getquantidade_Venda() {
        return quantidade_Venda;
    }

    public void setquantidade_Venda(String quantidade_Venda) {
        this.quantidade_Venda = quantidade_Venda;
    }


    public static ArrayList<Vendas> Busca(int codigo) {
        return VendaDAO.Busca(codigo);
    }

    public ArrayList<Vendas> RecuperaObjetos(String Campo, String Valor) {
        String nomeCampo;
        if (Campo.equals("0")){
            nomeCampo = "status_Venda";
        }
        else{
            nomeCampo = "data_Venda";
        }
        
        return VendaDAO.PesquisaObjeto(nomeCampo,Valor); 
        
    }
    
    public void Salvar(){            
        VendaDAO.salvar(this);
    }

    public void Update() {
        VendaDAO.Update(this);
    }
    

    
}

   