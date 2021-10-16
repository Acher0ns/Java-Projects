/**
 * Created for assignment 6.3
 * Prompts for a board size then a start and end position and will print the path to get from start to end with knight moves using BFS or DFS algorithms.
 * 
 * @author Kamron Cole
 */
package knights;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightMoves {
    /**
     * Connects all squares in a board with their neighbors that can be reached with a night move
     * @param board current board
     */
    public static void connectAllKnightMoves(Board board) {
        for (int col = 0; col < board.getColumns(); col++) {
            for (int row = 0; row < board.getRows(); row++) {
                connectKnightMove(board, new int[]{row, col});
            }
        }
    }

    /**
     * Connects a square with those that can be reached with a knight move ( at most 8 )
     * @param board current board
     * @param currentPos position of the starting square
     */
    private static void connectKnightMove(Board board, int[] currentPos) {
        int dx[] = { -1, 1, -1, 1, -2, 2, -2, 2 }; 
        int dy[] = { -2, -2, 2, 2, -1, -1, 1, 1 };
  
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < 8; i++) { 
            int row = currentPos[0];
            int col  = currentPos[1];
            row += dy[i]; 
            col += dx[i]; 
  
            if (board.isInside(row, col)) { 
                q.add(new int[]{row, col}); 
            } 
        }

        while (!q.isEmpty()) {
            int[] nextPos = q.remove();
            board.getSquares().connectUndirected(new Square(currentPos[0], currentPos[1]), new Square(nextPos[0], nextPos[1]));
        }
        System.out.println();
    }

    /**
     * Ask for user input of board size then repeatedly asks for start and end coordinates until "quit" is entered
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns (<rows> <columns>): ");

        int rows = 0;
        int cols = 0;

        boolean validInput = false;
        while (!validInput) {
            String[] rowCol = sc.nextLine().split(" ");
            try {
                rows = Integer.parseInt(rowCol[0]);
                cols = Integer.parseInt(rowCol[1]);

                if (rows < 3 || cols < 3) {
                    System.out.println("Board must have more than 3 rows and columns");
                    validInput = false;
                } else {
                    validInput = true;
                }
            } catch (Exception e) {
                System.out.println("Please enter 2 numbers separated by a space. ");
                validInput = false;
            }
        }

        Board board = new Board(rows, cols);
        connectAllKnightMoves(board);

        String input = "";
        while(input != "quit") {
            System.out.println("Enter the start and end position of the knight ( ​<row1> <col1> <row2> <col2> ): ");
            input = sc.nextLine();

            if (input.contains("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            String[] tokens = input.split(" ");

            if (tokens.length != 4) {
                System.out.println("Please enter 4 values separated by a space.");
                continue;
            }

            int startRow = 0;
            int startCol = 0;
            int endRow = 0;
            int endCol = 0;

            try {
                startRow = Integer.parseInt(tokens[0]);
                startCol = Integer.parseInt(tokens[1]);
                endRow = Integer.parseInt(tokens[2]);
                endCol = Integer.parseInt(tokens[3]);

                if (!board.isInside(startRow, startCol) || !board.isInside(endRow, endCol)) {
                    System.out.println("One or both of the entered positions is not on the board.");
                    continue;
                }

                System.out.println("DFS: " + board.getSquares().dfPath(new Square(startRow, startCol), new Square(endRow, endCol)));
                System.out.println();
                System.out.println("BFS: " + board.getSquares().bfPath(new Square(startRow, startCol), new Square(endRow, endCol)));
                System.out.println();
            } catch (Exception e) {
                System.out.println("Please enter 4 numbers each sepated by a space in the format '<row1> <col1> <row2> <col2>​.'");
            }
        }
        sc.close();
    }
}