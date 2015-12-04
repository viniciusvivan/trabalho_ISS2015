package Modelo;

import DAO.ProdutoDAO;
import java.util.ArrayList;
//import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Gustavo H. G. Matsushita
 *
 */

public class Produtos {

    public static void ireport(){ //throws JRException {
        //DAO.ProdutoDAO.ireport();   
    }

    
    int id_Produto;   
    String nome;
    String uni;
    String qnt;
    String preco;
    int status;
    
    public int getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(int id_Produto) {
        this.id_Produto = id_Produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getQnt() {
        return qnt;
    }

    public void setQnt(String qnt) {
        this.qnt = qnt;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    public void Salvar(){            
        ProdutoDAO.salvar(this);
    }
    
    public void Buscar(int iCodigo ){
        Produtos produtoTemp = ProdutoDAO.Busca(iCodigo);
        this.setId_Produto(produtoTemp.getId_Produto());
        this.setNome(produtoTemp.getNome());
        this.setUni(produtoTemp.getUni());
        this.setQnt(produtoTemp.getQnt());
        this.setPreco(produtoTemp.getPreco());
        this.setStatus(produtoTemp.getStatus());
    }

    public void Alterar() {
        ProdutoDAO.Alterar(this);
    }


    public void Excluir() {
        ProdutoDAO.Excluir(this);
    }
    
    public static void AlterarQnt(String X) {
        //DAO.ProdutoDAO.AlterarQnt(X);
    }
    
    public ArrayList<Produtos> RecuperaObjetos(String Campo, String Valor) {
        String nomeCampo;
        if (Campo.equals("0")){
            nomeCampo = "desc_Produto";
        }
        else if (Campo.equals("1")){
            nomeCampo = "cod_Produto";
        } else if (Campo.equals("2")){
            nomeCampo = "status_Produto";
            Valor = "0";
        } else{
            nomeCampo = "status_Produto";
            Valor = "1";
        }
        //nomeCampo = "desc_Produto";        
        return ProdutoDAO.PesquisaObjeto(nomeCampo,Valor); 
        
    }
    
}
