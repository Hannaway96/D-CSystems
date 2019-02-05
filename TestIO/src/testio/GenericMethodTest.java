/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testio;

public class GenericMethodTest {
  public static void main(String args[]){
      
      Integer[] intArray = {1, 2, 3, 4, 5};
      Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
      Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
      
      System.out.println("Array integerArray contains: ");
      printArray(intArray); // pass an integer array
      
      System.out.println("\nArray doubleArray contains: ");
      printArray(doubleArray); //pass a douuble array
      
      System.out.println("\nArray characterArray contains: ");
      printArray(charArray); // pass a character array
  }
  
  
  //generic method printArray
  public static <E> void printArray( E[] inputArray){
      //Display array elements
      for(E element : inputArray){
          System.out.printf("%s", element);
      }
      System.out.println();
  }
}
