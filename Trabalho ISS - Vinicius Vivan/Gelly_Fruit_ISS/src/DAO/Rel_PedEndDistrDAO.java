/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Banco.Conexao;
import Modelo.Rel_PedEndDistr;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joao
 */
public class Rel_PedEndDistrDAO {

    public static ArrayList<Rel_PedEndDistr> PesquisaObjeto(int codigo) {
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<Rel_PedEndDistr> ent = new ArrayList<Rel_PedEndDistr>();
        
        
        conecta.executaSQL("SELECT id_venda, NOME_CLIENTE, CIDADE_CLIENTE, VALORTOTAL_VENDA " +
                           "FROM venda, distribuicao, cliente " +
                           "where entrega_venda = id_distribuicao " +
                           "and cod_cliente = id_cliente " +
                           "and status_venda = 2 " +
                           "and id_distribuicao = " + codigo +
                           " order by id_venda");
        
       // conecta.executaSQL("SELECT ID_VENDA, NOME_CLIENTE, CIDADA_CLIENTE, VALORTOTAL_VENDA, FROM CLIENTE WHERE " );
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Rel_PedEndDistr distribuicao = new Rel_PedEndDistr();
               
                distribuicao.setId_venda(conecta.rs.getInt("id_venda"));
                distribuicao.setNome(conecta.rs.getString("NOME_CLIENTE"));
                distribuicao.setCidade(conecta.rs.getString("CIDADE_CLIENTE"));
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
