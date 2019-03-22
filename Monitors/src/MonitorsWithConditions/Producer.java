/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonitorsWithConditions;


public class Producer extends Thread {
   
    private BoundedBuffer bBuffer;
    
    public Producer(BoundedBuffer bb){
        bBuffer = bb;    
    }
    
    public void run(){
        
        for(int i = 0; i < 20; i++){
            try{
                bBuffer.put(i);
            }catch(InterruptedException e1){e1.printStackTrace();}
            
            System.out.println("Producer put: " + i);
            
            try{
                sleep((int)(Math.random() * 10));
            }catch(InterruptedException e){}
        }
    }  
}
