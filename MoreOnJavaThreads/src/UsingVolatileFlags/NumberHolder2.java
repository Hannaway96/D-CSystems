/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsingVolatileFlags;
import java.util.*;

public class NumberHolder2 implements Runnable{
    
    private final int CAPACITY = 1000;
    private final ArrayList<Integer> vector = new ArrayList<>(CAPACITY);
    private volatile boolean done = false;
    
    public ArrayList<Integer> getVector(){
        return vector;
    }
    
    public void Shutdown(){
        done = true;
    }
    
    public synchronized void run(){
        
        Random number = new Random();
        int i = CAPACITY;
        
        while(!done && i > 0){
            vector.add(number.nextInt(100));
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){}
        }
        i--;
    }
}
