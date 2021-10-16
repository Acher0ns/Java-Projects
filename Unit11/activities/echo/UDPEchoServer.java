package activities.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket sock = new DatagramSocket(3333);

        DatagramPacket incoming = new DatagramPacket(new byte[1024], 1024);
        sock.receive(incoming);

        String message = new String(incoming.getData(), 0, incoming.getLength());
        System.out.println("Recieved: " + message);

        DatagramPacket outgoing = new DatagramPacket(incoming.getData(), incoming.getLength(), incoming.getAddress(), 
            incoming.getPort());
        sock.send(outgoing);
        sock.close();
    }
}
