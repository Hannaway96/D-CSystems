/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondWayOfCreatingThread;

public class TestThread {
    public static void main(String args[]){
    
        PossibleThread notAThread = new PossibleThread();
        Thread parallel = new Thread(notAThread);
        parallel.start();
        System.out.println("Creating Thread...");
        System.out.println("Started the thread");
        System.out.println("End");
        
        //This doesn't run correctly, regardless of where you place .start();
        // in a different execution order

    }
}
