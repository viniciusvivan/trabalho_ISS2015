package DAO;

import Banco.Conexao;
import Modelo.Produtos;
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

public class ProdutoDAO {
    
      public static void salvar(Produtos produto){// cria uma objeto para ser usado dentro do metodo
        
         
        Conexao conecta = new Conexao();
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into produto (desc_Produto, uni_Produto, qnt_Produto, preco_Produto, status_Produto) values(?,?,?,?,?) ");
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getUni());
            pst.setString(3, produto.getQnt());
            pst.setString(4, produto.getPreco());
            pst.setInt(5, produto.getStatus());
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }
        conecta.desconecta();
    }
    
    public static void Alterar(Produtos produto){
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update produto set desc_Produto=?, uni_Produto=?, qnt_Produto=?, preco_Produto=?, status_Produto=? where cod_Produto = ?");
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getUni());
            pst.setString(3, produto.getQnt());
            pst.setString(4, produto.getPreco());
            pst.setInt(5, produto.getStatus());
            pst.setInt(6, produto.getId_Produto());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }      
        conecta.desconecta();
    }

    
    public static Produtos Busca(Integer c){
        Conexao conecta = new Conexao();
        conecta.conexao();  
        Produtos produto = new Produtos();
        conecta.executaSQL("select cod_Produto, desc_Produto, uni_Produto, qnt_Produto, preco_Produto, status_Produto from produto where cod_Produto =" + c);
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                produto.setId_Produto(Integer.parseInt(conecta.rs.getString("cod_Produto")));
                produto.setNome(conecta.rs.getString("desc_Produto"));
                produto.setUni(conecta.rs.getString("uni_Produto"));
                produto.setQnt(conecta.rs.getString("qnt_Produto"));
                produto.setPreco(conecta.rs.getString("preco_Produto"));
                produto.setStatus(Integer.parseInt(conecta.rs.getString("status_Produto")));
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }


    public static Produtos Excluir(Produtos produto) {
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("delete from produto where cod_Produto = ?");
            pst.setInt(1, produto.getId_Produto());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return null;
    }

    public static ArrayList<Produtos> PesquisaObjeto(String nomeCampo, String Valor) {
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<Produtos> pro = new ArrayList<Produtos>();
        
        conecta.executaSQL("SELECT cod_Produto, desc_Produto, uni_Produto, qnt_Produto, preco_Produto, status_Produto FROM PRODUTO WHERE " + nomeCampo + " LIKE '" + Valor + "%'");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Produtos produto = new Produtos();
               
                produto.setId_Produto(conecta.rs.getInt("cod_Produto"));
                produto.setNome(conecta.rs.getString("desc_Produto"));
                produto.setUni(conecta.rs.getString("uni_Produto"));
                produto.setQnt(conecta.rs.getString("qnt_Produto"));
                produto.setPreco(conecta.rs.getString("preco_Produto"));
                produto.setStatus(conecta.rs.getInt("status_Produto"));
                
                pro.add(produto);
                produto = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return pro;

    }

   /* public static void ireport() throws JRException {
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            conecta.executaSQL("select * from produto");
            HashMap filtro = new HashMap();
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
            //JasperPrint jpPrint = JasperFillManager.fillReport("C:/temporaria/produtos.jasper",new HashMap(),relatResul);
            JasperPrint jpPrint = JasperFillManager.fillReport("produtos.jasper", filtro,relatResul);
            JasperViewer viewer = new JasperViewer(jpPrint,false);
            viewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }*/

    
    
    
    
}
