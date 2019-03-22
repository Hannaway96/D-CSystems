/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsingThread.Interrupt;
import java.util.*;

public class TestNumberHolder3 {

    public static void printGeneratedNumbers(ArrayList<Integer> thisVector){
        //ensure elements are in the vector
        System.out.println("\nElements in vector: ");
        for(Integer i : thisVector){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        NumberHolder3 holder = new NumberHolder3();
        Thread numberHolderThread = new Thread(holder);
        numberHolderThread.start();
        
        Thread.sleep(5000);
        numberHolderThread.interrupt();
        System.out.println("The thread was terminated using the interrupt() method");
        
        ArrayList<Integer> temp = holder.getVector();
        System.out.println("The vector has the following " + temp.size() + " values");
        printGeneratedNumbers(temp);       
    }    
}
