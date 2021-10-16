package assignments.one;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class ConnectionHandler extends SocketHandler implements Runnable {
    public ConnectionHandler(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void run() {
        String request = read();
        if (request.equals("TIME")) {
            send(new Date().toString());
        } else {
            send("ERROR: Unknown request: " + request);
        }

        try {
            close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
