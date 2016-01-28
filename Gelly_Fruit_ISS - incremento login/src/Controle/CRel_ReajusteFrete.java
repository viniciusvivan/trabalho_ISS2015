/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.Rel_ReajusteFrete;
import java.text.DateFormat;
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
 * @author Joao
 */
public class CRel_ReajusteFrete {
    private Rel_ReajusteFrete objRelReajuste;

    public CRel_ReajusteFrete() {
        this.objRelReajuste = new Rel_ReajusteFrete();
    }

    public DefaultTableModel PesquisaObjeto(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
        //decodificando o array list em variáveis
        Date Dataini = formataData(Parametros.get(0));
        Date DataFim = formataData(Parametros.get(1));          
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<Rel_ReajusteFrete> Reajuste = this.objRelReajuste.RecuperaObjetos(Dataini, DataFim);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Rel_ReajusteFrete objPedidoBuffer;
        
        for(int i = 0; i<Reajuste.size();i++){
            vetVetor = new Vector<String>();
            objPedidoBuffer = Reajuste.get(i);
            
            try {
                vetVetor.addElement(Converte_Data(objPedidoBuffer.getData()));
            } catch (ParseException ex) {
                Logger.getLogger(CRel_ReajusteFrete.class.getName()).log(Level.SEVERE, null, ex);
            }
            vetVetor.addElement(String.valueOf(objPedidoBuffer.getPercentual()));
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
    
    private static String Converte_Data(String data) throws ParseException { 
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = inputFormat.parse(data);
        String outputDateStr = outputFormat.format(date);
        return outputDateStr;	
    }
}
