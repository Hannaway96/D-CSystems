/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SleepingThreads;

public class Idler implements Runnable{
    
    private int private_idle;
    
    Idler(int idleTime){ //Implements a runnable class with a delay time as a constructor
        private_idle = idleTime;
    }
    
    public void run(){
        
        while(true){
            System.out.println("Current Thread is: " + Thread.currentThread().getName());
            CDS.idle(private_idle);
        }
    }
}
