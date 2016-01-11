package Controle;

/**
* Classe controladora
* esta classe atualiza o modelo Usuarios().
* também faz a itermediação de dados entre a view JVCadUsuario()
* e o model Usuários.
* 
* @author Vinicius Vivan
* @version 1.0  29/11/2015
* @package Modelo
*/

import Modelo.Usuarios;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class CUsuario { //Controlador de usuários
    private final Usuarios objUsuarios;
    
    //intancia classe (model) Usuarios().
    
    public CUsuario(){
        this.objUsuarios = new Usuarios();
    }
    
    /*pega os dados digitados na view e envia para a classe Salvar()
    que está implementada no model Usuarios()*/
    public void Salvar(ArrayList<String> cLista){        
        this.objUsuarios.setNome(cLista.get(0));
        this.objUsuarios.setRg(cLista.get(1));
        this.objUsuarios.setCpf(cLista.get(2));
        this.objUsuarios.setRua(cLista.get(3));
        this.objUsuarios.setBairro(cLista.get(4));
        this.objUsuarios.setComplemento(cLista.get(5));
        this.objUsuarios.setCep(cLista.get(6));
        this.objUsuarios.setEstado(cLista.get(7));
        this.objUsuarios.setPais(cLista.get(8));
        this.objUsuarios.setTelefone(cLista.get(9));
        this.objUsuarios.setCelular(cLista.get(10));
        this.objUsuarios.setEmail(cLista.get(11));
        this.objUsuarios.setCidade(cLista.get(12));
        this.objUsuarios.setSenha(cLista.get(13));
        this.objUsuarios.setUser(cLista.get(14));
        
        this.objUsuarios.Salvar();
    }
    
    /*Solicita os dados para a função Buscar() que estpa no model
    de usuário e retorna para a view*/
    public ArrayList<String> Buscar(int iCogigo){
        this.objUsuarios.Buscar(iCogigo);
        ArrayList<String> vetCampos = new ArrayList<String>();        
        
        vetCampos.add(String.valueOf(this.objUsuarios.getId_Usuario()));
        vetCampos.add(this.objUsuarios.getNome());
        vetCampos.add(this.objUsuarios.getRg());
        vetCampos.add(this.objUsuarios.getCpf());
        vetCampos.add(this.objUsuarios.getRua());
        vetCampos.add(this.objUsuarios.getBairro());
        vetCampos.add(this.objUsuarios.getCidade());
        vetCampos.add(this.objUsuarios.getEstado());
        vetCampos.add(this.objUsuarios.getCep());
        vetCampos.add(this.objUsuarios.getPais());
        vetCampos.add(this.objUsuarios.getComplemento());
        vetCampos.add(this.objUsuarios.getTelefone());
        vetCampos.add(this.objUsuarios.getCelular());
        vetCampos.add(this.objUsuarios.getEmail());
        vetCampos.add(this.objUsuarios.getSenha());
        vetCampos.add(this.objUsuarios.getUser());

        return vetCampos;
    }
    
    /*Passa os dados que devem ser alterados para a classe Alterar()
    que está implementada no model de Usuários*/
    public void Alterar(ArrayList<String> cLista) {
        this.objUsuarios.setId_Usuario(Integer.parseInt(cLista.get(0)));
        this.objUsuarios.setNome(cLista.get(1));
        this.objUsuarios.setRg(cLista.get(2));
        this.objUsuarios.setCpf(cLista.get(3));
        this.objUsuarios.setRua(cLista.get(4));
        this.objUsuarios.setBairro(cLista.get(5));
        this.objUsuarios.setComplemento(cLista.get(6));
        this.objUsuarios.setCep(cLista.get(7));
        this.objUsuarios.setEstado(cLista.get(8));
        this.objUsuarios.setPais(cLista.get(9));
        this.objUsuarios.setTelefone(cLista.get(10));
        this.objUsuarios.setCelular(cLista.get(11));
        this.objUsuarios.setEmail(cLista.get(12));
        this.objUsuarios.setCidade(cLista.get(13));    
        this.objUsuarios.setSenha(cLista.get(14));
        this.objUsuarios.setUser(cLista.get(15));
        this.objUsuarios.Alterar();
    }

    /*Envia a chave primaria do registro que deve ser excluido
    para o metodo Excluir() que está implementado no Model de Usuários*/
    public void Excluir(int codExcluir) {
        this.objUsuarios.setId_Usuario(codExcluir);        
        this.objUsuarios.Excluir();
    }

    
    public DefaultTableModel PesquisaObjeto(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
        //decodificando o array list em variáveis
        String Campo = Parametros.get(0);//criando variaveis 
        String Valor = Parametros.get(1);
        
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<Usuarios> Usuario = this.objUsuarios.RecuperaObjetos(Campo,Valor);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Usuarios objUsuariosBuffer;
        
        for(int i = 0; i<Usuario.size();i++){
            vetVetor = new Vector<String>();
            objUsuariosBuffer = Usuario.get(i);
            
            vetVetor.addElement(String.valueOf(objUsuariosBuffer.getId_Usuario()));
            vetVetor.addElement(objUsuariosBuffer.getNome());
            vetVetor.addElement(objUsuariosBuffer.getCpf());
            vetVetor.addElement(objUsuariosBuffer.getRua());
            vetVetor.addElement(objUsuariosBuffer.getTelefone());
            vetVetor.addElement(objUsuariosBuffer.getUser());
            vetVetor.addElement(objUsuariosBuffer.getSenha());
            vetVetor.addElement(objUsuariosBuffer.getCidade());
            vetVetor.addElement(objUsuariosBuffer.getBairro());
            vetVetor.addElement(objUsuariosBuffer.getCep());
            vetVetor.addElement(objUsuariosBuffer.getEstado());
            vetVetor.addElement(objUsuariosBuffer.getPais());
            vetVetor.addElement(objUsuariosBuffer.getCelular());
            vetVetor.addElement(objUsuariosBuffer.getEmail());
            vetVetor.addElement(objUsuariosBuffer.getComplemento());
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;
    }
    
    /*Busca um determinado objeto do tipo Usuarios() via chave primária
    usa a o metodo Busca() contido no model*/
    public static Usuarios BuscaCadastro(int codigo){      
        return Usuarios.Busca(codigo);
    }
}
