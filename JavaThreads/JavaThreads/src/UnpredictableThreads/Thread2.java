/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnpredictableThreads;

public class Thread2 extends Thread{
      
    private int private_time;

    
    Thread2(int delay_time){
        private_time = delay_time;
    }
    
    public void run(){
        while(true){
            CDS.idle(private_time);
            System.out.println("1");
            System.out.println("2");
        }
    }
}
