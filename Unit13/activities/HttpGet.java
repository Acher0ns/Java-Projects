package activities;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpGet {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("npr.org", 80);
        String request = "GET / HTTP/1.1\r\n" +
            "Host: www.npr.org\r\n" +
            "Connection: close\r\n\r\n";

        OutputStream out = sock.getOutputStream();
        out.write(request.getBytes());
        out.flush();

        InputStream in = sock.getInputStream();
        byte[] buf = new byte[2048];
        int n;
        while ((n = in.read(buf)) > 0) {
            String response = new String(buf, 0, n);
            System.out.println(response);
        }
        sock.close();
    }
}
