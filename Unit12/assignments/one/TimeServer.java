package assignments.one;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(13000);
        try {
            while (true) {
                System.out.println("Waiting for connection...");
                Socket socket = server.accept();
                new Thread(new ConnectionHandler(socket)).start();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        server.close();
    }
}
