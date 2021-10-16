package assignments.one;

import java.io.IOException;
import java.net.Socket;

public class ClientProxy extends SocketHandler {
    public ClientProxy(Socket socket) throws IOException {
        super(socket);
    }

    public void getTime() {
        send("TIME");
        System.out.println(read());
    }
}
