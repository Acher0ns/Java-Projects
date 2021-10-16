import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Duplexer {
    private Socket socket;
    private Scanner in;
    private PrintWriter out;

    public Duplexer(Socket socket) throws IOException {
        this.socket = socket;
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void close() throws IOException {
        socket.close();
        out.close();
        in.close();
    }

    public void send(String message) {
        out.println(message);
    }

    public String read() {
        if (in.hasNextLine()) {
            return in.nextLine();  
        }
        return null;
    }
}
