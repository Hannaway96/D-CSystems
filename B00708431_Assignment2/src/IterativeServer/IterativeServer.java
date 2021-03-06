package IterativeServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class IterativeServer {

    public static void main(String[] args) {
      
        int clientGuesses = 0;
        int LOWER_BOUNDARY = 0;
        int HIGHER_BOUNDARY = 0;
        int generatedNumber = 0;
        boolean found;
                
        int portNum = 7000; //default port
        if(args.length == 1){
            portNum = Integer.parseInt(args[1]);
        }        
        System.out.println("Number server started.");       
        //Creates the server socket that has been chosen
        try(ServerSocket serverSocket = new ServerSocket(portNum)){ 
            
            while(true){
             
                //connect the client
                Socket clientSocket = serverSocket.accept();     
                //When a client connects
                try (BufferedReader is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter os = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream())))
                {
                    System.out.println("\nServer Started");  
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
                   
                    //inform user number has been generated and to start guessing
                    output = "Guess a number between " + LOWER_BOUNDARY + " and " + HIGHER_BOUNDARY;
                    os.println(output);
                    os.flush();
                    
                    //continue looping while the user keeps sending guesses and found is false
                    while((input = is.readLine()) != null && found != true){  
                        
                        //if the client's guess is greater than the target
                        if(Integer.parseInt(input) > generatedNumber){
                            output = "Lower";   
                            clientGuesses++;
                        }   //if it's lower than the target
                        else if(Integer.parseInt(input) < generatedNumber){
                            output = "Higher";
                            clientGuesses++;
                        }   //otherwise it is the target number
                        else{
                            output = "You got it!";
                            clientGuesses++;

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
                }catch(IOException e){    
                    System.out.print("Failed to get I/O Streams" + e);
                    System.exit(1);
                }
            }
        }
        catch(IOException e){
             System.out.print("Accept failed on port: " + 4444 + ", " + e);
             System.exit(1);
        }
    } 
    
    public static int generateNumber(int lower, int higher){
        int num = 0;   
        Random r = new Random();      
        num = r.nextInt(higher - lower) + lower;     
        return num;
    }
}


