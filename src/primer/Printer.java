/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primer;

import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matthias
 */
public class Printer extends Observable implements Runnable{
    
    Thread t;
    List<Integer> list;
    
    int length = 0;
    public Printer(List<Integer> list){
this.list = list;

    }

    @Override
    public void run() {
        System.out.println("printer running");
        while(true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                
            }
            
            list.sort(new IntComparator());
            System.out.println(list.size()- length + " with " + list.get(list.size()-1));
            length = list.size();
        }
    }
    
     public void start() {   //System.out.println(this.countObservers());
        //System.out.println("above this amount of observers for the playfield");
        
        if (t == null) {
            t = new Thread(this, "Printer");
        }
        
        t.start();
    }
     

    private static class IntComparator implements Comparator<Integer> {

        public IntComparator() {
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
    
}

