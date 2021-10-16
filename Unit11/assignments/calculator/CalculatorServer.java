import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * Runs a server that takes binary operations in via UDP and sends back the calculated result
 */
public class CalculatorServer {
    public static void main(String[] args) throws IOException {
        List<BinaryOperation> OPERATIONS = new ArrayList<>(7);
        OPERATIONS.add (new Addition());
        OPERATIONS.add (new Subtraction());
        OPERATIONS.add (new Multiplication());
        OPERATIONS.add (new Division());
        OPERATIONS.add (new FloorDivision());
        OPERATIONS.add (new Exponent());
        Calculator calculator = new Calculator(OPERATIONS);

        DatagramSocket server = new DatagramSocket(12400);

        try {
            while (true) {
                DatagramPacket incoming = new DatagramPacket(
                    new byte[1024],
                    1024
                );
                server.receive(incoming);
                String incomingStr = new String(incoming.getData(), 0, incoming.getLength());
                String[] tokens = incomingStr.strip().split(" ");
    
                float operand1 = Float.parseFloat(tokens[0]);
                float operand2 = Float.parseFloat(tokens[2]);
                // Get the result as a String
                String result = "" + calculator.calculate(tokens[1], operand1, operand2);
    
                DatagramPacket outgoing = new DatagramPacket(
                    result.getBytes(),
                    result.length(),
                    incoming.getAddress(),
                    incoming.getPort()
                );
    
                server.send(outgoing);
            }
        } catch (Exception e) {
            server.close();
        }
    }
}
