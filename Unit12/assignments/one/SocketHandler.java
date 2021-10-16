package assignments.one;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketHandler {
    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    
    public SocketHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new Scanner(socket.getInputStream());
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public String read() {
        if (in.hasNextLine()) {
            return in.nextLine();
        }
        return null;
    }

    public void send(String message) {
        out.println(message);
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();

    }
}
