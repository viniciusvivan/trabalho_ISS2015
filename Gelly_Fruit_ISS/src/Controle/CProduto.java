package Controle;

import Modelo.Produtos;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
//import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Gustavo H. G. Matsushita
 *
 */

public class CProduto {

    public static void ireport() {//throws JRException {
        //Modelo.Produtos.ireport();
        //DAO.ProdutoDAO.ireport();
    }
    private Produtos objProdutos;
    
    public CProduto(){
        this.objProdutos = new Produtos();
    }
    
    public void Salvar(ArrayList<String> cLista){        
        this.objProdutos.setNome(cLista.get(0));
        this.objProdutos.setUni(cLista.get(1));
        this.objProdutos.setQnt(cLista.get(2));
        this.objProdutos.setPreco(cLista.get(3));
        this.objProdutos.setStatus(Integer.parseInt(cLista.get(4)));
        this.objProdutos.Salvar();
    }
    
    public ArrayList<String> Buscar(int iCogigo){
        this.objProdutos.Buscar(iCogigo);
        ArrayList<String> vetCampos = new ArrayList<String>();        
        
        vetCampos.add(String.valueOf(this.objProdutos.getId_Produto()));
        vetCampos.add(this.objProdutos.getNome());
        vetCampos.add(this.objProdutos.getUni());
        vetCampos.add(this.objProdutos.getQnt());
        vetCampos.add(this.objProdutos.getPreco());
        vetCampos.add(String.valueOf(this.objProdutos.getStatus()));
        
        return vetCampos;
    }

    public void Alterar(ArrayList<String> cLista) {
        this.objProdutos.setId_Produto(Integer.parseInt(cLista.get(0)));
        this.objProdutos.setNome(cLista.get(1));
        this.objProdutos.setUni(cLista.get(2));
        this.objProdutos.setQnt(cLista.get(3));
        this.objProdutos.setPreco(cLista.get(4));
        this.objProdutos.setStatus(Integer.parseInt(cLista.get(5)));
        
        this.objProdutos.Alterar();
    }

    public void Excluir(int codExcluir) {
        this.objProdutos.setId_Produto(codExcluir);        
        this.objProdutos.Excluir();
    }
    
    public DefaultTableModel PesquisaObjeto(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
        //decodificando o array list em variáveis
        String Campo = Parametros.get(0);//criando variaveis 
        String Valor = Parametros.get(1);
        
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<Produtos> Produto = this.objProdutos.RecuperaObjetos(Campo,Valor);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Produtos objProdutosBuffer;
        
        for(int i = 0; i<Produto.size();i++){
            vetVetor = new Vector<String>();
            objProdutosBuffer = Produto.get(i);
            
            vetVetor.addElement(String.valueOf(objProdutosBuffer.getId_Produto()));
            vetVetor.addElement(objProdutosBuffer.getNome());
            vetVetor.addElement(objProdutosBuffer.getUni());
            vetVetor.addElement(objProdutosBuffer.getQnt());
            vetVetor.addElement(objProdutosBuffer.getPreco());
            int x;
            x = (objProdutosBuffer.getStatus());
            if (x == 0){
                vetVetor.addElement("Ativo");
            } else {
                vetVetor.addElement("Inativo");
            }
            //vetVetor.addElement(String.valueOf(objProdutosBuffer.getStatus()));
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;
    }

    public void AlterarQnt(String X) {
        Modelo.Produtos.AlterarQnt(X);
    }
    
}
