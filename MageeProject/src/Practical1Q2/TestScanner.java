/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical1Q2;

import java.util.Scanner;

public class TestScanner {
    public static void main(String args[]) throws Exception{
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Type two integers");
        int input1 = scan.nextInt();
        int input2 = scan.nextInt();
        
        System.out.println("They were " + input1 + " and " + input2);
        
        System.out.println("Type two words: ");
        String firstWord = scan.next();
        String secondWord = scan.next();
        System.out.println("They were " + firstWord + " and " + secondWord);
    }
}
