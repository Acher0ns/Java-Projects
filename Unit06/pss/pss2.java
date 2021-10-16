package pss;

import java.util.Scanner;

import graphs.AdjacencyGraph;
import graphs.Graph;

/**
 * Problem Solving 1
 * 
 * First part saved as "pss2_PS1_1.png"
 * 
 * 1: row-2, col-1
 * 2: row-2, col+1
 * 3: row+2, col-1
 * 4: row+2, col+1
 * 5: row-1, col-2
 * 6: row-1, col+2
 * 7: row+1, col-2
 * 8: row+1, col+2
 */



/**
 * Problem Solving 2
 */
public class Square {
    private final int row;
    private final int column;

    public Square(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Square(String row, String col) {
        this(Integer.parseInt(row), Integer.parseInt(col));
    }

    @Override
    public int hashCode() {
        return row*7 + column*11;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Square)) {
            return false;
        }

        Square other = (Square)(o);
        return this.row == other.row && this.column == other.column;
    }
}



/**
 * Problem Solving 3
 */
public class pss2 {
    public static Graph<Square> makeBoard(int rows, int columns) {
        Graph<Square> board = new AdjacencyGraph<Square>();

        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows; row++) {
                board.add(new Square(row, col));
            }
        }
        return board;
    }




/**
 * Problem Solving 4
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board chessboard = new Board(8, 8);
        System.out.println("Enter the start and end coordinates: ");
        String coords = scanner.nextLine();
        String[] tokens = coords.split(" ");
        Square start = new Square(tokens[0], tokens[1]);
        Square end = new Square(tokens[2], tokens[3]);
        List<Square> dfPath = chessboard.dfPath(start, end);
        System.out.println(dfPath);
    }
}