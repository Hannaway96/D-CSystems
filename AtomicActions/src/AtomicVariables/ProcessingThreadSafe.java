
package AtomicVariables;

import java.util.concurrent.atomic.AtomicInteger;

 class ProcessingThreadSafe implements Runnable{     
     /*
        provides wrapper classes for int and long that can be used to 
        achieve this atomic operation,without us having to write our own 
        synchronisation code.
     */     
     private AtomicInteger count = new AtomicInteger();
     
     @Override
     public void run(){
         for(int i=1; i<5; i++){
             processSomething(i);
             count.incrementAndGet();
         }
     }
     
     public int getCount(){
         return this.count.get();   //have to call count differently as its now a class and not a native data type
     }
     
    public void processSomething(int i){
      // processing some job
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
  
    }
}
