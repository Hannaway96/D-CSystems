
package ConcurrancyAPIExecutorService;

import java.util.concurrent.*;

public class TestExecutor2 {

    public static void main(String[] args) {
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(
                ()->{   // differnt way to instantiate a task to the Executor
                String threadName = Thread.currentThread().getName();
                System.out.println("Hello " + threadName);
            }
        );
    }    
}
