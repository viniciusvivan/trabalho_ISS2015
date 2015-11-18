
package Banco;

import java.util.Date;

public class Data {
   
    public static long getDiasEntre(Date dataInicial, Date dataFinal){  
          
        if (dataFinal.compareTo(dataInicial) < 0){  
            throw new IllegalArgumentException("A data final deve ser maior " +  
                    "ou igual a data inicial");  
        }  
          
        long milisecInicial = dataInicial.getTime();  
        long milisecFinal = dataFinal.getTime();  
        long dif = milisecFinal - milisecInicial;  
          
        return (((dif / 1000) / 60) / 60) / 24;  
    }  
}
