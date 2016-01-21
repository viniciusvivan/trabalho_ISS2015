/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Banco.Conexao;
import Modelo.EstornoPedido;
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
public class EstornoPedidoDAO {

    public static ArrayList<EstornoPedido> PesquisaObjeto(String nomeCampo, String Valor) {
    Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<EstornoPedido> est = new ArrayList<EstornoPedido>();
        
        conecta.executaSQL("SELECT id_venda, data_pedidoentregue, nome_cliente, valortotal_venda, nome_distribuicao " +
                           "FROM venda, distribuicao, cliente, pedido_entregue " +
                           "where id_venda = cod_pedido " + 
                           "and entrega_venda = id_distribuicao " +
                           "and cod_cliente = id_cliente " +
                           "and status_venda = 2 " +
                           "and " + nomeCampo + " = " + Valor +
                           " order by data_pedidoentregue");
              
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                EstornoPedido estorno = new EstornoPedido();
               
                estorno.setCod_Pedido(conecta.rs.getInt("id_venda"));
                estorno.setData_fechamento(conecta.rs.getString("data_pedidoentregue"));
                estorno.setNome_cliente(conecta.rs.getString("nome_cliente"));
                estorno.setValor_total(conecta.rs.getDouble("valortotal_venda"));
                estorno.setForma_entrega(conecta.rs.getString("nome_distribuicao"));
                
                
                est.add(estorno);
                estorno = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(EstornoPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return est;
    }

    public static void Concluir(int codigo) {
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update venda set STATUS_VENDA ='1' where id_venda =" + codigo);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }      
        conecta.desconecta();
    }
    
}
