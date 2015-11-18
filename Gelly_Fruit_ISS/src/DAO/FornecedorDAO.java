package DAO;

import Banco.Conexao;
import Modelo.Fornecedores;
import Modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FornecedorDAO {
    
    public static void salvar(Fornecedores fornecedor){// cria uma objeto para ser usado dentro do metodo
        Conexao conecta = new Conexao();
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into fornecedor(NOME_FORNECEDOR, RG_FORNECEDOR, CPF_FORNECEDOR, RUA_FORNECEDOR, BAIRRO_FORNECEDOR, CIDADE_FORNECEDOR, ESTADO_FORNECEDOR, CEP_FORNECEDOR, PAIS_FORNECEDOR, COMPL_FORNECEDOR, TEL_FORNECEDOR, CEL_FORNECEDOR, EMAIL_FORNECEDOR, STATUS_FORNECEDOR) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
            pst.setString(1, fornecedor.getNome());
            pst.setString(2, fornecedor.getRg());
            pst.setString(3,fornecedor.getCpf());
            pst.setString(4, fornecedor.getRua());
            pst.setString(5, fornecedor.getBairro());
            pst.setString(6, fornecedor.getCidade());
            pst.setString(7, fornecedor.getEstado());
            pst.setString(8, fornecedor.getCep());
            pst.setString(9, fornecedor.getPais());
            pst.setString(10, fornecedor.getComplemento());
            pst.setString(11, fornecedor.getTelefone());
            pst.setString(12, fornecedor.getCelular());
            pst.setString(13, fornecedor.getEmail());
            pst.setInt(14, fornecedor.getStatus());
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }
        conecta.desconecta();
    }
    
    public static void Alterar(Fornecedores fornecedor){
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update fornecedor set NOME_FORNECEDOR=?, RG_FORNECEDOR=?, CPF_FORNECEDOR=?, RUA_FORNECEDOR=?, BAIRRO_FORNECEDOR=?, CIDADE_FORNECEDOR=?, ESTADO_FORNECEDOR=?, CEP_FORNECEDOR=?, PAIS_FORNECEDOR=?, COMPL_FORNECEDOR=?, TEL_FORNECEDOR=?, CEL_FORNECEDOR=?, EMAIL_FORNECEDOR=?, STATUS_FORNECEDOR=? where ID_FORNECEDOR = ?");
            pst.setString(1, fornecedor.getNome());
            pst.setString(2, fornecedor.getRg());
            pst.setString(3, fornecedor.getCpf());
            pst.setString(4, fornecedor.getRua());
            pst.setString(5, fornecedor.getBairro());
            pst.setString(6, fornecedor.getCidade());
            pst.setString(7, fornecedor.getEstado());
            pst.setString(8, fornecedor.getCep());
            pst.setString(9, fornecedor.getPais());
            pst.setString(10, fornecedor.getComplemento());
            pst.setString(11, fornecedor.getTelefone());
            pst.setString(12, fornecedor.getCelular());
            pst.setString(13, fornecedor.getEmail());
            pst.setInt(14, fornecedor.getStatus());
            pst.setInt(15, fornecedor.getId_Fornecedor());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }      
        conecta.desconecta();
    }


    public static Fornecedores Excluir(Fornecedores fornecedor) {
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("delete from fornecedor where id_fornecedor = ?");
            pst.setInt(1, fornecedor.getId_Fornecedor());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return null;
    }

 
    // retorno em ArrayList
    public static ArrayList<Fornecedores> Busca(int codigo) {
        Conexao conecta = new Conexao();
        conecta.conexao();  
        
        conecta.executaSQL("select * from fornecedor where ID_FORNECEDOR = " + codigo);
        
        ArrayList<Fornecedores> cli = new ArrayList<Fornecedores>();
        
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Fornecedores fornecedor = new Fornecedores();
                fornecedor.setId_Fornecedor(conecta.rs.getInt("ID_FORNECEDOR"));
                fornecedor.setNome(conecta.rs.getString("NOME_FORNECEDOR"));
                fornecedor.setRg(conecta.rs.getString("RG_FORNECEDOR"));
                fornecedor.setCpf(conecta.rs.getString("CPF_FORNECEDOR"));
                fornecedor.setRua(conecta.rs.getString("RUA_FORNECEDOR"));
                fornecedor.setBairro(conecta.rs.getString("BAIRRO_FORNECEDOR"));
                fornecedor.setCidade(conecta.rs.getString("CIDADE_FORNECEDOR"));
                fornecedor.setEstado(conecta.rs.getString("ESTADO_FORNECEDOR"));
                fornecedor.setCep(conecta.rs.getString("CEP_FORNECEDOR"));
                fornecedor.setPais(conecta.rs.getString("PAIS_FORNECEDOR"));
                fornecedor.setComplemento(conecta.rs.getString("COMPL_FORNECEDOR"));
                fornecedor.setTelefone(conecta.rs.getString("TEL_FORNECEDOR"));
                fornecedor.setCelular(conecta.rs.getString("CEL_FORNECEDOR"));
                fornecedor.setEmail(conecta.rs.getString("EMAIL_FORNECEDOR"));
                fornecedor.setStatus(conecta.rs.getInt("STATUS_FORNECEDOR"));                
                cli.add(fornecedor);
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cli;
       
    }
    
    public static Fornecedores BuscaEntrega(Integer codigo) {
        Conexao conecta = new Conexao();
        conecta.conexao();         
        Fornecedores fornecedor = new Fornecedores();
        
        conecta.executaSQL("select * from fornecedor where ID_FORNECEDOR = " + codigo);
        try {
            while(conecta.rs.next()){                
                fornecedor.setRua(conecta.rs.getString("RUA_FORNECEDOR"));
                fornecedor.setBairro(conecta.rs.getString("BAIRRO_FORNECEDOR"));
                fornecedor.setCidade(conecta.rs.getString("CIDADE_FORNECEDOR"));
                fornecedor.setTelefone(conecta.rs.getString("TEL_FORNECEDOR"));                
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fornecedor;
       
    }
    
    public static ArrayList<Fornecedores> PesquisaObjeto(String nomeCampo, String Valor) {
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<Fornecedores> cli = new ArrayList<Fornecedores>();
        
        conecta.executaSQL("SELECT ID_FORNECEDOR, NOME_FORNECEDOR, CPF_FORNECEDOR, STATUS_FORNECEDOR, RUA_FORNECEDOR, TEL_FORNECEDOR FROM FORNECEDOR WHERE " + nomeCampo + " LIKE '" + Valor + "%'");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Fornecedores fornecedor = new Fornecedores();
               
                fornecedor.setId_Fornecedor(conecta.rs.getInt("ID_FORNECEDOR"));
                fornecedor.setNome(conecta.rs.getString("NOME_FORNECEDOR"));
                fornecedor.setCpf(conecta.rs.getString("CPF_FORNECEDOR"));
                fornecedor.setStatus(conecta.rs.getInt("STATUS_FORNECEDOR"));
                fornecedor.setRua(conecta.rs.getString("RUA_FORNECEDOR"));
                fornecedor.setTelefone(conecta.rs.getString("TEL_FORNECEDOR"));
                
                cli.add(fornecedor);
                fornecedor = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return cli;

    }

    public static Fornecedores BuscaFrete() {
        Conexao conecta = new Conexao();
        conecta.conexao();  
        Fornecedores reaf = new Fornecedores();
        conecta.executaSQL("select FRETE_FORNECEDOR from fornecedor");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                reaf.setFrete(conecta.rs.getDouble("FRETE_FORNECEDOR"));

            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reaf;
    
    }
}
