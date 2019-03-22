package LargerClientServerSystem;

import java.net.*;
import java.io.*;
/**
 * A wrapper class of Socket which contains methods for sending and receiving
 * messages
 */
public class MyStreamSocket extends Socket{
    
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    
    // creates the socket given machine host address and specified port and gets input and output streams
    MyStreamSocket(InetAddress acceptorHost, int acceptorPort) throws SocketException, IOException{
        socket = new Socket(acceptorHost, acceptorPort);
        setStreams();
    }
    
    MyStreamSocket(Socket socket) throws IOException{
        this.socket = socket;
        setStreams();
    }
        
    private void setStreams() throws IOException{
        //gets an input stream for reading character-mode input (BufferedReader)
        InputStream inStream = socket.getInputStream();
        input = new BufferedReader(new InputStreamReader(inStream));
        
        //gets an output stream for writing character-mode output(PrintWriter)
        OutputStream outStream = socket.getOutputStream();
        output = new PrintWriter(new OutputStreamWriter(outStream));
    }
    
    //sends a message across the socket
    public void sendMessage(String message) throws IOException{
        
        //The ensuing flush method call is necessary for the data to
        // be written to the socket data stream before the socket is closed.
        output.println(message);
        output.flush();
    }
    
    public String recieveMessage()throws IOException{
        
        //read a line from the data stream
        String message = input.readLine();
        return message;
    }
}   
