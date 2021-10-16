package activities.echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client Connected");

        Scanner in = new Scanner(clientSocket.getInputStream());
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String message = in.nextLine();
        out.println(message);

        clientSocket.close();
        serverSocket.close();
    }
}
