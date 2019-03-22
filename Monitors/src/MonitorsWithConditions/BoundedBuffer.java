/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonitorsWithConditions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    
    private int SIZE = 10;
    private int buffer[] = new int [SIZE];
    private int val;
    private int front;
    private int rear;
    private int count;
    
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    
    public int get()throws InterruptedException{
    
        lock.lock();
        try{
            while(count == 0){
                notEmpty.await();
            }
            
            val = buffer[front];
            front = (front + 1) % SIZE;
            count--;
            notFull.signal();
            return val;
        }
        finally{               
            lock.unlock();
        }   
    }
    
    public void put(int value) throws InterruptedException{
        
        lock.lock();
        try{
            while(count == SIZE){
                notFull.await();
            }
            
            buffer[rear] = value;
            rear = (rear + 1) % SIZE;
            count++;
            notEmpty.signal();
        }
        finally{
            lock.unlock();
        }    
    }   
}
