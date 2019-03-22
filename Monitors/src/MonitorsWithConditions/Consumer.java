/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonitorsWithConditions;


public class Consumer extends Thread {
    
    private BoundedBuffer bBuffer;
    
    public Consumer(BoundedBuffer bb){
        bBuffer = bb;
    }
    
    public void run(){
        
        int value = 0;
        
        for(int i = 0; i < 20; i++){
            try{
                value = bBuffer.get();
            }catch(InterruptedException e){e.printStackTrace();}
            
            System.out.println("Consumer got: " + value);
            
            try{
                sleep((int)(Math.random() * 2000));
            }catch(InterruptedException e){}
        }        
    }
}
