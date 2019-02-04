/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testio;
import java.io.*;
public class TestIO {
    public static void main(String[] args) throws Exception {
        //maps the default System.in stream to BufferedReader so readLine is available
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Type two integers with a <return> after each: ");
        System.out.flush();
        int i1 = stringToInt(cin.readLine());
        int i2 = stringToInt(cin.readLine());
        System.out.println();
        
        System.out.println("Type two words with a <return> after each: ");
        System.out.flush();
        String firstWord = cin.readLine();
        String secondWord = cin.readLine();
        System.out.println("The words were " + firstWord + " and " + secondWord);
    }
    
    
    //Method to convert a string representation to equivalent integer value
    public static int stringToInt(String s){
        
        Integer idValue = null;
        
        try{
            idValue = new Integer(s);
        }
        catch (NumberFormatException e){
            System.out.println("Exception caught from toInt(): " + e.getMessage());
        }
        
        return idValue;
    }
    
}
