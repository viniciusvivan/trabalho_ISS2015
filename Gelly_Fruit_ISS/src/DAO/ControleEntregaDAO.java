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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Larissa-PC
 */
public class ControleEntregaDAO {

    public static ArrayList<ControleEntrega> PesquisaObjeto() {
    //select do carrega tabela
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<ControleEntrega> entrega = new ArrayList<ControleEntrega>();
        
        conecta.executaSQL("SELECT id_venda, valortotal_venda, id_cliente, " +
                           "nome_distribuicao, pagamento_venda, nome_cliente " +
                           "FROM venda, distribuicao, cliente " +
                           "where entrega_venda = id_distribuicao " +
                           "and cod_cliente = id_cliente " +
                           "and status_venda = 1 order by ID_DISTRIBUICAO");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                ControleEntrega contentrega = new ControleEntrega();
               
                contentrega.setPedido(conecta.rs.getInt("id_venda"));
                contentrega.setNome_cliente(conecta.rs.getString("nome_cliente"));
                contentrega.setValor(conecta.rs.getDouble("valortotal_venda"));
                contentrega.setEntrega(conecta.rs.getString("nome_distribuicao"));
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
        
        conecta.executaSQL("SELECT v.cod_produto, v.quantidade_venda, " +
                           "v.valorprod_venda, v.valortotal_venda, p.desc_produto " +
                           "FROM venda as v,produto as p " +
                           "where v.cod_produto = p.cod_produto " +
                           "and v.id_venda = " + codigo + " order by v.cod_produto");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                ControleEntrega contentrega = new ControleEntrega();
               
                contentrega.setCod_produto(conecta.rs.getInt("v.cod_produto"));
                contentrega.setQuantidade_venda(conecta.rs.getDouble("v.quantidade_venda"));
                contentrega.setValorprod_venda(conecta.rs.getDouble("v.valorprod_venda"));
                contentrega.setValortotal_venda(conecta.rs.getDouble("v.valortotal_venda"));
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
    
}
