/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.net.*;

/**
 *
 * @author yizhu
 */
public class EchoClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
     String serverHostname = new String ("127.0.0.1");
     //you can put either localhost or 127.0.0.1 to describe that the server
     // and the client are at the same machine.

        if (args.length > 0)
           serverHostname = args[0];
        //System.out.println ("Attemping to connect to host " +
	//	serverHostname + " on port 12345.");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            // echoSocket = new Socket("taranis", 7);
            echoSocket = new Socket(serverHostname,123);
            //1) client socket should provide the serverHostname and 
            //   port number of the server
            //2) client will try to connect to the server
            // We finish step 2 which sends connection request to the server
            System.out.println("The client socket is created and attempting "
                    + "to connect to host!");
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " + serverHostname);
            System.exit(1);
        }

	BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
	String userInput = null;

        System.out.print ("input: ");
        
	while ((userInput = stdIn.readLine()) !=  null ) {
	    out.println(userInput);
	    try{
                
                if(userInput.equalsIgnoreCase("Bye")) 
                {System.out.println("Socket will be closed!");break;}
            }
            catch (Exception e)
            {
                System.out.println("Socket Closed!");
                break;
            }
            System.out.print ("change: ");
            
	}

	out.close();
	in.close();
	stdIn.close();
	echoSocket.close();
    }
}

