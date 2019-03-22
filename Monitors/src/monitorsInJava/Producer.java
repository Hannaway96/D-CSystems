/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorsInJava;

public class Producer extends Thread {
    
    private CubbyHole cubbyHole;
    
    public Producer(CubbyHole c){
        cubbyHole = c;
    }
    
    public void run(){
        for(int i = 0; i<10; i++){
            cubbyHole.put(i);
            System.out.println("Producer put: " + i);
            try{
                sleep((int)Math.random() + 100);
            }
            catch(InterruptedException e){}            
       }
    }
}
