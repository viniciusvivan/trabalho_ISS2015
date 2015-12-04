package Modelo;

import DAO.LancamentoDAO;
import java.util.ArrayList;
//import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Gustavo H. G. Matsushita
 *
 */

public class Lancamentos {

    public static void ireport() {//throws JRException {
        //DAO.LancamentoDAO.ireport();
    }
    
    int id_Lancamento;
    int tipo;
    String produto;
    String qnt;
    String obs;
    String data;

    public int getId_Lancamento() {
        return id_Lancamento;
    }

    public void setId_Lancamento(int id_Lancamento) {
        this.id_Lancamento = id_Lancamento;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getQnt() {
        return qnt;
    }

    public void setQnt(String qnt) {
        this.qnt = qnt;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public void Salvar(){            
        LancamentoDAO.salvar(this);
    }
    
    public void Buscar(int iCodigo ){
        Lancamentos lancamentoTemp = LancamentoDAO.Busca(iCodigo);
        this.setId_Lancamento(lancamentoTemp.getId_Lancamento());
        this.setTipo(lancamentoTemp.getTipo());
        this.setProduto(lancamentoTemp.getProduto());
        this.setQnt(lancamentoTemp.getQnt());
        this.setObs(lancamentoTemp.getObs());
        this.setData(lancamentoTemp.getData());
    }

    public void Alterar() {
        LancamentoDAO.Alterar(this);
    }


    public void Excluir() {
        LancamentoDAO.Excluir(this);
    }
    
    public ArrayList<Lancamentos> RecuperaObjetos(String Campo, String Valor) {
        String nomeCampo;
        nomeCampo = "tipoL";
        
        if (Campo.equals("0")){
            Valor = "0";
        }
        else if (Campo.equals("1")){
            Valor = "2";
        } else if (Campo.equals("2")){
            Valor = "1";
        } else {
            Valor = "";
                 
        }
              
        return LancamentoDAO.PesquisaObjeto(nomeCampo,Valor);
    }
    
    public ArrayList<Lancamentos> RecuperaObjetos2(String Campo, String Valor) {
        String nomeCampo;
        nomeCampo = "dataL";
          
              
        return LancamentoDAO.PesquisaObjeto(nomeCampo,Valor);
    }
}
