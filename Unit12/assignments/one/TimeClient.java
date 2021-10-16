package assignments.one;

import java.io.IOException;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 13000);
        ClientProxy proxy = new ClientProxy(client);
        proxy.getTime();
        client.close();
    }
}
