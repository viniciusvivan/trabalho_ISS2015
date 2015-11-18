package Controle;

import Modelo.Clientes;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class CCliente {    
    private Clientes objClientes;
    
    public CCliente(){
        this.objClientes = new Clientes();
    }
    
    public void Salvar(ArrayList<String> cLista){        
        this.objClientes.setNome(cLista.get(0));
        this.objClientes.setRg(cLista.get(1));
        this.objClientes.setCpf(cLista.get(2));
        this.objClientes.setRua(cLista.get(3));
        this.objClientes.setBairro(cLista.get(4));
        this.objClientes.setComplemento(cLista.get(5));
        this.objClientes.setCidade(cLista.get(6));
        this.objClientes.setCep(cLista.get(7));
        this.objClientes.setPais(cLista.get(8));
        this.objClientes.setTelefone(cLista.get(9));
        this.objClientes.setCelular(cLista.get(10));
        this.objClientes.setEmail(cLista.get(11));
        this.objClientes.setFrete(Double.parseDouble(cLista.get(12)));
        this.objClientes.setEstado(cLista.get(13));
        this.objClientes.setStatus(Integer.parseInt(cLista.get(14)));
        
        this.objClientes.Salvar();
    }
    

    public void Alterar(ArrayList<String> cLista) {
        
        this.objClientes.setId_Cliente(Integer.parseInt(cLista.get(0)));
        this.objClientes.setNome(cLista.get(1));
        this.objClientes.setRg(cLista.get(2));
        this.objClientes.setCpf(cLista.get(3));
        this.objClientes.setRua(cLista.get(4));
        this.objClientes.setBairro(cLista.get(5));
        this.objClientes.setComplemento(cLista.get(6));
        this.objClientes.setCidade(cLista.get(7));
        this.objClientes.setCep(cLista.get(8));
        this.objClientes.setPais(cLista.get(9));
        this.objClientes.setTelefone(cLista.get(10));
        this.objClientes.setCelular(cLista.get(11));
        this.objClientes.setEmail(cLista.get(12));
        this.objClientes.setFrete(Double.parseDouble(cLista.get(13)));
        this.objClientes.setEstado(cLista.get(14));
        this.objClientes.setStatus(Integer.parseInt(cLista.get(15)));
        
        this.objClientes.Alterar();
    }

    public void Excluir(int codExcluir) {
        this.objClientes.setId_Cliente(codExcluir);        
        this.objClientes.Excluir();
    }

  

    public DefaultTableModel PesquisaObjeto(ArrayList<String> Parametros, DefaultTableModel ModeloTabela) {
        //decodificando o array list em variáveis
        String Campo = Parametros.get(0);//criando variaveis 
        String Valor = Parametros.get(1);
        
        //efetuar a pesquisa de objetos no banco de dados
        ArrayList<Clientes> Cliente = this.objClientes.RecuperaObjetos(Campo,Valor);
        
        //preenche a tabela com os dados retornados
        Vector<String> vetVetor;
        Clientes objClientesBuffer;
        
        for(int i = 0; i<Cliente.size();i++){
            vetVetor = new Vector<String>();
            objClientesBuffer = Cliente.get(i);
            
            vetVetor.addElement(String.valueOf(objClientesBuffer.getId_Cliente()));
            vetVetor.addElement(objClientesBuffer.getNome());
            vetVetor.addElement(objClientesBuffer.getCpf());
            vetVetor.addElement(String.valueOf(objClientesBuffer.getStatus()));
            vetVetor.addElement(objClientesBuffer.getRua());
            vetVetor.addElement(objClientesBuffer.getTelefone());
            ModeloTabela.addRow(vetVetor);
        }
        return ModeloTabela;
    }
    
    public static ArrayList<Clientes> BuscaCadastro(int codigo){  
        return Clientes.Busca(codigo);
        
    }

    public ArrayList<String> BuscaCliente(int codigo) {
        this.objClientes.BuscaEntrega(codigo);
        ArrayList<String> vetCampos = new ArrayList<String>();        
        
        vetCampos.add(this.objClientes.getRua());
        vetCampos.add(this.objClientes.getBairro());
        vetCampos.add(this.objClientes.getCidade());
        vetCampos.add(this.objClientes.getTelefone());
        
        return vetCampos;
    }

}
