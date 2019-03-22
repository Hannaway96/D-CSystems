package MultiThreadedKnockKnockServer;

import java.io.*;
import java.net.*;

public class KnockKnockClient {

    public static void main(String[] args) {
        
        try(Socket kkSocket = new Socket("localhost", 4444);
            PrintWriter os = new PrintWriter(new OutputStreamWriter(kkSocket.getOutputStream()));
            BufferedReader is = new BufferedReader(new InputStreamReader(kkSocket.getInputStream())))
        {
            String fromServer;
            String input;
            
            while((fromServer = is.readLine()) != null){
                System.out.println("Server: " + fromServer);
                
                if(fromServer.equals("bye.")){
                    break;
                }
                
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                input = userInput.readLine();
                System.out.println("Client: " + input);
                os.println(input); // sending message to server
                os.flush();
            }
        }
        catch(UnknownHostException e){
           System.err.println("Don't know about host: localhost");     
        }
        catch(IOException e){
           System.err.println("Couldn't get I/O for the connection to: localhost"); 
        }
    }    
}
