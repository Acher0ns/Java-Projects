package activities.echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException{
        Socket clientSocket = new Socket("localhost", 3333);

        Scanner in = new Scanner(clientSocket.getInputStream());
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Hello!");

        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
        
        clientSocket.close();
    }
}
