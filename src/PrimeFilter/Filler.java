/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeFilter;

import java.util.List;
import java.util.Map;

/**
 *
 * @author matth
 */
public class Filler implements Runnable{

    private Map<Integer, Boolean> toCheck;
    private Thread t;

    @Override
    public void run() {
       int i=2;
       while(true){
           if ( toCheck.size()< 2000){
           toCheck.put(i, true);
           i= i+1;}
       }
    }
    
    
    
     public void start( Map toCheck) {   //System.out.println(this.countObservers());
        //System.out.println("above this amount of observers for the playfield");
        
        this.toCheck = toCheck;
        if (t == null) {
            t = new Thread(this, "filler");
        }
        
        t.start();
    }
}
