/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import DAO.Rel_PedDataDAO;
import DAO.Rel_PedEndDistrDAO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Larissa-PC
 */
public class Rel_PedData {
    
    int id_venda;   
    String nomeCliente;    
    String entrega;
    double valorTotal;

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public ArrayList<Rel_PedData> RecuperaObjetos(Date dataini, Date datafim, int codigo) {
       return Rel_PedDataDAO.PesquisaObjeto(dataini, datafim, codigo); 
    }
    
}
