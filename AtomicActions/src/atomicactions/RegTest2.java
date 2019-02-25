
package atomicactions;

public class RegTest2 {


    public static void main(String[] args) {
        
        AnyData x = new AnyData(0);
        
        Qprog q = new Qprog(x, "Qprog");
        Rprog r= new Rprog(x, "Rprog");
        q.start();
        r.start();
        System.out.println("Threads q and r have been commanded to start");
             
        try{
            q.join();
        }
        catch(InterruptedException e){     
        }
        
        try{
            r.join();
        }
        catch(InterruptedException e){     
        }
        
        System.out.println("x at end of main is: " + x.value);
    }
}
