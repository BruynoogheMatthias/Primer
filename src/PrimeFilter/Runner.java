/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import primer.Printer;

/**
 *
 * @author matth
 */
public class Runner {

    
    Map<Integer, Boolean> toCheck = Collections.synchronizedMap(new HashMap<Integer, Boolean>());
    List<Integer> primes= Collections.synchronizedList(new ArrayList<>());
    
    
    
    void run() {
        
        new Filler().start(toCheck);
        new Printer(primes).start();
        
         try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
            } 
         
         int i = 1;
        while(true){
            i++;
            if(!toCheck.isEmpty() && toCheck.get(i)){
                //System.out.println(i);
                primes.add(i);
                toCheck.remove(i);
               
                
                
                
              
               new Remover().start(i, toCheck);
               
//              
               
               
            }
           
        }


    }
    
}
