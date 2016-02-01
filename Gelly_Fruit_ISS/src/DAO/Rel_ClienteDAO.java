/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Banco.Conexao;
import Modelo.Rel_Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class Rel_ClienteDAO {

    public static ArrayList<Rel_Cliente> PesquisaObjeto(String nomeCampo, String Valor) {
        String status;
        Conexao conecta = new Conexao();
        conecta.conexao();        
        ArrayList<Rel_Cliente> cli = new ArrayList<Rel_Cliente>();        
        conecta.executaSQL("SELECT ID_CLIENTE, NOME_CLIENTE, CPF_CLIENTE, STATUS_CLIENTE, TEL_CLIENTE, FRETE_CLIENTE FROM CLIENTE WHERE " + nomeCampo + " LIKE '" + Valor + "%'");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Rel_Cliente cliente = new Rel_Cliente();
                
                status = conecta.rs.getString("STATUS_CLIENTE");
                if(status.equals("0")){
                    System.out.println("ativo");
                    status = "ativo";
                }
                else{
                    System.out.println("inativo");
                    status = "inativo";
                }               
                cliente.setId_Cliente(conecta.rs.getInt("ID_CLIENTE"));
                cliente.setNome(conecta.rs.getString("NOME_CLIENTE"));
                cliente.setCpf(conecta.rs.getString("CPF_CLIENTE"));
                cliente.setStatus(status);
                cliente.setTelefone(conecta.rs.getString("TEL_CLIENTE"));
                cliente.setFrete(conecta.rs.getDouble("FRETE_CLIENTE"));                
                cli.add(cliente);
                cliente = null;
            }
            conecta.rs.close();
            conecta.desconecta();            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }            
        return cli;
    }

    public static void ireport() {
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            conecta.executaSQL("select * from cliente");
            HashMap filtro = new HashMap();
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs);
            //JasperPrint jpPrint = JasperFillManager.fillReport("C:/temporaria/produtos.jasper",new HashMap(),relatResul);
            JasperPrint jpPrint = JasperFillManager.fillReport("cliente.jasper", filtro,relatResul);
            JasperViewer viewer = new JasperViewer(jpPrint,false);
            viewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Rel_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }
    
}