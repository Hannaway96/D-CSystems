/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical1;


public class EssentialFlow {
    public static void main(String args[]){
       System.out.println("BRANCHING");
       
       //If then branching
       Boolean OK = true;
       
       //Simple if 
       if(OK){
           System.out.println("OK");
       }
       else{
            System.out.println("NOT OK");
        }
       
       //multiple line if
       if(OK){
           System.out.println("This is");
           System.out.println("reamaining OK");
       }
       else{
           System.out.println("Or is it");
           System.out.println("NOT OK?");           
       }
       
       //Switch branching
       int temperature = 37;
       switch(temperature){
           case(0):
               System.out.println("Freezing water!");
               break;
           case(37):
               System.out.println("Human Body.");
               break;
           case(100):
               System.out.println("Boiling Water!");
               break;
           default:
               System.out.println("Some Temperatures");
       }
       
       
       System.out.println("LOOPING");
       //simple for loop
       for(int i = 1; i > 0; i--){
           System.out.println("Hi down: " + i);
       };
       
       //for loop with nonunit step sizes
       for(int i = -50; i < 99; i += 50){
           System.out.println("Hi again: " + i);
       };
       
       //While loop with condition checked at the start
       int counter = 0;
       OK = true;
       while(OK){
           System.out.println("Still OK:" + counter);
           counter++;
           OK = (counter < 3);
       }
       
       
       //DO while loop executes at least one condition checked at end.
       counter = 500;
       OK = true;
       do{
           System.out.println("OK=" + OK + " counter = " + counter);
           counter++;
           OK=(counter < 3);
       }while(OK);
    }
}
