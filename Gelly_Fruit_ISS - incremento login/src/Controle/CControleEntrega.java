/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.ControleEntrega;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larissa-PC
 */
public class CControleEntrega {
    
    private ControleEntrega objEntrega;
    
    public CControleEntrega(){
        this.objEntrega = new ControleEntrega();
    }
    

    public DefaultTableModel PesquisaObjeto(DefaultTableModel ModeloTabela) {
        ArrayList<ControleEntrega> Entrega = this.objEntrega.RecuperaObjetos();
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        ControleEntrega objDistribuicaoBuffer;
        
        for(int i = 0; i<Entrega.size();i++){
            vetVetor = new Vector<String>();
            objDistribuicaoBuffer = Entrega.get(i);
            
            vetVetor.addElement(String.valueOf(objDistribuicaoBuffer.getPedido()));
            vetVetor.addElement(String.valueOf(objDistribuicaoBuffer.getCod_cliente()));
            vetVetor.addElement(String.valueOf(objDistribuicaoBuffer.getNome_cliente()));
            vetVetor.addElement(String.valueOf(objDistribuicaoBuffer.getValor()));
            vetVetor.addElement(String.valueOf(objDistribuicaoBuffer.getPagto()));
            vetVetor.addElement(String.valueOf(objDistribuicaoBuffer.getEntrega()));

            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;  
    }
    
    public DefaultTableModel PesquisaObjetoProduto(DefaultTableModel ModeloTabela, int codigo) {
        ArrayList<ControleEntrega> Entrega = this.objEntrega.RecuperaObjetosProduto(codigo);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        ControleEntrega objDistribuicaoBuffer;
        
        for(int i = 0; i<Entrega.size();i++){
            vetVetor = new Vector<String>();
            objDistribuicaoBuffer = Entrega.get(i);
            
            vetVetor.addElement(String.valueOf(objDistribuicaoBuffer.getCod_produto()));
            vetVetor.addElement(String.valueOf(objDistribuicaoBuffer.getDesc_produto()));
            vetVetor.addElement(String.valueOf(objDistribuicaoBuffer.getQuantidade_venda()));
            vetVetor.addElement(String.valueOf(objDistribuicaoBuffer.getValorprod_venda()));
            vetVetor.addElement(String.valueOf(objDistribuicaoBuffer.getQuantidade_venda() * objDistribuicaoBuffer.getValorprod_venda()));

            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;  
    }

    public void Atualiza(int codigo) {  
        this.objEntrega.Atualiza(codigo);
    }

    public void Insere_PedidoEntregue(int codigo) {
        this.objEntrega.Insere_PedidoEntregue(codigo);
    }


    
}
