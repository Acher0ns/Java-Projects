package activities;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connector {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("tony-audi.com", 12407);
        System.out.println(sock);
        PrintWriter pw = new PrintWriter(sock.getOutputStream());
        pw.println("Kamron Cole");
        pw.flush();
        
        InputStream stream = sock.getInputStream();
        Scanner sc = new Scanner(stream);
        while (sc.hasNext()) {
            String message = sc.next();
            System.out.println(message);
        }
        sc.close();
        pw.close();
        sock.close();
    }
}
