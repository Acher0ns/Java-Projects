/**
 * Created for assignment 6.3
 * Defines a square in a board with a unique position
 * 
 * @author Kamron Cole
 */
package knights;

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
        return row ^ 7 + column ^ 13;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Square)) {
            return false;
        }

        Square other = (Square)(o);
        return this.row == other.row && this.column == other.column;
    }

    @Override
    public String toString() {
        return "("+ row + ", " + column + ")";
    }
}
