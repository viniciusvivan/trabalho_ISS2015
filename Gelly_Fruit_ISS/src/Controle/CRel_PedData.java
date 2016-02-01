/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.Rel_PedData;
import Modelo.Rel_PedEndDistr;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larissa-PC
 */
public class CRel_PedData {
    private Rel_PedData objPedidoData;

    public CRel_PedData() {
        this.objPedidoData = new Rel_PedData();
    }
    
    public DefaultTableModel PesquisaObjeto(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
    //decodificando o array list em variáveis
        Date Dataini = formataData(Parametros.get(0));
        Date DataFim = formataData(Parametros.get(1));          
        int codigo = Integer.parseInt(Parametros.get(2));
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<Rel_PedData> Pedidos = this.objPedidoData.RecuperaObjetos(Dataini, DataFim, codigo);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Rel_PedData objPedidoBuffer;
        
        for(int i = 0; i<Pedidos.size();i++){
            vetVetor = new Vector<String>();
            objPedidoBuffer = Pedidos.get(i);
            
            vetVetor.addElement(String.valueOf(objPedidoBuffer.getId_venda()));
            vetVetor.addElement(objPedidoBuffer.getNomeCliente());
            vetVetor.addElement(objPedidoBuffer.getEntrega());
            vetVetor.addElement(String.valueOf(objPedidoBuffer.getValorTotal()));
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;
    }
    
     public static Date formataData(String data) {   
        if (data == null || data.equals(""))  
            return null;  
          
        java.sql.Date date = null;  
        try {  
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );  
        } catch (ParseException e) {              
   
        }  
        return date;  
    }  
}
