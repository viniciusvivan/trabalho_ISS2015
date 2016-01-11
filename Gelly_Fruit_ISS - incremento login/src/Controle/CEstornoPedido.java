/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.EstornoPedido;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larissa-PC
 */
public class CEstornoPedido {
    
    private EstornoPedido objEstornoP;
    
    public CEstornoPedido(){
        this.objEstornoP = new EstornoPedido();
    }

    public DefaultTableModel PesquisaObjeto(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
        //decodificando o array list em variáveis
        String Campo = Parametros.get(0);//criando variaveis 
        String id = Parametros.get(1);
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<EstornoPedido> Cliente = this.objEstornoP.RecuperaObjetos(Campo,id);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        EstornoPedido objClientesBuffer;
        
        for(int i = 0; i<Cliente.size();i++){
            vetVetor = new Vector<String>();
            objClientesBuffer = Cliente.get(i);
            
            vetVetor.addElement(String.valueOf(objClientesBuffer.getCod_Pedido()));
                  vetVetor.addElement(objClientesBuffer.getData_fechamento());
            vetVetor.addElement(objClientesBuffer.getNome_cliente());
            vetVetor.addElement(String.valueOf(objClientesBuffer.getValor_total()));
            vetVetor.addElement(objClientesBuffer.getForma_entrega());
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;    
    }

    public DefaultTableModel PesquisaObjetoVenda(DefaultTableModel objTabela, int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    public void Concluir(int codigo) {
        this.objEstornoP.Concluir(codigo);
    }
}
