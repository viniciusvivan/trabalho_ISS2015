package DAO;

import Banco.Conexao;
import Modelo.Clientes;
import Modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteDAO {
    
    public static void salvar(Clientes cliente){// cria uma objeto para ser usado dentro do metodo
        Conexao conecta = new Conexao();
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into cliente(NOME_CLIENTE, RG_CLIENTE, CPF_CLIENTE, RUA_CLIENTE, BAIRRO_CLIENTE, CIDADE_CLIENTE, ESTADO_CLIENTE, CEP_CLIENTE, PAIS_CLIENTE, COMPL_CLIENTE, TEL_CLIENTE, CEL_CLIENTE, EMAIL_CLIENTE, STATUS_CLIENTE, FRETE_CLIENTE, STATUS_EXCLUSAO) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getRg());
            pst.setString(3, cliente.getCpf());
            pst.setString(4, cliente.getRua());
            pst.setString(5, cliente.getBairro());
            pst.setString(6, cliente.getCidade());
            pst.setString(7, cliente.getEstado());
            pst.setString(8, cliente.getCep());
            pst.setString(9, cliente.getPais());
            pst.setString(10, cliente.getComplemento());
            pst.setString(11, cliente.getTelefone());
            pst.setString(12, cliente.getCelular());
            pst.setString(13, cliente.getEmail());
            pst.setInt(14, cliente.getStatus());
            pst.setDouble(15, cliente.getFrete());
            pst.setInt(16, 0);
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }
        conecta.desconecta();
    }
    
    public static void Alterar(Clientes cliente){
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update cliente set NOME_CLIENTE=?, RG_CLIENTE=?, CPF_CLIENTE=?, RUA_CLIENTE=?, BAIRRO_CLIENTE=?, CIDADE_CLIENTE=?, ESTADO_CLIENTE=?, CEP_CLIENTE=?, PAIS_CLIENTE=?, COMPL_CLIENTE=?, TEL_CLIENTE=?, CEL_CLIENTE=?, EMAIL_CLIENTE=?, STATUS_CLIENTE=?, FRETE_CLIENTE=? where ID_CLIENTE = ?");
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getRg());
            pst.setString(3, cliente.getCpf());
            pst.setString(4, cliente.getRua());
            pst.setString(5, cliente.getBairro());
            pst.setString(6, cliente.getCidade());
            pst.setString(7, cliente.getEstado());
            pst.setString(8, cliente.getCep());
            pst.setString(9, cliente.getPais());
            pst.setString(10, cliente.getComplemento());
            pst.setString(11, cliente.getTelefone());
            pst.setString(12, cliente.getCelular());
            pst.setString(13, cliente.getEmail());
            pst.setInt(14, cliente.getStatus());
            pst.setDouble(15, cliente.getFrete());
            pst.setInt(16, cliente.getId_Cliente());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }      
        conecta.desconecta();
    }


    public static Clientes Excluir(Clientes cliente) { 
        //botao Escluir
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update cliente set STATUS_EXCLUSAO=? where ID_CLIENTE = ?");
            pst.setInt(1, 1);
            pst.setInt(2, cliente.getId_Cliente());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }      
        conecta.desconecta();
        return null;
    }

 
    // retorno em ArrayList
    public static ArrayList<Clientes> Busca(int codigo) {
        Conexao conecta = new Conexao();
        conecta.conexao();  
        
        conecta.executaSQL("select * from cliente where ID_CLIENTE = " + codigo + " AND STATUS_EXCLUSAO = 0");
        
        ArrayList<Clientes> cli = new ArrayList<Clientes>();
        
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Clientes cliente = new Clientes();
                cliente.setId_Cliente(conecta.rs.getInt("ID_CLIENTE"));
                cliente.setNome(conecta.rs.getString("NOME_CLIENTE"));
                cliente.setRg(conecta.rs.getString("RG_CLIENTE"));
                cliente.setCpf(conecta.rs.getString("CPF_CLIENTE"));
                cliente.setRua(conecta.rs.getString("RUA_CLIENTE"));
                cliente.setBairro(conecta.rs.getString("BAIRRO_CLIENTE"));
                cliente.setCidade(conecta.rs.getString("CIDADE_CLIENTE"));
                cliente.setEstado(conecta.rs.getString("ESTADO_CLIENTE"));
                cliente.setCep(conecta.rs.getString("CEP_CLIENTE"));
                cliente.setPais(conecta.rs.getString("PAIS_CLIENTE"));
                cliente.setComplemento(conecta.rs.getString("COMPL_CLIENTE"));
                cliente.setTelefone(conecta.rs.getString("TEL_CLIENTE"));
                cliente.setCelular(conecta.rs.getString("CEL_CLIENTE"));
                cliente.setEmail(conecta.rs.getString("EMAIL_CLIENTE"));
                cliente.setStatus(conecta.rs.getInt("STATUS_CLIENTE"));
                cliente.setFrete(conecta.rs.getDouble("FRETE_CLIENTE"));
                
                cli.add(cliente);
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cli;
       
    }
    
    public static Clientes BuscaEntrega(Integer codigo) {
        Conexao conecta = new Conexao();
        conecta.conexao();         
        Clientes cliente = new Clientes();
        
        conecta.executaSQL("select * from cliente where ID_CLIENTE = " + codigo);
        try {
            while(conecta.rs.next()){                
                cliente.setRua(conecta.rs.getString("RUA_CLIENTE"));
                cliente.setBairro(conecta.rs.getString("BAIRRO_CLIENTE"));
                cliente.setCidade(conecta.rs.getString("CIDADE_CLIENTE"));
                cliente.setTelefone(conecta.rs.getString("TEL_CLIENTE"));                
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
       
    }
    
    public static ArrayList<Clientes> PesquisaObjeto(String nomeCampo, String Valor) {
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<Clientes> cli = new ArrayList<Clientes>();
        
        conecta.executaSQL("SELECT ID_CLIENTE, NOME_CLIENTE, CPF_CLIENTE, STATUS_CLIENTE, RUA_CLIENTE, TEL_CLIENTE FROM CLIENTE WHERE " + nomeCampo + " LIKE '" + Valor + "%' AND STATUS_EXCLUSAO = 0");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Clientes cliente = new Clientes();
               
                cliente.setId_Cliente(conecta.rs.getInt("ID_CLIENTE"));
                cliente.setNome(conecta.rs.getString("NOME_CLIENTE"));
                cliente.setCpf(conecta.rs.getString("CPF_CLIENTE"));
                cliente.setStatus(conecta.rs.getInt("STATUS_CLIENTE"));
                cliente.setRua(conecta.rs.getString("RUA_CLIENTE"));
                cliente.setTelefone(conecta.rs.getString("TEL_CLIENTE"));
                
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

    public static Clientes BuscaFrete() {
        Conexao conecta = new Conexao();
        conecta.conexao();  
        Clientes reaf = new Clientes();
        conecta.executaSQL("select FRETE_CLIENTE from cliente");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                reaf.setFrete(conecta.rs.getDouble("FRETE_CLIENTE"));

            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reaf;
    
    }
}

