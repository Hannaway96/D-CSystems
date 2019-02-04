/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical1;

public class EssentialOperators {
        public static void main(String[] args){
          
          int myInteger = 42;
          double myReal = 3.14159;
          String someName = "Jack";
          boolean myTruth = true;
          int myArray[] = {1861, 1984};
          
          System.out.println("UNARY OPERATORS");
          System.out.println(-myInteger); // negate an integer
          System.out.println(-myReal); // negate a real number
          System.out.println(myInteger++); // displays number then adds 1 to it
          System.out.println(myInteger--); // displays number then subtracts 1 from it
          
          System.out.println("BINARY OPERATORS");
          System.out.println(myInteger + 10); // addition
          System.out.println(myInteger - myReal); // subtraction
          System.out.println(100 * myReal); // multiplication
          System.out.println(myInteger / 3.0); // division with real
          System.out.println(myInteger / 3); // division without the remainder
          System.out.println(myReal / 3); // real division
          System.out.println(myInteger % 3); // modulo arithmetic shows the remainder

          System.out.println("RELATIONAL OPERATORS");
          System.out.println(myInteger > 32); // greater than
          System.out.println(myInteger >= 32); // greater than or equal to
        }
}
