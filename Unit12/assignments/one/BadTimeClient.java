package assignments.one;

import java.io.IOException;
import java.net.Socket;

public class BadTimeClient extends SocketHandler {
    public BadTimeClient(Socket socket) throws IOException {
        super(socket);
    }

    public void getTime() {
        send("CAN_I_GET_UHHH_NUMBA_9?");
        System.out.println(read());
    }

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 13000);
        BadTimeClient proxy = new BadTimeClient(client);
        proxy.getTime();
    }
}
