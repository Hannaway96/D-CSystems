/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusyWaiting;

public class CriticalTest1 {

    public static void main(String[] args) {      
        
        
        /*
            Lock is the condition that allows P1 and P2 to gain access
            to the Critical Section. The Methods in Lock are set to
            Synchronized so that they are performed Atomically
        */
        Lock lock_crit = new Lock();
        
        P1 p1 = new P1(lock_crit);
        P2 p2 = new P2(lock_crit);
        
        p1.start();
        p2.start();
        
        System.out.println("Threads p1 and p2 commanded to start");               
    }   
}
