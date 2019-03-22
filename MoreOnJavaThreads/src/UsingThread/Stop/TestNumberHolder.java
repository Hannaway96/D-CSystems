
package UsingThread.Stop;
import java.util.*;

public class TestNumberHolder {

    public static void printGeneratedNumbers(ArrayList<Integer> thisVector){
        //ensure elements are in the vector
        System.out.println("\nElements in vector: ");
        for(Integer i : thisVector){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        NumberHolder1 holder = new NumberHolder1();
        Thread numberHolderThread = new Thread(holder);
        
        numberHolderThread.start();
        Thread.sleep(5000);
        numberHolderThread.stop();
        System.out.println("The thread was terminated using the deprecated Java Stop() method");
        
        ArrayList<Integer> temp = holder.getVector();        
        System.out.println("The vector has the following " + temp.size() + " values:");
        printGeneratedNumbers(temp);
        
    }    
}
