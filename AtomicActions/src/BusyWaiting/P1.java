/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusyWaiting;

class P1 extends Thread{
        
    private Lock lock_id;
        
    public P1(Lock lock_id_in){
         this.lock_id = lock_id_in;
    }
        
    public void run(){        
        int reg1;
        boolean cc;
        int round;
        
        for(round = 0; round < 3; round++){ // Trying to enter Critical Section with a busy-wait
            System.out.println("P1 entering CS, round: " + round);
            
            do{
              cc = this.lock_id.Tset();
              
              try{
                  sleep(100);
              }catch(InterruptedException e){}
              
              if(cc){
                System.out.println("P1 still trying");
              }   
            
            }while(cc);
            
            
            //In Critical Section
            System.out.println("P1 is in CS, round:" + round);
            try{
                sleep(100);
            }catch(InterruptedException e){}
            
            //Exit Protocol
            this.lock_id.free();
            System.out.println("P1 is out of CS, round: " + round);
            try{
                sleep(500);
            }catch(InterruptedException e){}                            
        }
        
        System.out.println("P1 finished!!");
    }
}