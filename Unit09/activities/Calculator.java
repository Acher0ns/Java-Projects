package activities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public interface Operation {
        public double execute(double left, double right);  
    }

    public static Operation getOperation (String operation) {
        if (operation.equals("+")) {
            return new Operation() {
                @Override
                public double execute(double left, double right) {
                    return left + right;
                }
            };
        }

        if (operation.equals("-")) {
            return (left, right) -> left - right;
        }

        if (operation.equals("*")) {
            return (left, right) -> left * right;
        }

        if (operation.equals("/")) {
            return (left, right) -> left / right;
        }

        if (operation.equals("^")) {
            return Math::pow;
        }
        throw new UnsupportedOperationException("Operation not supported: " + operation);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double left = 0.0;
        double right = 0.0;
        String opStr = null;
        while(true) {
            try {
                System.out.print("Enter x op y: ");
                left = input.nextDouble();
                opStr = input.next();
                right = input.nextDouble();

                Operation operation = getOperation(opStr);
                double answer = operation.execute(left, right);
                System.out.println(left + " " + opStr + " " + right + " = " + answer);
            } catch (InputMismatchException ime) {
                break;
            }
        }
        System.out.println("Goodbye!");
        input.close();
    }
}
