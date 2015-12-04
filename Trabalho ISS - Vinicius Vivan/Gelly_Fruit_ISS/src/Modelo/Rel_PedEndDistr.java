/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import DAO.Rel_PedEndDistrDAO;
import java.util.ArrayList;

/**
 *
 * @author Joao
 */
public class Rel_PedEndDistr {
    
    int id_Cliente,id_venda;   
    String nome;    
    String cidade;
    double valorTotal;

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    
    
    public ArrayList<Rel_PedEndDistr> RecuperaObjetos(String valor) {
        int codigo;
        if (valor.equals("0")){
            codigo = 1;
        }
        else{
            codigo = 2;
        }    
       return Rel_PedEndDistrDAO.PesquisaObjeto(codigo); 
    }
    
}
