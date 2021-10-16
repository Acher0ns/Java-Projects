package peggame;

import java.util.Scanner;

import java.util.List;

/** 
 * A command line interface(CLI) that can be used for any PegGame
 * Allows the user to play a peg game through a command line
 * @author Sierra Kennedy, Kamron Cole, Jack Audino
 */
public class CommandLine 
{
    /**
     * Calls individual methods for the game using user input via the command line,
     * until the game is finished
     * @author Sierra Kennedy, Kamron Cole, Jack Audino
     * @param game being played
     */
    public static void playGame(PegGame game) {
        Scanner scan = new Scanner(System.in);
        while (game.getGameState() != GameState.STALEMATE && game.getGameState() != GameState.WON) {
            System.out.println(game.toString());
            System.out.print("Enter Command: ");
            String line = scan.nextLine();
            String[] command = line.split(" ");

            if(command[0].toLowerCase().equals("help")) {
                help();
            }

            if(command[0].toLowerCase().equals("move")) {
                move(command, game);
            }

            if(command[0].toLowerCase().equals("hint")) {
                hint(game);
            }

            if(command[0].toLowerCase().equals("solve")) {
                solve(game);
            }

            if(command[0].toLowerCase().equals("quit")) {
                System.out.println("Goodbye!");
                scan.close();
                break;
            }
        }

        if (game.getGameState() == GameState.WON) {
            System.out.println("You Win!");
        } else if (game.getGameState() == GameState.STALEMATE) {
            System.out.println("No more moves. It's a stalemate :(");
        }
        System.out.println(game.toString());
        System.out.println("Goodbye!");
        scan.close();
    }
    
    /**
     * Displays commands
     * @author Sierra Kennedy
     */
    private static void help() {
        System.out.println("Available commands:");
        System.out.println("  help - displays this message");
        System.out.println("  move r1 c1 r2 c2 - attempts to move a peg from r1 c1 to r2 c2 on the board.");
        System.out.println("  hint - displays an available move.");
        System.out.println("  solve - solves the game");
        System.out.println("  quit - quits the game");
        System.out.println();
    }

    /**
     * Calls the makeMove method from the PegGame interface, 
     * to attempt to make a move
     * @author Sierra Kennedy
     * @param command containing move from/to row/col
     * @param game being played
     */
    private static void move(String[] command, PegGame game) {
        if(command.length == 5) {
            int fromRow = Integer.parseInt(command[1]);
            int fromCol = Integer.parseInt(command[2]);
            int toRow = Integer.parseInt(command[3]);
            int toCol = Integer.parseInt(command[4]);
            Location from = new Location(fromRow, fromCol);
            Location to = new Location(toRow, toCol);
            Move move = new Move(from, to);

            try {
                game.makeMove(move);
            }
            catch (PegGameException pge) {
                System.out.println("Invalid move");
                System.out.println();
            }
            
        } else {
            System.out.println("Invalid input");
            System.out.println();
        }
    }

    /**
     * Randomly displays one of the possible moves
     * @author Jack Audino, Sierra Kennedy
     */
    private static void hint(PegGame game) {
        if(PegConfig.getSolution(game) == null) {
            System.out.println("There is no solution for the current game");
            return;
        }
        
        List<Move> moves = PegConfig.getSolution(game).getAllMoves();
        Move hint = moves.get(0);
        System.out.println("hint: " + hint.toString());
    }

    /**
     * Uses backtacker to solve the game being played.
     * Plays each move until solved.
     * If there is no solution then prints an error message but lets the player still play
     * @param game being played
     * @author Sierra Kennedy
     */
    private static void solve(PegGame game) {
        if(PegConfig.getSolution(game) == null) {
            System.out.println("There is no solution for the current game");
            return;
        }

        List<Move> moves = PegConfig.getSolution(game).getAllMoves();
        for(Move m : moves) {
            System.out.println(m.toString());
            game.makeMove(m);
            System.out.println(game);
        }
    }
}
