/**
 * Created for assignment 6.3
 * Defines a board made up of a grapgh of squares with a certain number of columns and rows
 * 
 * @author Kamron Cole
 */
package knights;

import graphs.AdjacencyGraph;
import graphs.Graph;

public class Board {
    private final int rows;
    private final int columns;
    private Graph<Square> squares = new AdjacencyGraph<>();

    public Board (int rows, int columns) {
        this.rows = rows;
        this.columns = columns;


        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows; row++) {
                this.squares.add(new Square(row, col));
            }
        }
    }

    public boolean isInside(int row, int col) 
    { 
        return this.squares.contains(new Square(row, col));
    } 

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Graph<Square> getSquares() {
        return squares;
    }
}
