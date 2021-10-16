package activities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        Socket clientSocket = serverSocket.accept();
        System.out.println(clientSocket + " Connected");
        clientSocket.close();
        serverSocket.close();
    }
}
