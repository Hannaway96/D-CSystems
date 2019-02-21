/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GivingAThreadAName;

public class RunThreads {
    
    public static void main(String[] args) {
        
        Showline possibleThread = new Showline();
        Thread t1 = new Thread(possibleThread, "Kate"); //call thread constructor to make thread
        Thread t2 = new Thread(possibleThread, "John"); //call thread constructor to make thread
        Thread t3 = new Thread(possibleThread, "Jack");
        Thread t4 = new Thread(possibleThread, "Nicole");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        //When each thread runs it stops and passes onto the next thread
        //However it isn't fair and is biased towards some thread over others.
      }     
}
