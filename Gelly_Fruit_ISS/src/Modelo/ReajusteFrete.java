/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import DAO.ReajusteFreteDAO;
import java.util.ArrayList;

/**
 *
 * @author Larissa-PC
 */
public class ReajusteFrete {
    
        
    int id_Reajuste;
    String percentual;
    String data;
    
    
    public String getPercentual() {
        return percentual;
    }

    public void setPercentual(String percentual) {
        this.percentual = percentual;
    }


    public int getId_Reajuste() {
        return id_Reajuste;
    }

    public void setId_Reajuste(int id_Reajuste) {
        this.id_Reajuste = id_Reajuste;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void Novo() {
        ReajusteFreteDAO.novo(this);
    }

    public ArrayList<ReajusteFrete> RecuperaObjetos() {
            return ReajusteFreteDAO.PesquisaObjeto();
    }

    public void Reajuste(Double valor) {
        ReajusteFreteDAO.Atualiza(valor);
    }

    

    
}
