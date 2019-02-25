/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondWayOfCreatingThread;

class PossibleThread implements Runnable{
    
    public void run(){
        for(int i=0; i<4; i++){
            System.out.println("Message " + i + " " + Thread.currentThread().getName());
        }
    }    
}
