import java.io.IOException;
import java.net.Socket;

/**
 * Duplexer that handles connections to the chat server from the client side.
 * Dictates how the client communicates with the server.
 */
public class TinyChatProxy extends Duplexer {
    public TinyChatProxy(Socket socket) throws IOException {
        super(socket);
    }

    /**
     * Attempts to close the duplexer and send QUIT request to the server
     */
    public void quit() {
        send("QUIT");
        
        try {
            close();
        } catch (IOException ioe) {
            System.out.println("Error closing proxy.");
        }
    }

    /**
     * Sends CONNECT message to the server with the desired username
     * @param username the user wants to connect as
     */
    public void connect(String username) {
        send("CONNECT " + username);
    }
    
    /**
     * Sends MESSAGE message to the server
     * @param message the user wants to send to everyone else on the server
     */
    public void sendMessage(String message) {
        send("MESSAGE " + message);
    }
}
