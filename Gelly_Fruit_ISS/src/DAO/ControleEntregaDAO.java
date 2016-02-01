/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Banco.Conexao;
import Modelo.ControleEntrega;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Larissa-PC
 */
public class ControleEntregaDAO {

    public static ArrayList<ControleEntrega> PesquisaObjeto() {
        //select do carrega tabela
        System.out.println("aki");
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<ControleEntrega> entrega = new ArrayList<ControleEntrega>();
        
        conecta.executaSQL("SELECT id_venda, valortotal_venda, id_cliente, " +
                           "NOME_DISTRIBUICAO, pagamento_venda, nome_cliente " +
                           "FROM venda, distribuicao, cliente " +
                           "where entrega_venda = id_distribuicao " +
                           "and id_cliente = cod_cliente " +
                           "and status_venda = 1 order by id_venda");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                System.out.println("aki while");
                ControleEntrega contentrega = new ControleEntrega();
               
                contentrega.setPedido(conecta.rs.getInt("id_venda"));
                contentrega.setNome_cliente(conecta.rs.getString("nome_cliente"));
                contentrega.setValor(conecta.rs.getDouble("valortotal_venda"));
                contentrega.setEntrega(conecta.rs.getString("NOME_DISTRIBUICAO"));
                contentrega.setPagto(conecta.rs.getString("pagamento_venda"));
                contentrega.setCod_cliente(conecta.rs.getInt("id_cliente"));

                
                entrega.add(contentrega);
                contentrega = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(DistribuicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return entrega;  
    }
    
    public static ArrayList<ControleEntrega> PesquisaObjetoProduto(int codigo) {
    //select do carrega tabela
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<ControleEntrega> entrega = new ArrayList<ControleEntrega>();
        
        conecta.executaSQL("SELECT i.id_produto, i.quantidade, " +
                           "p.preco_produto, p.desc_produto " +
                           "FROM produto as p, produtos_venda i " +
                           "where i.id_produto = p.cod_produto " +
                           "and i.id_venda = " + codigo + " order by i.id_produto");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                ControleEntrega contentrega = new ControleEntrega();
               
                contentrega.setCod_produto(conecta.rs.getInt("i.id_produto"));
                contentrega.setQuantidade_venda(conecta.rs.getDouble("i.quantidade"));
                contentrega.setValorprod_venda(conecta.rs.getDouble("p.preco_produto"));
                contentrega.setDesc_produto(conecta.rs.getString("p.desc_produto"));

                
                entrega.add(contentrega);
                contentrega = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(DistribuicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return entrega;  
    }

    public static void Atualiza(int codigo) {
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update venda set STATUS_VENDA ='2' where id_venda =" + codigo);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }      
        conecta.desconecta();
    }

    public static void Insere_PedidoEntregue(int codigo) {
        
        String data_hoje = null;
        data_hoje = getDateTime();
        
        Conexao conecta = new Conexao();
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into pedido_entregue(cod_pedido, data_pedidoentregue) values(?,?) ");
            pst.setInt(1, codigo);
            pst.setString(2, data_hoje);
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }
        conecta.desconecta();
    }
    
    private static String getDateTime() { 
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        Date date = new Date(); 
        return dateFormat.format(date);
    }

   
}