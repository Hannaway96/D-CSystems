/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulancePorterBuffer;

import BoundedBufferWithMonitors.*;

public class AmbulancePorter extends Thread  {
    
    private WaitingRoom bBuffer;
    
    public AmbulancePorter(WaitingRoom bb){
        bBuffer = bb;        
    }
    
    public void run(){
    
        for(int i = 0; i < 20; i++){
            bBuffer.put(i);
            System.out.println("Ambulance Porter put Patient: " + i);
            
            try{
                sleep((int)Math.random() * 10);
            }catch(InterruptedException e){}            
        }    
    }
}
