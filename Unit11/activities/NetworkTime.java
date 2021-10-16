package activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class NetworkTime {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("time.nist.gov", 13);
        InputStream stream = sock.getInputStream();
        Scanner sc = new Scanner(stream);
        while (sc.hasNext()) {
            String message = sc.next();
            System.out.println(message + " ");
        }
        sc.close();
        sock.close();
        System.out.println();
    }
}
