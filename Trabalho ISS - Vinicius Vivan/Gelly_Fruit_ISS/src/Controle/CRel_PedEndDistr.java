/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.Rel_PedEndDistr;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joao
 */
public class CRel_PedEndDistr {
    private Rel_PedEndDistr objPedido;
    
    public CRel_PedEndDistr(){
        this.objPedido = new Rel_PedEndDistr();
    }

    public DefaultTableModel PesquisaObjeto(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
    //decodificando o array list em variáveis
        String Campo = Parametros.get(0);//criando variaveis 
        //String Valor = Parametros.get(1);
        
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<Rel_PedEndDistr> Cliente = this.objPedido.RecuperaObjetos(Campo);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Rel_PedEndDistr objClientesBuffer;
        
        for(int i = 0; i<Cliente.size();i++){
            vetVetor = new Vector<String>();
            objClientesBuffer = Cliente.get(i);
            
            vetVetor.addElement(String.valueOf(objClientesBuffer.getId_venda()));
            vetVetor.addElement(objClientesBuffer.getNome());
            vetVetor.addElement(objClientesBuffer.getCidade());
            vetVetor.addElement(String.valueOf(objClientesBuffer.getValorTotal()));
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;
    }
    
}
