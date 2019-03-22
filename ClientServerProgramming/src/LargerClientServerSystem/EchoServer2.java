package LargerClientServerSystem;

import java.net.*;

public class EchoServer2 {

    static final String END_MESSAGE = ".";

    public static void main(String[] args) {
        
        int serverPort = 7000;  //default port
        String message;
        
        //if no port is specified use port 7000
        if(args.length == 1){
            serverPort = Integer.parseInt(args[0]);    
        }
        
        try{
            //instantiates a ServerSocket for accepting connections
            ServerSocket myConnectionSocket = new ServerSocket(serverPort);
            System.out.println("Echo server ready.");
            
            while(true){    //forever loop waiting to accept a connection
                System.out.println("Waiting for a connection.");
                
                //Create an object of type MyStreamSocket for data communication
                MyStreamSocket myDataSocket = new MyStreamSocket(myConnectionSocket.accept());
                System.out.println("Connection Accepted");
                boolean done = false;
            
                while(!done){
                    
                    message = myDataSocket.recieveMessage();
                    System.out.println("Message recieved: " + message);
                    
                    if((message.trim().equals(END_MESSAGE))){
                        //Session is over, close the socket
                        System.out.println("Session over");
                        myDataSocket.close();
                        done = true;
                    }
                    else{
                        //now send the echo back to the client
                        myDataSocket.sendMessage(message);                       
                    }                
                }
            }        
        }
        catch(Exception e){}
    }   
}
