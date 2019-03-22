
package ClientProgramming;

import java.io.*;
import java.net.*;

public class EchoTest {

    public static void main(String[] args) {
       
        Socket echoSocket = null;
        PrintWriter os = null;
        BufferedReader is = null;
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        try{    
            echoSocket = new Socket("Jack-PC",7);
            os = new PrintWriter(new OutputStreamWriter(echoSocket.getOutputStream()));
            is = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            
        }catch(UnknownHostException e){
            System.err.println("Cannot connect to localHost");
        }catch(IOException e){
            System.err.println("Cannot get I/O streams");        
        }
        
        //you are now connected to the localhost and get input and
        //output streams
        
        if(echoSocket != null && os != null && is != null){
            try{
                
                String userInput = null;    //user Input
                while(!(userInput = stdIn.readLine()).isEmpty()){   //Read user input
                    
                    //write the user input to port 7 of localHost
                    os.println(userInput);
                    os.flush(); //needed to force the text to be sent
                    
                    //read back the returned text from echoserver
                    String echoedText = is.readLine();
                    
                    //print the text that was echoed back
                    System.out.println("Echoed Text: " + echoedText);
                }
                
                
                os.close();
                is.close();
                echoSocket.close();
                
            }catch(IOException e){
                System.err.println("I/O failed to communicate");
            }
        }
    }    
}
