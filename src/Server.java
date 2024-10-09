import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(2345);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 80.");
            System.exit(1);
    }
        
        System.out.println("Waiting for connection...");
        try (Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //from server, in is from the client
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) 
             {

            System.out.println("Connection successful");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                out.println(inputLine); // Echo back any message from client
                if (inputLine.equalsIgnoreCase("Bye")) {
                    break; // Break out of the loop if client sends "Bye"
                }
                if (inputLine.equalsIgnoreCase("aloha")) {
                    out.println("Welcome"); // Send "Welcome" after receiving "aloha"
                    System.out.println("Server: Welcome, please send any files now");
                    
                    break; // Break out of the loop after sending "Welcome"
                }
                
            }


        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        
        serverSocket.close();
    }
}
