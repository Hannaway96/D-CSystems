/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulancePorterBuffer;

import BoundedBufferWithMonitors.*;

public class WardPorter extends Thread {
    
    WaitingRoom bBuffer;
    
    public WardPorter(WaitingRoom bb){
        bBuffer = bb;
    }
    
    public void run(){
        
        int value = 0;
        
        for(int i = 0; i < 20; i++){
            try{
                sleep((int)(Math.random() * 2000));            
            }catch(InterruptedException e){}
            
            value = bBuffer.get();
            System.out.println("Ward Porter got Patient: " + value);
        }
    }
}
