import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private final int id;
    private final int listenPort;
    private ServerSocket serverSocket;

    private int connections = 0;

    public Server (int id, int listenPort) {
        this.id = id;
        this.listenPort = listenPort;
        try {
            this.serverSocket = new ServerSocket(listenPort);
        } catch (Exception e) {}
    }

    @Override
    public String toString() {
        return "Server[id=" + this.id + ", listenPort=" + listenPort + "]";
    }

    @Override
    public void run() {
        System.out.println("Server (" + id + ") started listening on port " + this.listenPort);
        while (true) {
            try {
                System.out.println("Waiting for a connection...");
                Socket clientSocket = this.serverSocket.accept();
                connections++;
                System.out.println("Connection (" + this.connections + ") Established.");
                Runnable connectionHandler = new ConnectionHandler(connections, clientSocket);
                new Thread(connectionHandler).start();
            } catch (IOException ioe) {}
        }
    }

    public static void main(String[] args) {
        Server server = new Server(1, 3333);
        Thread thread = new Thread(server);
        thread.start();
    }
}
