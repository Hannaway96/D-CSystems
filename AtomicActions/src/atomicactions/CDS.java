/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomicactions;

public class CDS {//useful class for C&D Systems
    public static void idle(int millisecs){
        
        Thread mainThread; ///CDS controls Concurrancy, puts current thread to sleep
        mainThread = Thread.currentThread();
        System.out.println(mainThread.getName() + " About to sleep"); 
        try{
            Thread.sleep(millisecs);           
        }catch(Exception ex){
            System.out.println(mainThread.getName() + " Woken up");
        } 
    }// end idle
}
