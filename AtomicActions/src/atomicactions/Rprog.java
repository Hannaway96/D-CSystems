/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomicactions;

public class Rprog extends Thread {
     private AnyData localData;
    
    public Rprog(AnyData a, String threadName){
        super(threadName);
        this.localData = a;
    }
    
    public void run(){
        int reg1;
        
        CDS.idle(3000);       
        reg1 = this.localData.value;
        System.out.println("Rprog has read x as: " + reg1);
        
        CDS.idle(1000);      
        reg1 = reg1 + 2;
        this.localData.value = reg1;
        System.out.println("Rprog has copied back: " + reg1 + " to x");
    }    
}
