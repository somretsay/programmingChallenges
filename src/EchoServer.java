/*
 * We deal with socket programming based on the client-server model.
 * Server side is the passive socket which will first be created 
 * and wait for the client to connect.
 * Client side is the active socket which will be created as needed
 * and connect to the available server socket. 
 */
import java.net.*; // network package
import java.io.*; // IO package
/**
 *
 * @author yizhu
 */
public class EchoServer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
    ServerSocket serverSocket = null; 

    try { 
         serverSocket = new ServerSocket(123); 
         // server socket with port #.
         // 1) JVM will create the server socket with given port number and 
         // the current IP address of the server.
         // 2) JVM will bind the port with the IP address. binding procedure
         // 3) sever socket has been done and listen to the port.
         // 4) server socket will wait until a client socket connection is comming.
         System.out.println("The server socket is created!");
        } 
    catch (IOException e) 
        { 
         System.err.println("Could not listen on port: 12345."); 
         System.exit(1); 
        } 

    Socket connectionSocket = null; 
    System.out.println ("Waiting for connection.....");
    //We have created a server socket with port # 12345 and now the server
    //socket are waiting for connection.
    
    try { 
         connectionSocket = serverSocket.accept(); 
         // server socket accept the client connection and
         // create an variable to indicate the client.
        } 
    catch (IOException e) 
        { 
         System.err.println("Accept failed."); 
         System.exit(1); 
        } 

    System.out.println ("Connection successful");
    System.out.println ("Waiting for input.....");

    PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), 
                                      true); 
    BufferedReader in = new BufferedReader( 
            new InputStreamReader( connectionSocket.getInputStream())); 

    String inputLine; 
    boolean done = false;
    while ((inputLine = in.readLine()) != null) 
        { 
         System.out.println ("Server: " + inputLine); 
         out.println(inputLine); 

         if (inputLine.equalsIgnoreCase("Bye")) 
             break; 
        } 

    out.close(); 
    in.close(); 
    connectionSocket.close(); 
    serverSocket.close(); 
   } 
}

