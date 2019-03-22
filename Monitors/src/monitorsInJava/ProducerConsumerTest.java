/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitorsInJava;

public class ProducerConsumerTest {

    public static void main(String[] args) {
        
        CubbyHole cubbyHole = new CubbyHole();
        Producer p1 = new Producer(cubbyHole);
        Consumer c1 = new Consumer(cubbyHole);
        
        p1.start();
        c1.start();      
    }
}
