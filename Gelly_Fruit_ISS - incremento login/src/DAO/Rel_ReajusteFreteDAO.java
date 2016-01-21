/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Banco.Conexao;
import Modelo.Rel_Cliente;
import Modelo.Rel_PedData;
import Modelo.Rel_ReajusteFrete;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
/*import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;*/


/**
 *
 * @author Larissa-PC
 */
public class Rel_ReajusteFreteDAO {

    public static ArrayList<Rel_ReajusteFrete> PesquisaObjeto(Date dataini, Date datafim) {
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<Rel_ReajusteFrete> ent = new ArrayList<Rel_ReajusteFrete>();        

        String Sql = "SELECT PERCENTUAL_REAJUSTEFRETE, DATA_REAJUSTEFRETE FROM reajuste_frete " ;
                       
                if (dataini != null){
                    Sql = Sql + " where DATA_REAJUSTEFRETE >= '" + dataini + "'" +
                                " and DATA_REAJUSTEFRETE <= '" + datafim + "'";        
                }              
        
        conecta.executaSQL(Sql);        
       try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Rel_ReajusteFrete reajuste = new Rel_ReajusteFrete();
               
                reajuste.setData(conecta.rs.getString("DATA_REAJUSTEFRETE"));
                reajuste.setPercentual(conecta.rs.getString("PERCENTUAL_REAJUSTEFRETE"));               
                               
                ent.add(reajuste);
                reajuste = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return ent;
  
    }
 
    /*public static void ireport() {
        Conexao conecta = new Conexao();
    conecta.conexao(); 
    try {
        conecta.executaSQL("select * from reajuste_frete");
        HashMap filtro = new HashMap();
        JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
        //JasperPrint jpPrint = JasperFillManager.fillReport("C:/temporaria/produtos.jasper",new HashMap(),relatResul);
        JasperPrint jpPrint = JasperFillManager.fillReport("Rel_AjusteFrete.jasper", filtro,relatResul);
        JasperViewer viewer = new JasperViewer(jpPrint,false);
        viewer.setVisible(true);
        } catch (JRException ex) {
        Logger.getLogger(Rel_ReajusteFrete.class.getName()).log(Level.SEVERE, null, ex);
    }
    conecta.desconecta();
    
    }*/
    
}
