package LargerClientServerSystem;

import java.io.*;
/**
 * This module contains the presentation logic of an Echo Client.
 */

public class EchoClient2 {

    static final String END_MESSAGE = ".";
    
    public static void main(String[] args) {
        
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        
        try{
            System.out.println("Welcome to the echo client. \n" + "What is the name of the server host?");
            String hostName = br.readLine();
            
            if(hostName.length() == 0){
                hostName = "Jack-PC";   //if no host is specified
            }
            
            System.out.println("What is the port number for the server host?");
            String portNum = br.readLine();
            
            if(portNum.length() == 0){
                portNum = "7000";   //if no port number is specified    
            }
            
            EchoClientHelper2 helper = new EchoClientHelper2(hostName, portNum);
            String message, echo;
            boolean done = false;
            
            while(!done){
                System.out.println("Enter a line of text to be sent to the server, or a sinle period to quit");
                message = br.readLine();
                
                if((message.trim()).equals(END_MESSAGE)){
                    done = true;
                    helper.done();
                }
                else{
                    echo = helper.getEcho(message);
                    System.out.println(echo);
                }            
            }            
        }
        catch(Exception ex){
            
        }
    }    
}
