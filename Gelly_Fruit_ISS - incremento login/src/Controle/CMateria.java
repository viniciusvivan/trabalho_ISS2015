package Controle;

import Modelo.Materias;
import java.util.ArrayList;

public class CMateria {
    private Materias objMaterias;
    
    public CMateria(){
        this.objMaterias = new Materias();
    }
    
    public void Salvar(ArrayList<String> cLista){        
        this.objMaterias.setNome(cLista.get(0));
        this.objMaterias.setUni(cLista.get(1));
        this.objMaterias.setQnt(cLista.get(2));
        this.objMaterias.setPreco(cLista.get(3));
        this.objMaterias.Salvar();
    }
    
    public ArrayList<String> Buscar(int iCogigo){
        this.objMaterias.Buscar(iCogigo);
        ArrayList<String> vetCampos = new ArrayList<String>();        
        
        vetCampos.add(String.valueOf(this.objMaterias.getId_Materia()));
        vetCampos.add(this.objMaterias.getNome());
        vetCampos.add(this.objMaterias.getUni());
        vetCampos.add(this.objMaterias.getQnt());
        vetCampos.add(this.objMaterias.getPreco());
        
        return vetCampos;
    }

    public void Alterar(ArrayList<String> cLista) {
        this.objMaterias.setId_Materia(Integer.parseInt(cLista.get(0)));
        this.objMaterias.setNome(cLista.get(1));
        this.objMaterias.setUni(cLista.get(2));
        this.objMaterias.setQnt(cLista.get(3));
        this.objMaterias.setPreco(cLista.get(4));
              
        this.objMaterias.Alterar();
    }

    public void Excluir(int codExcluir) {
        this.objMaterias.setId_Materia(codExcluir);        
        this.objMaterias.Excluir();
    }
    
}
