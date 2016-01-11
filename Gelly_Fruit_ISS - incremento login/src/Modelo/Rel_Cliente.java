/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import DAO.Rel_ClienteDAO;
import java.util.ArrayList;

/**
 *
 * @author Joao
 */
public class Rel_Cliente {
    
    int id_Cliente;   
    String nome;
    String cpf;
    String cidade;
    String telefone;
    int status;
    double frete;

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public ArrayList<Rel_Cliente> RecuperaObjetos(String Campo, String Valor) {
    String nomeCampo;
        if (Campo.equals("0")){
            nomeCampo = "NOME_CLIENTE";
        }
        else if (Campo.equals("1")){
            nomeCampo = "CIDADE_CLIENTE";
        }        
        
        else{
            nomeCampo = "STATUS_CLIENTE";
        }      
        return Rel_ClienteDAO.PesquisaObjeto(nomeCampo,Valor);  
    }
    
}
