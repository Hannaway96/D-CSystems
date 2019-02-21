
package ConcurrancyAPIExecutorService;

import java.util.concurrent.*;

public class TestExecutor {

    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new Runnable(){ //making an anonymous runnable object to run execution inside Executor
            public void run(){
                String threadName = Thread.currentThread().getName();
                System.out.println("Hello " + threadName);
            }
        });
    }    
}
