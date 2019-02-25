/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GivingAThreadAName;

public class Showline implements Runnable{
    
    public void run(){
        int count = 0; //counter to count each time the instance of thread was executed.
        while(true){
           count++;
           System.out.println(Thread.currentThread().getName() + " " + count); //gets and prints current thread name
        }
    }
}
