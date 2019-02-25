/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SleepingThreads;

public class RunIdlers {

    public static void main(String[] args) {
        int time = (int)(Math.random());
         
        Idler lover = new Idler(time);
        Idler hater = new Idler(time); 
        new Thread(lover, "She loves me").start();
        new Thread(hater, "She loves me not").start();
        
        while(true){
            System.out.println("Main is printing");
        }
    }
}
