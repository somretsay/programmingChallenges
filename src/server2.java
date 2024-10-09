import java.net.*;
import java.io.*;

public class server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 80.");
            System.exit(1);
        }
        
        System.out.println("Waiting for connection...");
        try (Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) 
             {

            System.out.println("Connection successful");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                out.println(inputLine); // Echo back any message from client
                
                if (inputLine.equalsIgnoreCase("aloha")) {
                    out.println("Welcome"); // Send "Welcome" after receiving "aloha"
                    System.out.println("Server: Welcome"); // Output "Welcome" on the server side
                    System.out.println("Server: Please send any files now"); // Additional message
                    continue; // Continue listening for more input from the client
                }
                
                if (inputLine.equalsIgnoreCase("bye")) {
                    break; // Break out of the loop if client sends "bye"
                }
            }
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        
        serverSocket.close();
    }
}

