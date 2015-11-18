/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Banco.Conexao;
import Modelo.Rel_PedData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Larissa-PC
 */
public class Rel_PedDataDAO {
    public static ArrayList<Rel_PedData> PesquisaObjeto(Date dataini, Date datafim, int codigo) {
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<Rel_PedData> ent = new ArrayList<Rel_PedData>();        

        String Sql = "SELECT id_venda, NOME_CLIENTE, nome_distribuicao, VALORTOTAL_VENDA " +
                "FROM venda, distribuicao, cliente " +
                "where entrega_venda = id_distribuicao " +
                "and cod_cliente = id_cliente " +
                "and status_venda = 2 ";
        
                if (dataini != null){
                    Sql = Sql + "and data_venda >= '" + dataini + "'" +
                                "and data_venda <= '" + datafim + "'";        
                }        
                if(codigo != 0){
                    Sql = Sql + "and id_cliente = " + codigo; 
                }        
        
        conecta.executaSQL(Sql);
        
       // conecta.executaSQL("SELECT ID_VENDA, NOME_CLIENTE, CIDADA_CLIENTE, VALORTOTAL_VENDA, FROM CLIENTE WHERE " );
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Rel_PedData distribuicao = new Rel_PedData();
               
                distribuicao.setId_venda(conecta.rs.getInt("id_venda"));
                distribuicao.setNomeCliente(conecta.rs.getString("NOME_CLIENTE"));
                distribuicao.setEntrega(conecta.rs.getString("nome_distribuicao"));
                distribuicao.setValorTotal(conecta.rs.getInt("VALORTOTAL_VENDA"));
                               
                ent.add(distribuicao);
                distribuicao = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return ent;
    }

}
