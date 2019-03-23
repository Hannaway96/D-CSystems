package ConcurrentServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServerThread extends Thread {
    
    Socket clientSocket = null;         
    int clientGuesses = 0;
    int LOWER_BOUNDARY = 0;
    int HIGHER_BOUNDARY = 0;
    int generatedNumber = 0;
    boolean found;
    
    
    MultiServerThread(Socket socket){
        super("MultServerThread");
        this.clientSocket = socket;
    }
       
    @Override 
    public void run(){
            
        //When a client connects
        try (BufferedReader is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter os = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream())))
        {
            
            System.out.println("New instance of game starting");
            found = false;
            String input, output;
                              
            //Read set boundaries from user
            LOWER_BOUNDARY = Integer.parseInt(is.readLine());
            HIGHER_BOUNDARY = Integer.parseInt(is.readLine()); 
                    
            //Create number to be guessed
            generatedNumber = generateNumber(LOWER_BOUNDARY, HIGHER_BOUNDARY);
                    
            System.out.println("Lower: " + LOWER_BOUNDARY);
            System.out.println("Higher: " + HIGHER_BOUNDARY);
            System.out.println("Selected: " + generatedNumber);
                   
            output = "Guess a number between " + LOWER_BOUNDARY + " and " + HIGHER_BOUNDARY;
            os.println(output);
            os.flush();
                    
            while((input = is.readLine()) != null && found != true){  
                        
                if(Integer.parseInt(input) > generatedNumber){
                    output = "Lower";   
                    clientGuesses++;
                }
                else if(Integer.parseInt(input) < generatedNumber){
                    output = "Higher";
                    clientGuesses++;
                }
                else{
                    output = "You got it!";
                    clientGuesses++;
                    os.println(output);
                    os.flush();  
                            
                    System.out.println("FOUND "); 
                    System.out.println("Client guessed " + clientGuesses + " times");
                    found = true; 
                }
                        
                os.println(output);
                os.flush();
                        
                if(found == true){                          
                    break;
                }    
            }                 
        }
        catch(IOException e){    
            System.out.print("Failed to get I/O Streams" + e);
            System.exit(1);
        }
        
        System.out.println("Client left");  
    }
    
    public static int generateNumber(int lower, int higher){
        int num = 0;   
        Random r = new Random();      
        num = r.nextInt(higher - lower) + lower;     
        return num;
    }
}
