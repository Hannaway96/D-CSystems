package ConcurrentServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer {

    public static void main(String[] args) {
        
        boolean listening = true;
        int portNum = 7000; //default port
        
        if(args.length == 1){
            portNum = Integer.parseInt(args[1]);
        }                       
        //Creates the server socket that has been chosen
        try(ServerSocket serverSocket = new ServerSocket(portNum)){  
            
            System.out.println("Number server started and listening...");  
            while(listening){  
                
                Socket clientSocket;
                try{
                    clientSocket = serverSocket.accept();
                }catch(IOException e){
                    System.err.println("Accept failed: " + portNum + ", " + e.getMessage());
                    continue;
                }               
               new MultiServerThread(clientSocket).start();
            }
        }
        catch(IOException e){
             System.out.print("Couldn't listen on port: " + portNum + ", " + e);
             System.exit(1);
        }
    }    
}


