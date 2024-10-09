import java.io.*;
import java.net.*;

public class client2 {
    public static void main(String[] args) throws IOException {
        String serverHostname = "localhost";
        if (args.length > 0)
            serverHostname = args[0];
        System.out.println("Attempting to connect to host " + serverHostname + " on port 12345.");
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            echoSocket = new Socket(serverHostname, 12345);
            out = new PrintWriter(echoSocket.getOutputStream(), true); //from user to server
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));//from server
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + serverHostname);
            System.exit(1);
        }
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.print("input: ");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            try {
                // Receive response from the server
                String response = in.readLine();
                System.out.println("Server: " + response); // Print server's response
                
                if (userInput.equalsIgnoreCase("bye")) {
                    System.out.println("Connection Closed!");
                    break;
                }
            } catch (IOException e) {
                System.out.println("Socket Closed!");
                break;
            }
            System.out.print("input: ");
        }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
