/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoundedBufferWithMonitors;

public class ConsumerForBB extends Thread {
    
    BoundedBuffer bBuffer;
    
    public ConsumerForBB(BoundedBuffer bb){
        bBuffer = bb;
    }
    
    public void run(){
        
        int value = 0;
        
        for(int i = 0; i < 20; i++){
            try{
                sleep((int)(Math.random() * 200));            
            }catch(InterruptedException e){}
            
            value = bBuffer.get();
            System.out.println("Consumer got: " + value);
        }
    }
}
