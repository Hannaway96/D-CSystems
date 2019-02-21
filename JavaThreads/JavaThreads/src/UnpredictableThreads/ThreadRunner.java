/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnpredictableThreads;

public class ThreadRunner {
    public static void main(String[] args) {
        
        new Thread1(1000).start();
        new Thread2(2000).start();
        //Create two threads and offset their delay
        //so that AB is always output before 12
    }
}
