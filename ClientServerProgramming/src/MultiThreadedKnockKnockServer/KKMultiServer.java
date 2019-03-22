package MultiThreadedKnockKnockServer;

import java.io.*;
import java.net.*;

public class KKMultiServer {
    
    public static void main(String[] args){
        
        boolean listening = true;
        try(ServerSocket serverSocket = new ServerSocket(4444)){
            
            System.out.println("KKMultiServer started");
            while(listening){
                
                Socket clientSocket;
                try{
                    clientSocket = serverSocket.accept();
                }catch(IOException e){
                    System.err.println("Accept failed: " + 4444 + ", " + e.getMessage());
                    continue;
                }
            
                new KKMultiServerThread(clientSocket).start();
            }
            
        }catch(IOException e){
            System.err.println("Could not listen on port: " + 4444 + ", " + e.getMessage());
            System.exit(1);
        }
    }
}
