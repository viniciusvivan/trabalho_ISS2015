package DAO;

import Banco.Conexao;
import Modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    public static void salvar(Usuarios usuario){// cria uma objeto para ser usado dentro do metodo
        
         
        Conexao conecta = new Conexao();
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("insert into usuario(NOME_USUARIO, RG_USUARIO, CPF_USUARIO, RUA_USUARIO, BAIRRO_USUARIO, CIDADE_USUARIO, ESTADO_USUARIO, CEP_USUARIO, PAIS_USUARIO, COMPL_USUARIO, TEL_USUARIO, CEL_USUARIO, EMAIL_USUARIO, SENHA_USUARIO, USER_USUARIO) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getRg());
            pst.setString(3, usuario.getCpf());
            pst.setString(4, usuario.getRua());
            pst.setString(5, usuario.getBairro());
            pst.setString(6, usuario.getCidade());
            pst.setString(7, usuario.getEstado());
            pst.setString(8, usuario.getCep());
            pst.setString(9, usuario.getPais());
            pst.setString(10, usuario.getComplemento());
            pst.setString(11, usuario.getTelefone());
            pst.setString(12, usuario.getCelular());
            pst.setString(13, usuario.getEmail());
            pst.setString(14, usuario.getSenha());
            pst.setString(15, usuario.getUser());
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }
        conecta.desconecta();
    }
    
    public static void Alterar(Usuarios usuario){
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("update usuario set NOME_USUARIO=?, RG_USUARIO=?, CPF_USUARIO=?, RUA_USUARIO=?, BAIRRO_USUARIO=?, CIDADE_USUARIO=?, ESTADO_USUARIO=?, CEP_USUARIO=?, PAIS_USUARIO=?, COMPL_USUARIO=?, TEL_USUARIO=?, CEL_USUARIO=?, EMAIL_USUARIO=?, SENHA_USUARIO=?, USER_USUARIO=? where ID_USUARIO = ?");
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getRg());
            pst.setString(3, usuario.getCpf());
            pst.setString(4, usuario.getRua());
            pst.setString(5, usuario.getBairro());
            pst.setString(6, usuario.getCidade());
            pst.setString(7, usuario.getEstado());
            pst.setString(8, usuario.getCep());
            pst.setString(9, usuario.getPais());
            pst.setString(10, usuario.getComplemento());
            pst.setString(11, usuario.getTelefone());
            pst.setString(12, usuario.getCelular());
            pst.setString(13, usuario.getEmail());            
            pst.setString(14, usuario.getSenha());
            pst.setString(15, usuario.getUser());
            pst.setInt(16, usuario.getId_Usuario());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro!\n"+ ex);
        }      
        conecta.desconecta();
    }

    
    public static Usuarios Busca(Integer c){
        Conexao conecta = new Conexao();
        conecta.conexao();  
        Usuarios usuario = new Usuarios();
        conecta.executaSQL("select ID_USUARIO, NOME_USUARIO, RG_USUARIO, CPF_USUARIO, RUA_USUARIO, BAIRRO_USUARIO, CIDADE_USUARIO, ESTADO_USUARIO, CEP_USUARIO, PAIS_USUARIO, COMPL_USUARIO, TEL_USUARIO, CEL_USUARIO, EMAIL_USUARIO, SENHA_USUARIO, USER_USUARIO from usuario where id_Usuario =" + c);
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                usuario.setId_Usuario(Integer.parseInt(conecta.rs.getString("ID_USUARIO")));
                usuario.setNome(conecta.rs.getString("NOME_USUARIO"));
                usuario.setRg(conecta.rs.getString("RG_USUARIO"));
                usuario.setCpf(conecta.rs.getString("CPF_USUARIO"));
                usuario.setRua(conecta.rs.getString("RUA_USUARIO"));
                usuario.setBairro(conecta.rs.getString("BAIRRO_USUARIO"));
                usuario.setCidade(conecta.rs.getString("CIDADE_USUARIO"));
                usuario.setEstado(conecta.rs.getString("ESTADO_USUARIO"));
                usuario.setCep(conecta.rs.getString("CEP_USUARIO"));
                usuario.setPais(conecta.rs.getString("PAIS_USUARIO"));
                usuario.setComplemento(conecta.rs.getString("COMPL_USUARIO"));
                usuario.setTelefone(conecta.rs.getString("TEL_USUARIO"));
                usuario.setCelular(conecta.rs.getString("CEL_USUARIO"));
                usuario.setEmail(conecta.rs.getString("EMAIL_USUARIO"));
                usuario.setSenha(conecta.rs.getString("SENHA_USUARIO"));
                usuario.setUser(conecta.rs.getString("USER_USUARIO"));
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }


    public static Usuarios Excluir(Usuarios usuario) {
        Conexao conecta = new Conexao();
        conecta.conexao(); 
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("delete from usuario where id_usuario = ?");
            pst.setInt(1, usuario.getId_Usuario());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
        return null;
    }
    
    public static ArrayList<Usuarios> PesquisaObjeto(String nomeCampo, String Valor) {
        Conexao conecta = new Conexao();
        conecta.conexao();
        
        ArrayList<Usuarios> usu = new ArrayList<Usuarios>();
        
        conecta.executaSQL("SELECT ID_USUARIO, NOME_USUARIO, CPF_USUARIO, RUA_USUARIO, TEL_USUARIO, USER_USUARIO, SENHA_USUARIO, CIDADE_USUARIO, BAIRRO_USUARIO, CEP_USUARIO, ESTADO_USUARIO, PAIS_USUARIO, CEL_USUARIO, EMAIL_USUARIO, COMPL_USUARIO FROM USUARIO WHERE " + nomeCampo + " LIKE '" + Valor + "%'");
        try {
            while(conecta.rs.next()){//rs é o que recebe os resultados da consulta
                Usuarios usuario = new Usuarios();
               
                usuario.setId_Usuario(conecta.rs.getInt("ID_USUARIO"));
                usuario.setNome(conecta.rs.getString("NOME_USUARIO"));
                usuario.setCpf(conecta.rs.getString("CPF_USUARIO"));
                usuario.setRua(conecta.rs.getString("RUA_USUARIO"));
                usuario.setTelefone(conecta.rs.getString("TEL_USUARIO"));
                usuario.setUser(conecta.rs.getString("USER_USUARIO"));
                usuario.setSenha(conecta.rs.getString("SENHA_USUARIO"));
                usuario.setCidade(conecta.rs.getString("CIDADE_USUARIO"));
                usuario.setBairro(conecta.rs.getString("BAIRRO_USUARIO"));
                usuario.setCep(conecta.rs.getString("CEP_USUARIO"));
                usuario.setEstado(conecta.rs.getString("ESTADO_USUARIO"));
                usuario.setPais(conecta.rs.getString("PAIS_USUARIO"));
                usuario.setCelular(conecta.rs.getString("CEL_USUARIO"));
                usuario.setEmail(conecta.rs.getString("EMAIL_USUARIO"));
                usuario.setComplemento(conecta.rs.getString("COMPL_USUARIO"));
                
                
                
                usu.add(usuario);
                usuario = null;
            }
            conecta.rs.close();
            conecta.desconecta();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return usu;

    }


    
}
