/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomicactions;


public class Qprog extends Thread{
    
    private AnyData localData;
    
    public Qprog(AnyData a, String threadName){
        super(threadName);
        this.localData = a;
    }
    
    public void run(){
        int reg1;
        
        CDS.idle(1000);       
        reg1 = this.localData.value;
        System.out.println("Qprog has read x as: " + reg1);
        
        CDS.idle(1000);      
        reg1 = reg1 + 1;
        System.out.println("Qprog has copied: " + reg1 + " back to x");
    }    
}
