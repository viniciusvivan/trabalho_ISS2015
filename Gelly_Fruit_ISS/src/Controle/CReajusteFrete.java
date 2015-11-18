/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.Clientes;
import Modelo.ReajusteFrete;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larissa Matsuda
 */
public class CReajusteFrete {

    
    public static void ireport() {
        //DAO.Rel_ReajusteFreteDAO.ireport();
   }
    
    private ReajusteFrete objReajusteFrete;
    private Clientes objCliente;
    
    public CReajusteFrete(){
        this.objReajusteFrete = new ReajusteFrete();
        this.objCliente = new Clientes();
    }
    
    
    
    

    public void Novo(ArrayList<String> Registro) {
        this.objReajusteFrete.setPercentual(Registro.get(0)); 
        this.objReajusteFrete.setData(Registro.get(1)); 
        this.objReajusteFrete.Novo();
    
    }

    public DefaultTableModel PesquisaObjeto(DefaultTableModel ModeloTabela) {
       ArrayList<ReajusteFrete> ReajusteFrete = this.objReajusteFrete.RecuperaObjetos();
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        ReajusteFrete objDistribuicaoBuffer;
        
        for(int i = 0; i<ReajusteFrete.size();i++){
            vetVetor = new Vector<String>();
            objDistribuicaoBuffer = ReajusteFrete.get(i);            

            vetVetor.addElement(objDistribuicaoBuffer.getPercentual());
            vetVetor.addElement(objDistribuicaoBuffer.getData());

            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;      
    }

    public void Reajuste(Double valor) {
        //busca o valor do frete dos clientes        
        this.objReajusteFrete.Reajuste(valor);
       

       
        
    }

    
    
    
}
