
package Controle;

import Modelo.Lancamentos;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Gustavo H. G. Matsushita
 *
 */

public class CLancamento {

    public static void ireport() {//throws JRException {
        Modelo.Lancamentos.ireport();
    }
    private Lancamentos objLancamentos;
    
    public CLancamento(){
        this.objLancamentos = new Lancamentos();
    }
    
    public void Salvar(ArrayList<String> cLista){ 
        
        
        
        this.objLancamentos.setTipo(Integer.parseInt(cLista.get(0)));
        this.objLancamentos.setProduto(cLista.get(1));
        this.objLancamentos.setQnt(cLista.get(2));
        this.objLancamentos.setObs(cLista.get(3));
        this.objLancamentos.setData(cLista.get(4));
        this.objLancamentos.Salvar();
    }
    
    public ArrayList<String> Buscar(int iCogigo){
        this.objLancamentos.Buscar(iCogigo);
        ArrayList<String> vetCampos = new ArrayList<String>();        
        
        vetCampos.add(String.valueOf(this.objLancamentos.getId_Lancamento()));
        vetCampos.add(String.valueOf(this.objLancamentos.getTipo()));
        vetCampos.add(this.objLancamentos.getProduto());
        vetCampos.add(this.objLancamentos.getQnt());
        vetCampos.add(this.objLancamentos.getObs());
        vetCampos.add(this.objLancamentos.getData());
        
        return vetCampos;
    }

        
    public DefaultTableModel PesquisaObjeto(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
        //decodificando o array list em variáveis
        String Campo = Parametros.get(0);//criando variaveis 
        String Valor = Parametros.get(1);
        
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<Lancamentos> Lancamento = this.objLancamentos.RecuperaObjetos(Campo,Valor);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Lancamentos objLancamentosBuffer;
        
        for(int i = 0; i<Lancamento.size();i++){
            vetVetor = new Vector<String>();
            objLancamentosBuffer = Lancamento.get(i);
            
            vetVetor.addElement(String.valueOf(objLancamentosBuffer.getId_Lancamento()));
            vetVetor.addElement(objLancamentosBuffer.getData());
            
            //vetVetor.addElement(String.valueOf(objLancamentosBuffer.getTipo()));
            int x;
            x = (objLancamentosBuffer.getTipo());
            if (x == 0){
                vetVetor.addElement("Saída");
            } else if (x == 1){
                vetVetor.addElement("Incidente");
            } else{
                vetVetor.addElement("Entrada");
            }
            vetVetor.addElement(objLancamentosBuffer.getProduto());
            vetVetor.addElement(objLancamentosBuffer.getQnt());
            vetVetor.addElement(objLancamentosBuffer.getObs());
            
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;
    }
    
    public DefaultTableModel PesquisaObjeto2(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
        //decodificando o array list em variáveis
        String Campo = Parametros.get(0);//criando variaveis 
        String Valor = Parametros.get(1);
        
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<Lancamentos> Lancamento = this.objLancamentos.RecuperaObjetos2(Campo,Valor);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Lancamentos objLancamentosBuffer;
        
        for(int i = 0; i<Lancamento.size();i++){
            vetVetor = new Vector<String>();
            objLancamentosBuffer = Lancamento.get(i);
            
            vetVetor.addElement(String.valueOf(objLancamentosBuffer.getId_Lancamento()));
            vetVetor.addElement(objLancamentosBuffer.getData());
            
            //vetVetor.addElement(String.valueOf(objLancamentosBuffer.getTipo()));
            int x;
            x = (objLancamentosBuffer.getTipo());
            if (x == 0){
                vetVetor.addElement("Saída");
            } else if (x == 1){
                vetVetor.addElement("Incidente");
            } else{
                vetVetor.addElement("Entrada");
            }
            vetVetor.addElement(objLancamentosBuffer.getProduto());
            vetVetor.addElement(objLancamentosBuffer.getQnt());
            vetVetor.addElement(objLancamentosBuffer.getObs());
            
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;
    }
    
}
