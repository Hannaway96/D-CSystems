package LargerClientServerSystem;

import java.io.*;
import java.net.*;

/**
 * This class is a module which provides the application logic for an Echo
 * client using stream-mode socket
 */
public class EchoClientHelper2 {
    
    static final String END_MESSAGE = ".";
    private final MyStreamSocket mySocket;
    private final InetAddress serverHost;
    private final int serverPort;
    
    EchoClientHelper2(String hostName, String portNum) throws SocketException, UnknownHostException, IOException{
        this.serverHost = InetAddress.getByName(hostName);
        this.serverPort = Integer.parseInt(portNum);
        this.mySocket = new MyStreamSocket(this.serverHost, this.serverPort);      
    }
    
    //send the parameter (message) to the server and reads and returns the reply from the server
    public String getEcho(String message)throws SocketException, IOException{
        
        String echo = "";
        mySocket.sendMessage(message);
        echo = mySocket.recieveMessage();        
        return echo;
    }
    
    //sends the end message "." to the server
    public void done()throws SocketException, IOException{
        mySocket.sendMessage(END_MESSAGE);
        mySocket.close();
    }
    
}
