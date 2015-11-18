package Modelo;

import DAO.ClienteDAO;
import DAO.ReajusteFreteDAO;
import java.util.ArrayList;


public class Clientes {
    int id_Cliente;   
    String nome;
    String rg;
    String cpf;
    String rua;
    String bairro;
    String cidade;
    String estado;
    String cep;
    String pais;
    String complemento;
    String telefone;
    String celular;
    String email;
    int status;
    double frete;

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    
    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public void Salvar(){            
        ClienteDAO.salvar(this);
    }
    
 

    public void Alterar() {
        ClienteDAO.Alterar(this);
    }


    public void Excluir() {
        ClienteDAO.Excluir(this);
    }


    public static ArrayList<Clientes> Busca(int codigo) {
        return ClienteDAO.Busca(codigo);
    }
    
    public void BuscaEntrega(int codigo) {
       Clientes clientetemp = ClienteDAO.BuscaEntrega(codigo);
       this.setRua(clientetemp.getRua());
       this.setCidade(clientetemp.getCidade());
       this.setBairro(clientetemp.getBairro());
       this.setTelefone(clientetemp.getTelefone());
    }

    public ArrayList<Clientes> RecuperaObjetos(String Campo, String Valor) {
        String nomeCampo;
        if (Campo.equals("0")){
            nomeCampo = "NOME_CLIENTE";
        }
        else{
            nomeCampo = "CPF_CLIENTE";
        }        
        return ClienteDAO.PesquisaObjeto(nomeCampo,Valor);        
    }

    public void BuscaFrete() {
        Clientes frete = ClienteDAO.BuscaFrete();
        this.setFrete(frete.getFrete());
    }

   
    

}
