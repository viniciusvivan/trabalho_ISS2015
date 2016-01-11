package Modelo;

//import Controle.Distribuicao;
import DAO.DistribuicaoDAO;
import java.util.ArrayList;

public class Distribuicoes {

    int id_Distribuicao;   
    String nome;
    int status;


    public int getId_Distribuicao() {
        return id_Distribuicao;
    }

    public void setId_Distribuicao(int id_Distribuicao) {
        this.id_Distribuicao = id_Distribuicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void Novo(){            
        DistribuicaoDAO.novo(this);
    }
    
    public void Alterar() {
        DistribuicaoDAO.Alterar(this);
    }

    public void Excluir() {
        DistribuicaoDAO.Excluir(this);
    }
    
     public ArrayList<Distribuicoes> RecuperaObjetos() {
        return DistribuicaoDAO.PesquisaObjeto();
    }
     
    public static ArrayList<Distribuicoes> Busca(int codigo) {
        return DistribuicaoDAO.Busca(codigo);
    }

 
    
    
}
