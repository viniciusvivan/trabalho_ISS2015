package DAO;


import Banco.Conexao;
import Modelo.Observers;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Gustavo H. G. Matsushita
 *
 */

public class ObserverDAO {
    
    public static Observers Excluir(Observers observer) {
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("delete from obs where id_Venda = ?");
            pst.setString(1, observer.getId_Venda());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Observers.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return null;
    }

    public static ArrayList<Observers> PesquisaObjeto(String nomeCampo, String Valor) {
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<Observers> obs = new ArrayList<Observers>();
        
        conecta.executaSQL("SELECT id_Venda, id_Produto, qnt_Produto FROM obs WHERE " + nomeCampo + " LIKE '" + Valor + "%'");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Observers observer = new Observers();
               
                observer.setId_Venda(conecta.rs.getString("id_Venda"));
                observer.setId_Produto(conecta.rs.getString("id_Produto"));
                observer.setQnt_Produto(conecta.rs.getString("qnt_Produto"));
                                
                obs.add(observer);
                observer = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(ObserverDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return obs;

    }

    public static Observers Busca(Integer c){
        Conexao conecta = new Conexao();
        conecta.conexao();  
        Observers observer = new Observers();
        conecta.executaSQL("select id_Obs, id_Venda, id_Produto, qnt_Produto from obs where id_Venda =" + c);
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                observer.setId_Obs(Integer.parseInt(conecta.rs.getString("id_Obs")));
                observer.setId_Venda(conecta.rs.getString("id_Venda"));
                observer.setId_Produto(conecta.rs.getString("id_Produto"));
                observer.setQnt_Produto(conecta.rs.getString("qnt_Produto"));
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(ObserverDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return observer;
    }
    
}
