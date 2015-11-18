package Controle;

import Modelo.Fornecedores;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class CFornecedor {    
    private Fornecedores objFornecedores;
    
    public CFornecedor(){
        this.objFornecedores = new Fornecedores();
    }
    
    public void Salvar(ArrayList<String> cLista){        
        this.objFornecedores.setNome(cLista.get(0));
        this.objFornecedores.setRg(cLista.get(1));
        this.objFornecedores.setCpf(cLista.get(2));
        this.objFornecedores.setRua(cLista.get(3));
        this.objFornecedores.setBairro(cLista.get(4));
        this.objFornecedores.setComplemento(cLista.get(5));
        this.objFornecedores.setCidade(cLista.get(6));
        this.objFornecedores.setCep(cLista.get(7));
        this.objFornecedores.setPais(cLista.get(8));
        this.objFornecedores.setTelefone(cLista.get(9));
        this.objFornecedores.setCelular(cLista.get(10));
        this.objFornecedores.setEmail(cLista.get(11));
        this.objFornecedores.setEstado(cLista.get(12));
        this.objFornecedores.setStatus(Integer.parseInt(cLista.get(13)));
        
        this.objFornecedores.Salvar();
    }
    

    public void Alterar(ArrayList<String> cLista) {
        
        this.objFornecedores.setId_Fornecedor(Integer.parseInt(cLista.get(0)));
        this.objFornecedores.setNome(cLista.get(1));
        this.objFornecedores.setRg(cLista.get(2));
        this.objFornecedores.setCpf(cLista.get(3));
        this.objFornecedores.setRua(cLista.get(4));
        this.objFornecedores.setBairro(cLista.get(5));
        this.objFornecedores.setComplemento(cLista.get(6));
        this.objFornecedores.setCidade(cLista.get(7));
        this.objFornecedores.setCep(cLista.get(8));
        this.objFornecedores.setPais(cLista.get(9));
        this.objFornecedores.setTelefone(cLista.get(10));
        this.objFornecedores.setCelular(cLista.get(11));
        this.objFornecedores.setEmail(cLista.get(12));
        this.objFornecedores.setEstado(cLista.get(13));
        this.objFornecedores.setStatus(Integer.parseInt(cLista.get(14)));
        
        this.objFornecedores.Alterar();
    }

    public void Excluir(int codExcluir) {
        this.objFornecedores.setId_Fornecedor(codExcluir);        
        this.objFornecedores.Excluir();
    }

  

    public DefaultTableModel PesquisaObjeto(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
        //decodificando o array list em variáveis
        String Campo = Parametros.get(0);//criando variaveis 
        String Valor = Parametros.get(1);
        
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<Fornecedores> Fornecedor = this.objFornecedores.RecuperaObjetos(Campo,Valor);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Fornecedores objFornecedoresBuffer;
        
        for(int i = 0; i<Fornecedor.size();i++){
            vetVetor = new Vector<String>();
            objFornecedoresBuffer = Fornecedor.get(i);
            
            vetVetor.addElement(String.valueOf(objFornecedoresBuffer.getId_Fornecedor()));
            vetVetor.addElement(objFornecedoresBuffer.getNome());
            vetVetor.addElement(objFornecedoresBuffer.getCpf());
            vetVetor.addElement(String.valueOf(objFornecedoresBuffer.getStatus()));
            vetVetor.addElement(objFornecedoresBuffer.getRua());
            vetVetor.addElement(objFornecedoresBuffer.getTelefone());
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;
    }
    
    public static ArrayList<Fornecedores> BuscaCadastro(int codigo){  
        return Fornecedores.Busca(codigo);
        
    }

    public ArrayList<String> BuscaFornecedor(int codigo) {
        this.objFornecedores.BuscaEntrega(codigo);
        ArrayList<String> vetCampos = new ArrayList<String>();        
        
        vetCampos.add(this.objFornecedores.getRua());
        vetCampos.add(this.objFornecedores.getBairro());
        vetCampos.add(this.objFornecedores.getCidade());
        vetCampos.add(this.objFornecedores.getTelefone());
        
        return vetCampos;
    }

}
