/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author matthias
 */
public class Primer {

    /**
     * @param args the command line arguments
     */
    

   
    
    public static void main(String[] args) {
        List<Integer> prevPrimes= Collections.synchronizedList(new ArrayList<>());
        Printer p = new Printer(prevPrimes);
         p.start();
         prevPrimes.add(2);
        new Runner(3,8, prevPrimes).start(1);
        new Runner(5, 8, prevPrimes).start(2);
        new Runner(7,8, prevPrimes).start(3);
        
         
    }


    
}
