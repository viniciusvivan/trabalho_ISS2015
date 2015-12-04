/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import DAO.Rel_PedDataDAO;
import DAO.Rel_ReajusteFreteDAO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joao
 */
public class Rel_ReajusteFrete {
    
    int id_Reajuste;
    String percentual;
    String data;;

    public int getId_Reajuste() {
        return id_Reajuste;
    }

    public void setId_Reajuste(int id_Reajuste) {
        this.id_Reajuste = id_Reajuste;
    }

    public String getPercentual() {
        return percentual;
    }

    public void setPercentual(String percentual) {
        this.percentual = percentual;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    

    public ArrayList<Rel_ReajusteFrete> RecuperaObjetos(Date dataini, Date datafim) {
       return Rel_ReajusteFreteDAO.PesquisaObjeto(dataini, datafim); 
    }
}
