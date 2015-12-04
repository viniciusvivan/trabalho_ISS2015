package Controle;

import Modelo.Distribuicoes;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class CDistribuicao {

    public static ArrayList<Distribuicoes> BuscaCadastro(int codigo) {
        return Distribuicoes.Busca(codigo);
    }
    private Distribuicoes objDistribuicoes;
    
    public CDistribuicao(){
        this.objDistribuicoes = new Distribuicoes();
    }
    
    public void Novo(ArrayList<String> cLista){        
        this.objDistribuicoes.setNome(cLista.get(0)); 
        this.objDistribuicoes.setStatus(Integer.parseInt(cLista.get(1)));
        this.objDistribuicoes.Novo();
    }
    
    public void Alterar(ArrayList<String> cLista) {
        this.objDistribuicoes.setId_Distribuicao(Integer.parseInt(cLista.get(0)));
        this.objDistribuicoes.setNome(cLista.get(1));     
        this.objDistribuicoes.setStatus(Integer.parseInt(cLista.get(2)));
        this.objDistribuicoes.Alterar();
    }

    public void Excluir(int codExcluir) {
        this.objDistribuicoes.setId_Distribuicao(codExcluir);        
        this.objDistribuicoes.Excluir();
    }





    public DefaultTableModel PesquisaObjeto(DefaultTableModel ModeloTabela) {
       ArrayList<Distribuicoes> Distribuicoes = this.objDistribuicoes.RecuperaObjetos();
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Distribuicoes objDistribuicaoBuffer;
        
        for(int i = 0; i<Distribuicoes.size();i++){
            vetVetor = new Vector<String>();
            objDistribuicaoBuffer = Distribuicoes.get(i);
            
            vetVetor.addElement(String.valueOf(objDistribuicaoBuffer.getId_Distribuicao()));
            vetVetor.addElement(objDistribuicaoBuffer.getNome());
            if(Integer.valueOf(objDistribuicaoBuffer.getStatus()) == 0){
                vetVetor.addElement("Ativo");
            }
            else{
                vetVetor.addElement("Inativo");
            }
            //vetVetor.addElement("20");//String.valueOf(objDistribuicaoBuffer.getStatus())
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;   
    }

    
}
