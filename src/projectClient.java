import java.io.*;
import java.net.*;

public class projectClient {
    private Socket socket;
    private BufferedReader fromServer; // gets the data from the server
    private PrintWriter toServer; // sends data to teh server

    public projectClient(String serverAddress, int serverPort) {
        try {
            // Connect to the server
            socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to the server.");

            // Initialize input and output streams
            fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            toServer = new PrintWriter(socket.getOutputStream(), true);

            // Start a separate thread to handle incoming messages
            Thread messageReceiver = new Thread(this::receiveMessages);
            messageReceiver.start();

            // Start reading user input
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while ((message = userInput.readLine()) != null) {
                sendMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void sendMessage(String message) {
        // Send message to the server
        toServer.println(message);
    }

    private void receiveMessages() {
        try {
            String message;
            while ((message = fromServer.readLine()) != null) {
                System.out.println("Received: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            if (socket != null) {
                socket.close();
            }
            if (fromServer != null) {
                fromServer.close();
            }
            if (fromServer != null) {
                fromServer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Usage: java ChatClient <server_address> <server_port>
        if (args.length != 2) {
            System.out.println("Usage: java ChatClient <server_address> <server_port>");
            System.exit(1);
        }

        String serverAddress = args[0];
        int serverPort = Integer.parseInt(args[1]);

        new projectClient(serverAddress, serverPort);
    }
}
