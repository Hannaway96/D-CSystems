/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsingVolatileFlags;
import java.util.*;

public class TestNumberHolder2 {

    public static void printGeneratedNumbers(ArrayList<Integer> thisVector){
        //ensure elements are in the vector
        System.out.println("\nElements in vector: ");
        for(Integer i : thisVector){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws InterruptedException {
       
       NumberHolder2 holder = new NumberHolder2();
       Thread numberHolderThread = new Thread(holder);
       numberHolderThread.start();
       
       Thread.sleep(1000);
       holder.Shutdown();   //Stops the thread
       System.out.println("The thread was terminated using the volatile flag method");
       
       ArrayList<Integer> temp = holder.getVector();
       System.out.println("The vector has the following " + temp.size() + " values: ");
       printGeneratedNumbers(temp);
    }    
}
