/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Banco;
    
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {
    
    public static String usuario_logado;

    public static String getUsuario_logado() {
        return usuario_logado;
    }

    public static void setUsuario_logado(String usuario_logado) {
        Conexao.usuario_logado = usuario_logado;
    }
    
    public Statement stm;
    public ResultSet rs;
    
    private String driver = "com.mysql.jdbc.Driver";//identifica qual banco estou usando
    private String caminho = "jdbc:mysql://localhost:3306/sqlgellyfruit";//caminho do banco
    private String usuario = "root";//usuario do banco
    private String senha = "larissa";//senha do usuario do banco
    public Connection conn;//objeto conn para efetuar a conexão com o banco
    
    /*private String driver = "com.mysql.jdbc.Driver";//identifica qual banco estou usando
    private String caminho = "jdbc:mysql://localhost:3306/iss";//caminho do banco
    private String usuario = "root";//usuario do banco
    private String senha = "GUItar1234Solo";//senha do usuario do banco
    public Connection conn;//objeto conn para efetuar a conexÃ£o com o banco*/
    
    public void conexao(){//metodo responsabel por realisar a conexao com o banco
        try {
            System.setProperty("jdcb.Drivers", driver);//seta a propriedade do driver de conexao
            conn = DriverManager.getConnection(caminho,usuario,senha);//realisa a conexao com o banco
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro!\n Error:"+ex.getMessage());
       }
    }
    
    public void desconecta(){//metodo para fechar a conexÃ£o com o banco
       try {
           conn.close();
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao fechar!\n Error:"+ex.getMessage());
       }
    }
    
    public void executaSQL(String sql){//metodo para executar consutas no banco
                                       //o parametro serve para passar o que quer consultar do banco
       try {
           stm = conn.createStatement();
           rs = stm.executeQuery(sql);
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"ERRO ao executar!\n Error:"+ex.getMessage());
       }
        
    }        

           
}
