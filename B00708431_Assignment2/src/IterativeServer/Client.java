package IterativeServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
             
    public static void main(String[] args) {
               
        String hostName = "localhost";    //Default Host
        int portNum = 7000;             //Default Port       
        int guessCounter = 0;
        boolean found = false;
        Scanner userInput = new Scanner(System.in);
        
        // assign host machine name and port to connect to it
        if (args.length != 0) {
            if (args[0] != null) {
                hostName = args[0]; // user specified machine
            }
            if (args[1] != null) {
                portNum = Integer.parseInt(args[1]); // user specified port
            }
        }
       
        //Try to connect to server
        try(Socket clientSocket = new Socket(hostName, portNum)){
            
            //Try to get input and output streams from server
            try(PrintWriter os = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
            {
                String fromServer;
                int userGuess = 0, lowLimit = 0, highLimit = 0;
                              
                try{
                          
                    //BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));                  
                    System.out.print("Welcome to the number guessing game!\n"
                           + "You will input two numbers, a lower limit and a higher limit.\n"
                           + "I'll think of a number between those two limits and you have to guess it.\n"
                           + "GO!");
                                                         
                    
                    
                    System.out.println("\nPlease Enter the lower boundary: "); 
                    
                    //Check user input is an integer only
                    while(!userInput.hasNextInt()){
                        System.out.println("Not a valid number");
                        userInput.next();
                    }                        
                    lowLimit = userInput.nextInt();
                    os.println(lowLimit);
                    os.flush();                                                                                               
                    
                    System.out.println("\nPlease Enter the higher boundary: ");                                
                    boolean validBoundaries = false;
                    while(validBoundaries  == false){
                        while(!userInput.hasNextInt()){                       
                            System.out.println("Not a valid number"); 
                            userInput.next();
                        }                                           
                        if(lowLimit >= userInput.nextInt()){
                            System.out.println("Lower limit cannot be greater than or equal to higher limit");
                        }
                        else{
                            validBoundaries = true;
                        }
                    }
                    
                    highLimit = userInput.nextInt(); 
                    os.println(highLimit);
                    os.flush();
                    
                    System.out.println("\nGreat! I'll now think of a number...");                                                           
                    //This is where the user starts guessing
                    while((fromServer = is.readLine()) != null){
                        
                        System.out.println("Server: " + fromServer);
                        
                        //if the user finds the selected number
                        if(fromServer.equals("You got it!")){
                            System.out.println("\nYou guessed " + guessCounter + " times.");
                            found = true;
                        }
                                
                        if(found == true){                           
                            break;
                        }   
                                               
                        userGuess = userInput.nextInt();
                        os.println(userGuess);
                        os.flush();      
                        guessCounter++; //increment guess after every message sent                      
                        }                         
                }catch(IOException e){
                    System.err.println("Unable to open I/O streams " + e);
                }                                              
            }catch(IOException e){
                 System.err.println("Unable to open socket to Host  " + e);
            }        
        }catch(IOException e){       
             System.err.println("Unable to connect to Host " + e);
        }
    }
}
