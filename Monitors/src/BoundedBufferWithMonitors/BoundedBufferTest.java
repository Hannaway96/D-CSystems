/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoundedBufferWithMonitors;

public class BoundedBufferTest {

    public static void main(String[] args) {
        
        BoundedBuffer bb = new BoundedBuffer();
        ProducerForBB p1 = new ProducerForBB(bb);
        ConsumerForBB c1 = new ConsumerForBB(bb);
        
        p1.start();
        c1.start();     
    }    
}
