/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testio;

import java.io.*;

public class fileStreamTest {
    public static void main (String args[]) {
        
        try{
          byte bWrite [] = {11,21,3,40,5};
          OutputStream os = new FileOutputStream("test.txt");
          for(int i = 0; i < bWrite.length; i++){
              os.write(bWrite[i]); // writes bytes
          }
          os.close();
          
          InputStream is = new FileInputStream("test.txt");
          int size = is.available();
          
          for(int i = 0; i < size; i++){
              System.out.print((char)is.read() + " ");
          }
          is.close();
        
        }catch(IOException e){
            System.out.print("Exception");
        }
    }
}
