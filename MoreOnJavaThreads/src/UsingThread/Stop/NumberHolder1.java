/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsingThread.Stop;
import java.util.*;

public class NumberHolder1 implements Runnable {
    
    private final int CAPACITY = 1000;
    private final ArrayList<Integer> vector = new ArrayList<>(CAPACITY);
        
    public ArrayList<Integer> getVector(){
        return vector;
    }
    
    @Override
    public synchronized void run(){
        
        Random number = new Random();
        int i = CAPACITY;
        while(i > 0){
            vector.add(number.nextInt(100));
            
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){}
            
            i--;
        }
    }
}
