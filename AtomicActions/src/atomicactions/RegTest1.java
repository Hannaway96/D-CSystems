
package atomicactions;

public class RegTest1 {


    public static void main(String[] args) {
        
        AnyData x = new AnyData(0);
        
        Qprog q = new Qprog(x, "Qprog");
        q.start();
        System.out.println("Thread q has been commanded to start");
             
        try{
            q.join();
        }
        catch(InterruptedException e){     
        }
              
        System.out.println("x at end of main is: " + x.value);
    }
}
