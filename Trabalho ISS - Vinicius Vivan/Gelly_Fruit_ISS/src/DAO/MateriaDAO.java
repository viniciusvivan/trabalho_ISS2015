package DAO;

import Banco.Conexao;
import Modelo.Materias;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MateriaDAO {
    
      public static void salvar(Materias materia){// cria uma objeto para ser usado dentro do metodo
        
         
        Conexao conecta = new Conexao();
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into materia (desc_Materia, uni_Materia, qnt_Materia, preco_Materia) values(?,?,?,?) ");
            pst.setString(1, materia.getNome());
            pst.setString(2, materia.getUni());
            pst.setString(3, materia.getQnt());
            pst.setString(4, materia.getPreco());
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }
        conecta.desconecta();
    }
    
    public static void Alterar(Materias materia){
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update materia set desc_Materia=?, uni_Materia=?, qnt_Materia=?, preco_Materia=? where cod_Materia = ?");
            pst.setString(1, materia.getNome());
            pst.setString(2, materia.getUni());
            pst.setString(3, materia.getQnt());
            pst.setString(4, materia.getPreco());
            pst.setInt(5, materia.getId_Materia());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }      
        conecta.desconecta();
    }

    
    public static Materias Busca(Integer c){
        Conexao conecta = new Conexao();
        conecta.conexao();  
        Materias materia = new Materias();
        conecta.executaSQL("select cod_Materia, desc_Materia, uni_Materia, qnt_Materia, preco_Materia from materia where cod_Materia =" + c);
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                materia.setId_Materia(Integer.parseInt(conecta.rs.getString("cod_Materia")));
                materia.setNome(conecta.rs.getString("desc_Materia"));
                materia.setUni(conecta.rs.getString("uni_Materia"));
                materia.setQnt(conecta.rs.getString("qnt_Materia"));
                materia.setPreco(conecta.rs.getString("preco_Materia"));
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materia;
    }


    public static Materias Excluir(Materias materia) {
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("delete from materia where cod_Materia = ?");
            pst.setInt(1, materia.getId_Materia());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Materias.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return null;
    }


    
    
    
}
