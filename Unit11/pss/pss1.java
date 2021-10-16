import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Team Members:
 * Jack Audino
 * Sierra Kennedy
 * Kamron COle
 */
public class pss1 {
    /**
     * Problem Solving 1
     * 
     * 1. 13 is returned
     * 
     * 2. takes previous answer, subracts 4, returns 9
     * 
     * 3. takes previous answer, multiplies by 8, returns 72
     * 
     * 4. 
     *   a. User needs to enter three values
     *   b. Calculate the result
     *   c. Use result as first value in next binary operation
     *   d. repeate from step 2
     */



    /**
     * Problem Solving 2
     * 
     * Client Lines:
     * 2-6, 13-14
     * 
     * Server Lines:
     * 1, 7-12
     */
     
     
     
    /**
     * Problem Solving 3
     */

    public static class Recieve {
        public static void main(String[] args) throws IOException {
            DatagramSocket sock = new DatagramSocket(12400);

            DatagramPacket incoming = new DatagramPacket(new byte[1024], 1024);
            sock.receive(incoming);
            // Do something with revieved packet
            sock.close();
        }
    }


    
    /**
     * Problem Solving 4
     */

    public static class Send {
        public static void main(String[] args) throws IOException {
            DatagramSocket sock = new DatagramSocket();

            byte[] message = "I Love Java".getBytes();
            DatagramPacket outgoing = new DatagramPacket(
                message,
                message.length,
                InetAddress.getByName("se.rit.edu"),
                42100
            );

            sock.send(outgoing);
            sock.close();
        }
    }
}
