
package AtomicVariables;

public class JavaAtomic {

    public static void main(String[] args) throws InterruptedException {
     
        ProcessingThread pt = new ProcessingThread();   //Example of thread with no atomic Counter              
        ProcessingThreadSafe pts = new ProcessingThreadSafe();   //Example of thread with an atomic action
        
        Thread t1 = new Thread(pts, "t1");
        t1.start();
        Thread t2 = new Thread(pts, "t2");
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println("Processing count = " + pt.getCount());
    }
}
