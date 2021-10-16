import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 * TinyChatServer that allows clients to connect and send/read messages from eachother
 * Allows multiple connections
 * Runs until server closed
 */
public class TinyChatServer {
    // List of clients current connected to the chat server
    public static List<Duplexer> CLIENTS = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        // Create the server
        ServerSocket server = new ServerSocket(12410);
        try {
            while (true) {
                // Take a connection from a client
                Socket client = server.accept();
                // Pass connection to handler
                TinyChatHandler handler = new TinyChatHandler(client);
                // Add handler to client list
                CLIENTS.add(handler);
                // Start handler
                new Thread(handler).start();
                // Restart to listen for new connection
            }  
        } catch (Exception e) {}
        // Close server when done
        server.close();
    }
}
