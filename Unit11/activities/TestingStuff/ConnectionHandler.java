import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionHandler implements Runnable {
    private int id;
    private Socket socket;

    public ConnectionHandler(int id, Socket socket) {
        this.id = id;
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "Socket #" + id;
    }

    @Override
    public void run() {
        try {
            System.out.println(this + " being handled...");
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            out.println("Welcome " + socket.getInetAddress() + "!");  
            char[] animationChars = new char[]{'|', '/', '-', '\\'};
            for (int i = 0; i <= 100; i++) {
                out.print("Processing: " + i + "% " + animationChars[i % 4] + "\r");
                out.flush();
    
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
            }
            out.println("Processing: Done!          ");
            
            Thread.sleep(1000);
            out.println("Hope you enjoyed your stay!");
            out.println("Goodbye! (sock, out).");
            System.out.println(this + " done!");

            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
            socket.close();
        } catch (Exception e) {}
    }
}
