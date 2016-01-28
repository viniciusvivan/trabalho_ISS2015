/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Banco.Conexao;
import Modelo.ReajusteFrete;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Larissa-PC
 */
public class ReajusteFreteDAO {

    public static void novo(ReajusteFrete reajuste) {
        //NOVO
        Conexao conecta = new Conexao();
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into reajuste_frete (PERCENTUAL_REAJUSTEFRETE, DATA_REAJUSTEFRETE) values(?,?) ");
            pst.setString(1, reajuste.getPercentual());     
            pst.setString(2, reajuste.getData());  
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }
        conecta.desconecta();
    }

    public static ArrayList<ReajusteFrete> PesquisaObjeto() {
        //select do carrega tabela
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<ReajusteFrete> reajuste = new ArrayList<ReajusteFrete>();
        
        conecta.executaSQL("SELECT PERCENTUAL_REAJUSTEFRETE, DATA_REAJUSTEFRETE FROM reajuste_frete" );
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                ReajusteFrete reajustefrete = new ReajusteFrete();
               
                reajustefrete.setPercentual(conecta.rs.getString("PERCENTUAL_REAJUSTEFRETE"));
                reajustefrete.setData(conecta.rs.getString("DATA_REAJUSTEFRETE"));
                
                reajuste.add(reajustefrete);
                reajustefrete = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReajusteFreteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return reajuste;
    }
    
    public static void Atualiza(double porcentagem) {
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        
        Double ValorAtual;
        int codcli;
        
        
        conecta.executaSQL("select frete_cliente, id_cliente from cliente" );
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                
                ValorAtual = conecta.rs.getDouble("frete_cliente") + ((conecta.rs.getDouble("frete_cliente") * porcentagem) / 100);
                codcli = conecta.rs.getInt("id_cliente");
                        
                PreparedStatement pst = conecta.conn.prepareStatement("update cliente set frete_cliente =" + ValorAtual +
                                                                      "where id_cliente =" + codcli);
                pst.executeUpdate();
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReajusteFreteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        conecta.desconecta();
    }

    public ReajusteFreteDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
