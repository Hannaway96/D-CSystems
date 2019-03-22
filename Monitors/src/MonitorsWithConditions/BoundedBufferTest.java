/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonitorsWithConditions;

public class BoundedBufferTest {

    public static void main(String[] args) {
        BoundedBuffer bb = new BoundedBuffer();
        Producer p1 = new Producer(bb);
        Consumer c1 = new Consumer(bb);
        
        p1.start();
        c1.start();
    }    
}
