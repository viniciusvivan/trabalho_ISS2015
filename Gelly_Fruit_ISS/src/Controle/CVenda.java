/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.Vendas;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class CVenda {
    
   private final Vendas objVendas;
    
    public CVenda(){
        this.objVendas = new Vendas();
    }
    
    public void Salvar(ArrayList<String> cLista){        
        this.objVendas.setstatus_Venda(cLista.get(0));
        this.objVendas.setdata_Venda(cLista.get(1));
        this.objVendas.setcod_Cliente(cLista.get(2));
        this.objVendas.setcod_Produto(cLista.get(3));
        this.objVendas.setvalorprod_Venda(cLista.get(4));
        this.objVendas.setentrega_Venda(cLista.get(5));
        this.objVendas.setvalortotal_Venda(cLista.get(6));
        this.objVendas.setpagamento_Venda(cLista.get(7));
        this.objVendas.setquantidade_Venda(cLista.get(8));
        
        
        this.objVendas.Salvar();
    }
    
    public DefaultTableModel PesquisaObjeto(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
        //decodificando o array list em variáveis
        String Campo = Parametros.get(0);//criando variaveis 
        String Valor = Parametros.get(1);
        
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<Vendas> Venda = this.objVendas.RecuperaObjetos(Campo,Valor);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Vendas objVendasBuffer;
        
        for(int i = 0; i<Venda.size();i++){
            vetVetor = new Vector<String>();
            objVendasBuffer = Venda.get(i);
            
            vetVetor.addElement(String.valueOf(objVendasBuffer.getId_Venda()));
            vetVetor.addElement(objVendasBuffer.getstatus_Venda());
            vetVetor.addElement(objVendasBuffer.getdata_Venda());
            vetVetor.addElement(objVendasBuffer.getcod_Cliente());
            vetVetor.addElement(objVendasBuffer.getcod_Produto());
            vetVetor.addElement(objVendasBuffer.getvalorprod_Venda());
            vetVetor.addElement(objVendasBuffer.getentrega_Venda());
            vetVetor.addElement(objVendasBuffer.getvalortotal_Venda());
            vetVetor.addElement(objVendasBuffer.getpagamento_Venda());
            vetVetor.addElement(objVendasBuffer.getquantidade_Venda());
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;
    }
    
    public static ArrayList<Vendas> BuscaCadastro(int codigo){      
       
        return Vendas.Busca(codigo);
        
    }

    public void Update(int cod) {
        this.objVendas.setId_Venda(cod);        
        this.objVendas.Update();
    }
}
