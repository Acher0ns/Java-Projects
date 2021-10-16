package activities.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket sock = new DatagramSocket();
        String outMessage = "Here's my message over UDP";
        
        DatagramPacket outgoing = new DatagramPacket(outMessage.getBytes(), outMessage.length(),
        InetAddress.getByName("localhost"), 3333);
        
        System.out.println("Sending message over UDP");
        sock.send(outgoing);

        DatagramPacket incoming = new DatagramPacket(new byte[1024], 1024);
        sock.receive(incoming);

        String inMessage = new String(incoming.getData(), 0, incoming.getLength());
        System.out.println("Recieved: " + inMessage);
        sock.close();
    }
}
