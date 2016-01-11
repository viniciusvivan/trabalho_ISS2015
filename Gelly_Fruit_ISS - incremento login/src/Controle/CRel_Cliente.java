/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.Rel_Cliente;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joao
 */
public class CRel_Cliente {

    public static void ireport() {
        //DAO.Rel_ClienteDAO.ireport();
    }
    
    private Rel_Cliente objClientes;
    
    public CRel_Cliente(){
        this.objClientes = new Rel_Cliente();
    }

    public DefaultTableModel PesquisaObjeto(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
        //decodificando o array list em variáveis
        String Campo = Parametros.get(0);//criando variaveis 
        String Valor = Parametros.get(1);
        
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<Rel_Cliente> Cliente = this.objClientes.RecuperaObjetos(Campo,Valor);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Rel_Cliente objClientesBuffer;
        
        for(int i = 0; i<Cliente.size();i++){
            vetVetor = new Vector<String>();
            objClientesBuffer = Cliente.get(i);
            
            vetVetor.addElement(String.valueOf(objClientesBuffer.getId_Cliente()));
            vetVetor.addElement(objClientesBuffer.getNome());
            vetVetor.addElement(objClientesBuffer.getCpf());
            vetVetor.addElement(String.valueOf(objClientesBuffer.getStatus()));
            vetVetor.addElement(objClientesBuffer.getTelefone());
            vetVetor.addElement(String.valueOf(objClientesBuffer.getFrete()));
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;
    }
    
}
