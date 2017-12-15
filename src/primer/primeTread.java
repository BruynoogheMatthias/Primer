/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primer;

import java.util.List;
import java.util.Observable;

/**
 *
 * @author matthias
 */
public class primeTread extends Observable implements  Runnable{
    Thread t;
    List<Integer> prevPrimes;
    int checkPrime;
    
    public primeTread(List<Integer> prev, int prime){
        prevPrimes = prev;
        checkPrime = prime;
    }
    
    /**
     *
     * @return
     */
    @Override
    public void run() {
        //System.out.println("checking " + checkPrime);
        boolean check = true;
        for(int prime: prevPrimes){
            if(checkPrime % prime == 0){
                check = false;
            }
        }
        if(check){
         this.setChanged();
         this.notifyObservers(checkPrime);
        }
        
    }
    
        public void start(int check) {   //System.out.println(this.countObservers());
        //System.out.println("above this amount of observers for the playfield");
        
        if (t == null) {
            t = new Thread(this, check+"");
        }
        
        t.start();
    }
    
    
    
}
