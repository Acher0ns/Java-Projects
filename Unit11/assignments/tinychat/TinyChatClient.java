import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * TinyChatClient that connects to a TinyChatServer with a given username.
 * Able to send messages between other clients on the server.
 * typing "quit" closes the connection
 */
public class TinyChatClient {
    public static void main(String[] args) throws IOException {
        // Used to grab local user input
        Scanner in = new Scanner(System.in);

        // Set client's username
        System.out.print("Enter your username: ");
        String name = in.nextLine();

        // Attempt to connect with the local server on port 12410
        Socket socket = new Socket("localhost", 12410);
        // Creates proxy duplexer with given socket
        TinyChatProxy proxy = new TinyChatProxy(socket);

        // Allows client to listen for messages coming from the server while program waits for client's input
        Thread listener = new Thread(() -> {
            while (true) {
                try {
                    String message = proxy.read();
                    if (message != null) {
                        System.out.println(message);
                    }
                } catch (Exception e) {
                    break;
                }
            }     
        });
        listener.start();

        proxy.connect(name);

        // Allows the user to send messages until they input "quit"
        // Cannot send empty strings
        while (true) {
            String message = in.nextLine();
            if (message.toLowerCase().equals("quit")) {
                proxy.quit();
                break;
            }
            
            if (message == null || message.equals("")) {
                continue;
            }
            proxy.sendMessage(message);
        }

        // Close Scanner for local input
        in.close();
    }
}
