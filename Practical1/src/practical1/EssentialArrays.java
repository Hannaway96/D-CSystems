/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical1;

public class EssentialArrays {
    public static void main(String[] args){
            
        int myTable[][] = new int[2][3]; // sets up a 2D array
        
        System.out.println("This is an array of arrays...");
        myTable[0][0] = 1;
        myTable[0][1] = 2;
        myTable[0][2] = 3;
        myTable[1][0] = 4;
        myTable[1][1] = 5;
        myTable[1][2] = 6;

        System.out.println(myTable[0][0]);
        System.out.println(myTable[0][1]);
        System.out.println(myTable[0][2]);
        System.out.println(myTable[1][0]);
        System.out.println(myTable[1][1]);
        System.out.println(myTable[1][2]);
    }
}
