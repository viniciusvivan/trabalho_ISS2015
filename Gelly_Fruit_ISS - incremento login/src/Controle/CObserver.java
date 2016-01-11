package Controle;

import Modelo.Observers;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo H. G. Matsushita
 *
 */

public class CObserver {
    private Observers objObservers;
    
    public CObserver(){
        this.objObservers = new Observers();
    }
    
    public void Excluir(String codExcluir) {
        this.objObservers.setId_Venda(codExcluir);        
        this.objObservers.Excluir();
    }
    
    public DefaultTableModel PesquisaObjeto(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
        //decodificando o array list em variáveis
        String Campo = Parametros.get(0);//criando variaveis 
        String Valor = Parametros.get(1);
        
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<Observers> Observer = this.objObservers.RecuperaObjetos(Campo,Valor);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Observers objObserversBuffer;
        
        for(int i = 0; i<Observer.size();i++){
            vetVetor = new Vector<String>();
            objObserversBuffer = Observer.get(i);
            
            vetVetor.addElement(objObserversBuffer.getId_Venda());
            vetVetor.addElement(objObserversBuffer.getId_Produto());
            vetVetor.addElement(objObserversBuffer.getQnt_Produto());
            
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;
    }
    
    public ArrayList<String> Buscar(int iCogigo){
        this.objObservers.Buscar(iCogigo);
        ArrayList<String> vetCampos = new ArrayList<String>();        
        
        vetCampos.add(String.valueOf(this.objObservers.getId_Obs()));
        vetCampos.add(this.objObservers.getId_Venda());
        vetCampos.add(this.objObservers.getId_Produto());
        vetCampos.add(this.objObservers.getQnt_Produto());
        return vetCampos;
    }
}
