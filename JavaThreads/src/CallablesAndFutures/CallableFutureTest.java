/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CallablesAndFutures;

import java.util.concurrent.*;

public class CallableFutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException{
        
        //callable code
        Callable <Integer> task=()->{
        try{
            TimeUnit.SECONDS.sleep(1);
            return 123;
        }catch(InterruptedException e){
            throw new IllegalStateException("task interrupted", e);
            }
        };
        
        
        //ExecutorCode
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);
        
        System.out.println("future done?" + future.isDone());
        
        Integer result = future.get();
        
        System.out.println("Future done? " + future.isDone());
        System.out.print("result: " + result);
    }   
    
}
