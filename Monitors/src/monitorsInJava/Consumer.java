/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorsInJava;

public class Consumer extends Thread{
    
    private CubbyHole cubbyHole;
    
    public Consumer(CubbyHole c){
        cubbyHole = c;
    }
    
    public void run(){
        int value = 0;
        
        for(int i = 0; i < 10; i++){    
            try{
                sleep((int)Math.random() * 2000);
            }catch(InterruptedException e){}
            
            value = cubbyHole.get();
            System.out.println("Consumer got: " + value);           
        }
    }
}
