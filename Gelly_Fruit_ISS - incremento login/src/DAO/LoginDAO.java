package DAO;

import Banco.Conexao;
import Modelo.Usuarios;

public class LoginDAO {
    public static boolean login(String login, String senha){
        Conexao conecta = new Conexao();
        conecta.conexao();  
        Usuarios usuario = new Usuarios();
        conecta.executaSQL("SELECT COUNT(*) FROM usuario WHERE user_usuario =" + login + "and senhha_usuario =" + senha);
        if(conecta.rs.equals(1)){
            return true;
        }else{
            return false;
        }    
    }
    
}
