
package assignment1V2;

public class CDS { 
    public static void idle(int millisecs){
        
        Thread mainThread = Thread.currentThread(); ///CDS controls Concurrancy, puts current thread to sleep
        System.out.println(mainThread.getName() + " About to sleep"); 
        try{
            Thread.sleep(millisecs);           
        }catch(Exception ex){
            System.out.println(mainThread.getName() + " Woken up");
        } 
    }// 
}
