package assignments.two;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TinyWebServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket tinyWebServer = new ServerSocket(8080)) {
            Socket client = tinyWebServer.accept();
                
            Scanner in = new Scanner(client.getInputStream());
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                
            System.out.println("Response: ");
            for (int i = 0; i < 3; i++) {
                System.out.println("  Line " + (i + 1) + ": " + in.nextLine());
            }

            out.println("HTTP/1.1 200 OK\r\n"
            + "Content-Length: 12\r\n"
            + "Content-Type: text/plain; charset=utf-8\r\n\r\n"
            + "Hello World!\r\n");
        }
    }
}
