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
public class Remover implements Runnable{

    
     Thread t;
     int remove;
    private Map<Integer, Boolean> toCheck;
     
     
    @Override
    public void run() {
        int i = 1;
        while(true){
            if(toCheck.containsKey(i)){
            toCheck.put(i*remove, false);
            //System.out.println(i*remove);
            i++;}
            
        }
        


    }
    
    public void start(int remove, Map<Integer, Boolean> toCheck) {   
        this.remove = remove;
        this.toCheck = toCheck;
        if (t == null) {
            t = new Thread(this, remove+"");
        }
        
        t.start();
    }
    
}
