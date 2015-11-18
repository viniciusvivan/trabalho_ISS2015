package Modelo;

import DAO.MateriaDAO;

public class Materias {
    int id_Materia;   
    String nome;
    String uni;
    String qnt;
    String preco;

    public int getId_Materia() {
        return id_Materia;
    }

    public void setId_Materia(int id_Materia) {
        this.id_Materia = id_Materia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getQnt() {
        return qnt;
    }

    public void setQnt(String qnt) {
        this.qnt = qnt;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
    
    public void Salvar(){            
        MateriaDAO.salvar(this);
    }
    
    public void Buscar(int iCodigo ){
        Materias materiaTemp = MateriaDAO.Busca(iCodigo);
        this.setId_Materia(materiaTemp.getId_Materia());
        this.setNome(materiaTemp.getNome());
        this.setUni(materiaTemp.getUni());
        this.setQnt(materiaTemp.getQnt());
        this.setPreco(materiaTemp.getPreco());
    
    }

    public void Alterar() {
        MateriaDAO.Alterar(this);
    }


    public void Excluir() {
        MateriaDAO.Excluir(this);
    }
    
    
}
