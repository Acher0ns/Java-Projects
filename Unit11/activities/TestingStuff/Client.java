import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
// import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    private int id;
    private String serverAddress;
    private int serverPort;

    public Client (int id, String serverAddress, int serverPort) {
        this.id = id;
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    @Override
    public String toString() {
        return "Client #" + id + ": ";
    }

    @Override
    public void run() {
        try {
            Socket sock = new Socket(serverAddress, serverPort);

            // PrintWriter out = new PrintWriter(sock.getOutputStream(), true);

            File logFile = new File("activities/TestingStuff/logs/Client-" + id + ".log");
            if (logFile.createNewFile() || logFile.exists()) {
                FileWriter writer = new FileWriter(logFile);
                InputStream stream = sock.getInputStream();
                Scanner scanner = new Scanner(stream);
                while (scanner.hasNextLine() && !sock.isClosed()) {
                    String message = scanner.nextLine() + "\n";
                    writer.append(message);
                    writer.flush();
                }
                writer.close();
                scanner.close();
                sock.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String serverAddress = "192.168.1.5";
        int serverPort = 3333;
        for (int i = 1; i <= 5; i++) {
            Client client = new Client(i, serverAddress, serverPort);
            Thread thread = new Thread(client);
            thread.start();
        }
    }
}
