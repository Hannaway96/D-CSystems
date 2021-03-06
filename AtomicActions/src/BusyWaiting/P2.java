/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusyWaiting;

class P2 extends Thread{
        
    private Lock lock_id;
        
    public P2(Lock lock_id_in){
         this.lock_id = lock_id_in;
    }
        
    public void run(){        
        int reg1;
        boolean cc;
        int round;
        
        for(round = 0; round < 3; round++){
            //Trying to enter the Critical Section(Busy-Wait)
            System.out.println("P2 entering CS, round: " + round);
            
            do{
              cc = this.lock_id.Tset();   
              
              try{
                  sleep(5000);
              }catch(InterruptedException e){}
              
              if(cc){
                System.out.println("P2 still trying");
              }  
            }while(cc);
            
            
            //In Critical Section
            System.out.println("P2 is in CS, round:" + round);
            try{
                sleep(1000);
            }catch(InterruptedException e){}
            
            this.lock_id.free();
            System.out.println("P2 is out of CS, round: " + round);
            
            try{
            sleep(5000);
            }catch(InterruptedException e){}
        }
        
        System.out.println("P2 finished!!");
    }
}