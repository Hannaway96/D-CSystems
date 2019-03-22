package MultiThreadedKnockKnockServer;

import java.io.*;
import java.net.*;

public class KKMultiServerThread extends Thread{
    
    Socket socket = null;
    
    KKMultiServerThread(Socket socket){
        super("KKMultiServerThread");
        this.socket = socket;
    }
    
    @Override
    public void run(){
        try(BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))){
            
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
        }catch(IOException e){}
    }
}
