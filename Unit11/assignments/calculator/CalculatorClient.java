import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Runs a client that takes a binary operation as input and sends it to a calculator hosted on a server via UDP
 */
public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();

        Scanner in = new Scanner (System.in);

        // Get the first operation 
        System.out.print ("Enter math operation (or nothing to exit): ");
        String input = in.nextLine ();
 
        // As long as the user keeps entering operations, keep doing math.
        while (!input.equals(" ")) {
            String[] tokens = input.strip().split(" ");

            String result;
            // Check to make sure it is a binary operation
            if (tokens.length < 3) {
                result = "error bad request";
            } else {
                DatagramPacket operation = new DatagramPacket(
                    input.strip().getBytes(),
                    input.strip().length(),
                    InetAddress.getByName("localhost"),
                    12400
                );

                client.send(operation);

                DatagramPacket incoming = new DatagramPacket(new byte[1024], 1024);
                client.receive(incoming);
                result = new String(incoming.getData(), 0, incoming.getLength());
            }

            // Let the user know the result.
            System.out.print(result + " ");

            /**
             * If the response was a number, use that number as the first value
             * in a new binary operation. If it was anything else, expect
             * a new 3 piece binary operation.
             */
            try {
                if (Double.isNaN (Double.parseDouble(result))) {
                    throw new NumberFormatException ();
                }
            } catch (NumberFormatException nfe) { 
                // Didn't get a numberic response, throw away the result
                result = "";
                System.out.println ();
            }
            input = in.nextLine();
            // Add the new operation to the old result to form 
            // a complete operation. I.E. result was 5, user entered
            // * 7, the new input would be "5 * 7".
            input = result + " " + input;
        }

        // All done, clean up any streams.
        client.close();
        in.close ();
    }
}
