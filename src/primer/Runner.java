/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primer;

import java.util.ArrayList;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author matthias
 */
public class Runner extends Observable implements Observer, Runnable {

    List<Integer> prevPrimes;
    int add;
    int start;
    private Thread t;
    public Runner(int start, int add, List prevPrimes){
        this.prevPrimes = prevPrimes;
        this.start = start;
        this.add = add;
        
        
    }
    
    @Override
    public void run() {
         Integer checkPrime = start;
        
       

       
       
        while(true){
            if(checkPrime < prevPrimes.get(prevPrimes.size()-1)*2){
                primeTread pr = new primeTread(new ArrayList<>(prevPrimes), checkPrime);
                pr.addObserver(this);
                pr.start(checkPrime);
                checkPrime = checkPrime +add;
              }
            if(checkPrime < prevPrimes.get(prevPrimes.size()-1)*2){
                primeTread pr = new primeTread(new ArrayList<>(prevPrimes), checkPrime);
                pr.addObserver(this);
                pr.start(checkPrime);
                checkPrime = checkPrime +add;
              }
            
            
            
            
            
        }
    }
    
    
        @Override
    public void update(Observable o, Object arg) {
       prevPrimes.add((int) arg);
       
    }
    
     public void start(int trheadNumber) {   //System.out.println(this.countObservers());
        //System.out.println("above this amount of observers for the playfield");
        
        if (t == null) {
            t = new Thread(this, trheadNumber+"");
        }
        
        t.start();
    }
    

}
