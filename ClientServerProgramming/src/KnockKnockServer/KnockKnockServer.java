package KnockKnockServer;

import java.net.*;
import java.io.*;

public class KnockKnockServer {

    public static void main(String[] args) {
       
        try{           
            // Open a server socket to listen on port 4444
            ServerSocket serverSocket = new ServerSocket(4444);
            
            try{
                //Wait to accept a connecting client
                Socket clientSocket = serverSocket.accept();
                
                //Create Input and output stream to communicate with the client                
                try(BufferedReader is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter os = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream())))
                {
                    
                    //Set up the server state
                    System.out.println("Knock Knock Server Waiting");                   
                    
                    KKState kks = new KKState();
                    String inputLine, outputLine;
                    
                    outputLine = kks.processInput(null);
                    os.println(outputLine);
                    os.flush();
                    
                    while((inputLine = is.readLine()) != null){
                        outputLine = kks.processInput(inputLine);
                        os.println(outputLine);
                        os.flush();

                        if(outputLine.equals("Bye.")){
                            break;
                        }    
                    }
                                        
                    clientSocket.close();
                    serverSocket.close();
                    
                }catch(IOException e){              
                    System.out.println("Failed to create I/O streams" + e);
                    e.printStackTrace();
                }                      
            }catch(IOException e){
                System.out.print("Accept failed on port: " + 4444 + ", " + e);
                System.exit(1);
            }    
            
            serverSocket.close();
            
        }catch(IOException e){
            System.out.println("Could not listen on port: " + 4444 + ", " + e);
            System.exit(1);
        }        
    }    
}
