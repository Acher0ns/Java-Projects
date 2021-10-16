import java.net.Socket;
import java.util.Scanner;

public class pss2 {
    /**
     * Problem Solving 1
     * 
     * Description:                 Message Format:
     * 
     * ----------------------[ Client-to-Server ]----------------------
     * User 'Jodi' connects         "CONNECT"
     * to the server
     * 
     * User 'Joe' broadcast         "Hi!"
     * "Hi!" to server
     * 
     * User 'Janet' disconnects     QUIT
     * from the server
     * 
     * ----------------------[ Server-to-Client ]----------------------
     * Server response to Jodi's    "Connected"
     * connection request
     * 
     * Server sends Joe's message   "Joe: Hi!"
     * to any connected Client
     * 
     * Server responds to Janet's   "Closing"
     * disconnection
     */



    /**
     * Problem Solving 2
     * 
     * Duplexer dup = new Duplexer(socket);
     * dup.send(message);
     * 
     * Duplexer dup = new Duplexer(clientSocket);
     * String message = dup.read();
     */



    /**
     * Problem Solving 3
     * 
     * Duplexer dup = new Duplexer(clientSocket);
     * dup.send(message);
     * 
     * Duplexer dup = new Duplexer(socket);
     * String message = dup.read();
     */



    /**
     * Problem Solving 4
     */

     @SuppressWarnings("unused")
    private Runnable runnable = new Runnable(){
        private Socket sock;

        @Override
        public void run() {
            try {
                Scanner in = new Scanner(sock.getInputStream());
                String message = null;
                while (true) {
                    message = in.nextLine();
                    if (message.equals("Closing")) {
                        break;
                    }
                    System.out.println(message);
                }
                in.close();
            } catch (Exception e) {}
        };
    };
}
