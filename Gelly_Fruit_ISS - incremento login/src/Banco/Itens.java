/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Banco;

/**
 *
 * @author larissa
 */
public class Itens {
          
    private int Value;
    private String Label;

    public Itens(int Value, String Label) {
        this.Value = Value;
        this.Label = Label;
    }
    
    @Override
    public String toString(){        
        return this.Label;
    }

    public int getValue() {
        return Value;
    }
      
    
}


