package DAO;

import Banco.Conexao;
import Modelo.Lancamentos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import net.sf.jasperreports.view.*;
//import net.sf.jasperreports.engine.*;

/**
 *
 * @author Gustavo H. G. Matsushita
 *
 */

public class LancamentoDAO {
    
    public static void salvar(Lancamentos lancamento){// cria uma objeto para ser usado dentro do metodo
        Conexao conecta = new Conexao();
        conecta.conexao();
        
               
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into lancamento (tipoL, prodL, qntL, obsL, dataL) values(?,?,?,?,?) ");
            pst.setInt(1, lancamento.getTipo());
            pst.setString(2, lancamento.getProduto());
            pst.setString(3, lancamento.getQnt());
            pst.setString(4, lancamento.getObs());
            pst.setString(5, lancamento.getData());
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }
        conecta.desconecta();
    }
    
    public static void Alterar(Lancamentos lancamento){
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update lancamento set tipoL=?, prodL=?, qntL=?, obsL=?, data=? where idlancamento = ?");
            pst.setInt(1, lancamento.getTipo());
            pst.setString(2, lancamento.getProduto());
            pst.setString(3, lancamento.getQnt());
            pst.setString(4, lancamento.getObs());
            pst.setString(5, lancamento.getData());
            pst.setInt(6, lancamento.getId_Lancamento());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }      
        conecta.desconecta();
    }

    
    public static Lancamentos Busca(Integer c){
        Conexao conecta = new Conexao();
        conecta.conexao();  
        Lancamentos lancamento = new Lancamentos();
        conecta.executaSQL("select idlancamento, tipoL, prodL, qntL, obsL, dataL from lancamento where idlancamento =" + c);
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                lancamento.setId_Lancamento(Integer.parseInt(conecta.rs.getString("idlancamento")));
                lancamento.setTipo(Integer.parseInt(conecta.rs.getString("tipoL")));
                lancamento.setProduto(conecta.rs.getString("prodL"));
                lancamento.setQnt(conecta.rs.getString("qntL"));
                lancamento.setObs(conecta.rs.getString("obsL"));
                lancamento.setData(conecta.rs.getString("dataL"));
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lancamento;
    }


    public static Lancamentos Excluir(Lancamentos lancamento) {
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("delete from lancamento where idlancamento = ?");
            pst.setInt(1, lancamento.getId_Lancamento());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Lancamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return null;
    }

    public static ArrayList<Lancamentos> PesquisaObjeto(String nomeCampo, String Valor) {
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<Lancamentos> lan = new ArrayList<Lancamentos>();
        
        conecta.executaSQL("SELECT idlancamento, tipoL, prodL, qntL, obsL, dataL FROM LANCAMENTO WHERE " + nomeCampo + " LIKE '" + Valor + "%'");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Lancamentos lancamento = new Lancamentos();
               
                lancamento.setId_Lancamento(conecta.rs.getInt("idlancamento"));
                lancamento.setTipo(conecta.rs.getInt("tipoL"));
                lancamento.setProduto(conecta.rs.getString("prodL"));
                lancamento.setQnt(conecta.rs.getString("qntL"));
                lancamento.setObs(conecta.rs.getString("obsL"));
                lancamento.setData(conecta.rs.getString("dataL"));
                
                lan.add(lancamento);
                lancamento = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return lan;

    }
    
    /*public static void ireport() throws JRException {
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            conecta.executaSQL("select * from lancamento");
            HashMap filtro = new HashMap();
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
            
            JasperPrint jpPrint = JasperFillManager.fillReport("lancamentos.jasper", filtro,relatResul);
            JasperViewer viewer = new JasperViewer(jpPrint,false);
            viewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Lancamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }*/
    
    
}
