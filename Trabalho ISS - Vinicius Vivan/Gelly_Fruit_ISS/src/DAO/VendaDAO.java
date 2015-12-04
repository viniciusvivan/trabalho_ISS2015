/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package DAO;

import Banco.Conexao;
import Modelo.Vendas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Gustavo
 */
public class VendaDAO {
    
    public static void salvar(Vendas venda){// cria uma objeto para ser usado dentro do metodo
        
         
        Conexao conecta = new Conexao();
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into venda(status_Venda, data_Venda, cod_Cliente, cod_Produto, valorprod_Venda, entrega_Venda, valortotal_Venda, pagamento_Venda, quantidade_Venda) values(?,?,?,?,?,?,?,?,?) ");
            pst.setString(1, venda.getstatus_Venda());
            pst.setString(2, venda.getdata_Venda());
            pst.setString(3, venda.getcod_Cliente());
            pst.setString(4, venda.getcod_Produto());
            pst.setString(5, venda.getvalorprod_Venda());
            pst.setString(6, venda.getentrega_Venda());
            pst.setString(7, venda.getvalortotal_Venda());
            pst.setString(8, venda.getpagamento_Venda());
            pst.setString(9, venda.getquantidade_Venda());
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }
        conecta.desconecta();
    }
    
    
    
    
    
    
    public static ArrayList<Vendas> Busca(int codigo){
        Conexao conecta = new Conexao();
        conecta.conexao();  
        
        Vendas venda = new Vendas();
        
        conecta.executaSQL("select * from venda where id_Venda = " + codigo);
        
        ArrayList<Vendas> vend = new ArrayList<Vendas>();
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                venda.setId_Venda(Integer.parseInt(conecta.rs.getString("id_Venda")));
                venda.setstatus_Venda(conecta.rs.getString("status_Venda"));
                venda.setdata_Venda(conecta.rs.getString("data_venda"));
                venda.setcod_Cliente(conecta.rs.getString("cod_Cliente"));
                venda.setcod_Produto(conecta.rs.getString("cod_Produto"));
                venda.setvalorprod_Venda(conecta.rs.getString("valorprod_Venda"));
                venda.setentrega_Venda(conecta.rs.getString("entrega_Venda"));
                venda.setvalortotal_Venda(conecta.rs.getString("valortotal_Venda"));
                venda.setpagamento_Venda(conecta.rs.getString("pagamento_Venda"));
                venda.setquantidade_Venda(conecta.rs.getString("quantidade_Venda"));
                
                
                vend.add(venda);
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vend;
    }
    
    public static ArrayList<Vendas> PesquisaObjeto(String nomeCampo, String Valor) {
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<Vendas> vend = new ArrayList<Vendas>();
        
        conecta.executaSQL("SELECT id_Venda, status_Venda, data_Venda, cod_Cliente, cod_Produto, valorprod_Venda, entrega_Venda, valortotal_Venda, pagamento_Venda, quantidade_Venda  FROM VENDA WHERE " + nomeCampo + " LIKE '" + Valor + "%'");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Vendas venda = new Vendas();
               
                venda.setId_Venda(conecta.rs.getInt("Id_Venda"));
                venda.setstatus_Venda(conecta.rs.getString("status_Venda"));
                venda.setdata_Venda(conecta.rs.getString("data_Venda"));
                venda.setcod_Cliente(conecta.rs.getString("cod_Cliente"));
                venda.setcod_Produto(conecta.rs.getString("cod_Produto"));
                venda.setvalorprod_Venda(conecta.rs.getString("valorprod_Venda"));
                venda.setentrega_Venda(conecta.rs.getString("entrega_Venda"));
                venda.setvalortotal_Venda(conecta.rs.getString("valortotal_Venda"));
                venda.setpagamento_Venda(conecta.rs.getString("pagamento_Venda"));
                venda.setquantidade_Venda(conecta.rs.getString("quantidade_Venda"));
                
                
                
                vend.add(venda);
                venda = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return vend;

    }

    public static void Update(Vendas venda) {
       Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update venda set status_venda = '1' where id_Venda = ?");
            pst.setInt(1, venda.getId_Venda());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Vendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        
    }
    
    
}
