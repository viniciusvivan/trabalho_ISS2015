package DAO;

import Banco.Conexao;
import Modelo.Distribuicoes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DistribuicaoDAO {
    
      public static void novo(Distribuicoes distribuicao){// cria uma objeto para ser usado dentro do metodo       
        //botão NOVO
        Conexao conecta = new Conexao();
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into distribuicao (nome_Distribuicao, status_Distribuicao, STATUS_EXCLUSAO) values(?,?,?) ");
            pst.setString(1, distribuicao.getNome());     
            pst.setInt(2, distribuicao.getStatus());  
            pst.setInt(3, 0); 
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }
        conecta.desconecta();
    }
    
    public static void Alterar(Distribuicoes distribuicao){
        //botão ALTERAR
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update distribuicao set NOME_DISTRIBUICAO=?, STATUS_DISTRIBUICAO=? where ID_DISTRIBUICAO = ?");
            pst.setString(1, distribuicao.getNome());
            pst.setInt(2, distribuicao.getStatus());
            pst.setInt(3, distribuicao.getId_Distribuicao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }      
        conecta.desconecta();
    }
    
    public static Distribuicoes Excluir(Distribuicoes distribuicao) {
        // botão EXCLUIR
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update DISTRIBUICAO set STATUS_EXCLUSAO=? where ID_DISTRIBUICAO = ?");
            pst.setInt(1, 1);
            pst.setInt(2, distribuicao.getId_Distribuicao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }      
        conecta.desconecta();
        return null;                 
    }


    public static ArrayList<Distribuicoes> PesquisaObjeto() {
        //select do carrega tabela
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<Distribuicoes> dis = new ArrayList<Distribuicoes>();
        
        conecta.executaSQL("SELECT ID_DISTRIBUICAO, NOME_DISTRIBUICAO, STATUS_DISTRIBUICAO FROM DISTRIBUICAO WHERE STATUS_EXCLUSAO = 0" + " order by ID_DISTRIBUICAO");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Distribuicoes distribuicao = new Distribuicoes();
               
                distribuicao.setId_Distribuicao(conecta.rs.getInt("ID_DISTRIBUICAO"));
                distribuicao.setNome(conecta.rs.getString("NOME_DISTRIBUICAO"));
                distribuicao.setStatus(conecta.rs.getInt("STATUS_DISTRIBUICAO"));

                
                dis.add(distribuicao);
                distribuicao = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(DistribuicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return dis;        
    }
    
    
    public static ArrayList<Distribuicoes> Busca(int codigo) {
        //BUSCA DO PREENCHE CAMPOS
        Conexao conecta = new Conexao();
        conecta.conexao();  
        
        conecta.executaSQL("select * from distribuicao where ID_DISTRIBUICAO = " + codigo);
        
        ArrayList<Distribuicoes> dis = new ArrayList<Distribuicoes>();
        
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Distribuicoes distribuicao = new Distribuicoes();
                distribuicao.setId_Distribuicao(conecta.rs.getInt("ID_DISTRIBUICAO"));
                distribuicao.setNome(conecta.rs.getString("NOME_DISTRIBUICAO"));
                distribuicao.setStatus(conecta.rs.getInt("STATUS_DISTRIBUICAO"));
                
                dis.add(distribuicao);
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dis;    
    }

   
    
    
    
}