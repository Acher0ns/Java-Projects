import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GuessingGameServer extends Duplexer implements Runnable {
    public static final int SERVER_PORT = 3333;
    private GuessingGameImpl game;

    public GuessingGameServer(Socket socket) throws IOException {
        super(socket);
        this.game = new GuessingGameImpl();
    }

    @Override
    public void run() {
        String request = "";
        while(!request.equals("QUIT")) {
            request = read();
            System.out.println("RECV: " + request);
            String[] tokens = request.split(" ");

            String response = "";
            switch(tokens[0]) {
                case "QUIT":
                    game.quit();
                    response = "GAME_OVER";
                    break;
                case "RESTART":
                    game.restart();
                    response = "RESTARTED";
                    break;
                case "GUESS":
                    GuessResult res = game.guess(Integer.parseInt(tokens[1]));
                    response = res.toString();
                    break;
                default:
                    response = "ERROR: Unknown Command - " + request;
                    break;
            }
            System.out.println("SEND: " + response);
            send(response);
        }
        try {
            close();  
        } catch (IOException e) {}
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(SERVER_PORT);
        try {
            while (true) {
                System.out.println("Waiting for client...");
                Socket client = server.accept();
                GuessingGameServer gameServer = new GuessingGameServer(client);
                System.out.println("Starting the game.");
                new Thread(gameServer).start();
                // gameServer.run();
            }
        } catch (Exception e) {
            server.close();
        }
    }
}
