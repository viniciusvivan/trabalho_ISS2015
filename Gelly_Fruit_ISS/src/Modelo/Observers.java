package Modelo;

import DAO.ObserverDAO;
import java.util.ArrayList;

/**
 *
 * @author Gustavo H. G. Matsushita
 *
 */

public class Observers {
    int id_Obs;   
    String id_Venda;
    String id_Produto;
    String qnt_Produto;

    public int getId_Obs() {
        return id_Obs;
    }

    public void setId_Obs(int id_Obs) {
        this.id_Obs = id_Obs;
    }

    public String getId_Venda() {
        return id_Venda;
    }

    public void setId_Venda(String id_Venda) {
        this.id_Venda = id_Venda;
    }

    public String getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(String id_Produto) {
        this.id_Produto = id_Produto;
    }

    public String getQnt_Produto() {
        return qnt_Produto;
    }

    public void setQnt_Produto(String qnt_Produto) {
        this.qnt_Produto = qnt_Produto;
    }
    
    public void Excluir() {
        ObserverDAO.Excluir(this);
    }
    
    public ArrayList<Observers> RecuperaObjetos(String Campo, String Valor) {
        String nomeCampo;
        nomeCampo = "id_Produto";        
        return ObserverDAO.PesquisaObjeto(nomeCampo,Valor); 
        
    }
    
    public void Buscar(int iCodigo ){
        Observers produtoTemp = ObserverDAO.Busca(iCodigo);
        this.setId_Obs(produtoTemp.getId_Obs());
        this.setId_Venda(produtoTemp.getId_Venda());
        this.setId_Produto(produtoTemp.getId_Produto());
        this.setQnt_Produto(produtoTemp.getQnt_Produto());
     }
}
