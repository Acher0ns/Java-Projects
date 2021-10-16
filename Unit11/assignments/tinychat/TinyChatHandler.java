import java.io.IOException;
import java.net.Socket;

/**
 * Threadable Duplexer that handles connections to the chat server from the server side.
 * Dictates how the server communicates with the client(s).
 */
public class TinyChatHandler extends Duplexer implements Runnable {
    private String name;

    public TinyChatHandler(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void run() {
        String request = "";
        // If QUIT is recieved stop loop
        while(!request.equals("QUIT")) {
            // Get request
            request = read();
            // Print request to server
            System.out.println("RECV: " + request);
            String response = "";
            // Split request on space only twice
            String[] tokens = request.split(" ", 2);
            switch(tokens[0]) {
                // If QUIT is recieved, send closing to the user, let everyone else know they left, remove them from connected clients list
                case "QUIT":
                    send("Closing");
                    response = "[Server]: " + name + " disconnected.";
                    TinyChatServer.CLIENTS.remove(this);
                    break;
                // If CONNECT is recieved, get their name, send connected to the user, let everyone else know they connected
                case "CONNECT":
                    send("Connected");
                    name = tokens[1];
                    response = "[Server]: " + name + " connected.";
                    break;
                // If MESSAGE is recieved, send name + message to everyone on the server
                case "MESSAGE":
                    response = "[" + name + "]: " + tokens[1];
                    break;
                default:
                    continue;
            }
            // Output server's response to console
            System.out.println("SEND: " + response);
            sendAll(response);
        }

        try {
            close();  
        } catch (IOException e) {} 
    }

    /**
     * Sends a message to all other clients connected to the server
     * @param message to send
     */
    public void sendAll(String message) {
        for (Duplexer client : TinyChatServer.CLIENTS) {
            if (client == this) {
                continue;
            }

            client.send(message);
        }
    }
}
