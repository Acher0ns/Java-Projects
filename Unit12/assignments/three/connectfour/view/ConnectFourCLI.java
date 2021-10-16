package assignments.three.connectfour.view;

import java.util.Scanner;

import assignments.three.connectfour.model.ConnectFour;
import assignments.three.connectfour.model.ConnectFourException;

public class ConnectFourCLI {
    /**
     * Used when printing the board; labels the columns.
     */
    private static final String ROW_HEADER = "   0 1 2 3 4 5\n";

    /**
     * Used when printing the board; separates rows.
     */
    private static final String ROW_SEPARATOR = "  -------------\n";

    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        try(Scanner scanner = new Scanner(System.in)) {
            boolean sentinel = true;
            while(sentinel) {
                System.out.println(gameToString(game));
                System.out.println("It is the " + game.getCurrentPlayer() 
                    + " player's turn.");
                System.out.print(">> ");
                String[] command = scanner.nextLine().split(" ");
                switch(command[0]) {
                    case "quit":
                        sentinel = !areYouSure(scanner);
                        break;
                    case "restart":
                        if(areYouSure(scanner)) {
                            game.reset();
                        }
                        break;
                    case "move":
                        move(command, game);
                        break;
                    case "help":
                        help();
                        break;
                    default:
                        invalid(command);
                        break;
                }
            }
            System.out.println("Good bye!");
        }
    }

    /**
     * Prints a help message with the available commands.
     */
    private static void help() {
        System.out.println("Available commands: ");
        System.out.println("  help - displays this message");
        System.out.println("  move C - makes a move for the current player");
        System.out.println("  quit - quits the game");
        System.out.println("  restart - restarts the game");
        System.out.println();
    }

    /**
     * Prompts the user to ask if they are sure.
     * @param scanner The scanner used to read the user response.
     * @return True if the user indicated that they are sure.
     */
    private static boolean areYouSure(Scanner scanner) {
        System.out.print("Are you sure? (y/n): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("y");
    }

    /**
     * Attempts to make a move.
     *
     * @param command The split command entered by the user.
     * @param game The ConnectFour game on which the move will be made.
     */
    private static void move(String[] command, ConnectFour game) {
        if(command.length != 2) {
            System.err.println("Invalid move!");
        } else {
            try {
                int col = Integer.parseInt(command[1]);
                game.move(col);
            } catch(ConnectFourException cfe) {
                System.out.println(cfe.getMessage());
            } catch(NumberFormatException nfe) {
                System.out.println("Column must be an integer.");
            }
        }
    }

    /**
     * Displays an invalid command message.
     *
     * @param command The invalid command.
     */
    private static void invalid(String[] command) {
        System.out.println("Invalid command: " + command[0]);
    }

    /**
     * Returns a {@link String} representation of the game suitable for
     * printing.
     *
     * @return A {@link String} representation of the game.
     */
    private static String gameToString(ConnectFour board) {
        // using a string builder is more efficient than concatenation
        // (it also makes the IntelliJ warnings go away)
        StringBuilder builder = new StringBuilder(ROW_HEADER);
        builder.append(ROW_SEPARATOR);
        int column = 0;
        for(int col=0; col<ConnectFour.COLS; col++) {
            builder.append(column++);
            builder.append(" ");
            for(int row=0; row<ConnectFour.ROWS; row++) {
                builder.append("|");
                switch(board.getChecker(row, col)) {
                    case NONE:
                        builder.append(" ");
                        break;
                    case BLACK:
                        builder.append("B");
                        break;
                    case RED:
                        builder.append("R");
                        break;
                }
            }
            builder.append("|\n");
            builder.append(ROW_SEPARATOR);
        }

        return builder.toString();
    }
}
