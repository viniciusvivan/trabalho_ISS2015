package Modelo;

/**
* Classe que gera os objetos do tipo Usuarios()
* e também é reponsavel por solicitar informações ao blanco de dados
* via classe UsuarioDAO().
* 
* @author Vinicius Vivan
* @version 1.0  29/11/2015
* @package Modelo
*/

import DAO.UsuarioDAO;
import java.util.ArrayList;


public class Usuarios {
    int id_Usuario;   
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
    String senha;
    String user;
   

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
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

    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
   
    
    public void Salvar(){            
        UsuarioDAO.salvar(this);
    }
    
    /*Passa os dados a serem buscados para UsuárioDAO()*/
    public void Buscar(int iCodigo ){
        Usuarios usuarioTemp = UsuarioDAO.Busca(iCodigo);
        this.setId_Usuario(usuarioTemp.getId_Usuario());
        this.setNome(usuarioTemp.getNome());
        this.setRg(usuarioTemp.getRg());
        this.setCpf(usuarioTemp.getCpf());
        this.setRua(usuarioTemp.getRua());
        this.setBairro(usuarioTemp.getBairro());
        this.setCidade(usuarioTemp.getCidade());
        this.setEstado(usuarioTemp.getEstado());
        this.setCep(usuarioTemp.getCep());
        this.setPais(usuarioTemp.getPais());
        this.setComplemento(usuarioTemp.getComplemento());
        this.setTelefone(usuarioTemp.getTelefone());
        this.setCelular(usuarioTemp.getCelular());
        this.setEmail(usuarioTemp.getEmail());
        this.setUser(usuarioTemp.getUser());
        this.setSenha(usuarioTemp.getUser());
    }

    public void Alterar() {
        UsuarioDAO.Alterar(this);
    }
    
    public static Usuarios Busca(int codigo) {
        return UsuarioDAO.Busca(codigo);
    }


    public void Excluir() {
        UsuarioDAO.Excluir(this);
    }
    
    public ArrayList<Usuarios> RecuperaObjetos(String Campo, String Valor) {
        String nomeCampo;
        if (Campo.equals("0")){
            nomeCampo = "NOME_USUARIO";
        }
        else{
            nomeCampo = "CPF_USUARIO";
        }
        
        return UsuarioDAO.PesquisaObjeto(nomeCampo,Valor); 
    }

    /*public static boolean login(String login,String senha){
        return UsuarioDAO.login(login, senha);
    }*/
}