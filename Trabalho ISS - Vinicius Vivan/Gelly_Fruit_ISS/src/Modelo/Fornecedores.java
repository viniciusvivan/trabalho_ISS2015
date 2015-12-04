package Modelo;

import DAO.FornecedorDAO;
import DAO.ReajusteFreteDAO;
import java.util.ArrayList;


public class Fornecedores {
    int id_Fornecedor;   
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

    
    public int getId_Fornecedor() {
        return id_Fornecedor;
    }

    public void setId_Fornecedor(int id_Fornecedor) {
        this.id_Fornecedor = id_Fornecedor;
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
        FornecedorDAO.salvar(this);
    }
    
 

    public void Alterar() {
        FornecedorDAO.Alterar(this);
    }


    public void Excluir() {
        FornecedorDAO.Excluir(this);
    }


    public static ArrayList<Fornecedores> Busca(int codigo) {
        return FornecedorDAO.Busca(codigo);
    }
    
    public void BuscaEntrega(int codigo) {
       Fornecedores fornecedortemp = FornecedorDAO.BuscaEntrega(codigo);
       this.setRua(fornecedortemp.getRua());
       this.setCidade(fornecedortemp.getCidade());
       this.setBairro(fornecedortemp.getBairro());
       this.setTelefone(fornecedortemp.getTelefone());
    }

    public ArrayList<Fornecedores> RecuperaObjetos(String Campo, String Valor) {
        String nomeCampo;
        if (Campo.equals("0")){
            nomeCampo = "NOME_FORNECEDOR";
        }
        else{
            nomeCampo = "CPF_FORNECEDOR";
        }        
        return FornecedorDAO.PesquisaObjeto(nomeCampo,Valor);        
    }

    public void BuscaFrete() {
        Fornecedores frete = FornecedorDAO.BuscaFrete();
        this.setFrete(frete.getFrete());
    }

   
    

}
