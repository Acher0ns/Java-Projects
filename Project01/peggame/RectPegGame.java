package peggame;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Defines a Rectangular PegGame where the board is a Location array of arrays
 * @author Kamron Cole, Sierra Kennedy, Jack Audino
 */
public class RectPegGame implements PegGame {
    private final int rows;
    private final int cols;
    private Location[][] pegs;

    /**
     * Create a rectangular PegBoard
     * Fills PegBoard with pegs excepts for one location
     * @param rows number of rows
     * @param cols number of columns
     */
    public RectPegGame (int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.pegs = new Location[rows][cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (i == rows - 1 && j == cols -1) {
                    pegs[i][j] = new Location(i, j, false);
                } else {
                    pegs[i][j] = new Location(i, j, true);
                }
            }
        }
    }

    /**
     * Create a rectangular PegBoard
     * @param rows number of rows
     * @param cols number of columns
     * @param pegs sets pegs (the board) to a predetermined board
     */
    public RectPegGame(int row, int col, Location[][] pegs) {
        this.rows = row;
        this.cols = col;
        this.pegs = pegs;
    }

    /**
     * Prints current pegboard as a string
     * [o] = peg in that location
     * [-] = no peg in that location
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                Location location = pegs[i][j];
                result += location.toString();
            }
            result += "\n";
        }
        return result;
    }
    
    /**
     * Makes a valid move. One peg is only be able to move over another.
     * Removes peg in the middle of to and from.
     * @author Jack Audino, Sierra Kennedy, Kamron Cole
     * @param move being attempted
     * @throws PegGameException if move is invalid
     */
    @Override
    public void makeMove(Move move) throws RuntimeException {
        int toRow = move.getTo().getRow();
        int toCol = move.getTo().getCol();
        int fromRow = move.getFrom().getRow();
        int fromCol = move.getFrom().getCol();

        if (toRow >= rows || toCol >= cols || fromRow >= rows || fromCol >= cols) {
            throw new PegGameException("That move is invalid.");
        }

        Location[] pegs = getPeg(move);
        if (validMove(move)) {
            pegs[0].setHasPeg(true); // to
            pegs[1].setHasPeg(false); // from
            pegs[2].setHasPeg(false); // mid
        } else {
            throw new PegGameException("That move is invalid.");
        }
    }
    
    /**
     * returns all of the possible (valid) moves
     * @author Kamron Cole
     * @return list of all possible moves
     */
    @Override
    public Collection<Move> getPossibleMoves() {
        List<Move> moves = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Location from = new Location(row, col);
                for (int rowTo = 0; rowTo < rows; rowTo++) {
                    for (int colTo = 0; colTo < cols; colTo++) {
                        Location to = new Location(rowTo, colTo);
                        Move move = new Move(from, to);
                        if (validMove(move)) {
                            moves.add(move);
                        }
                    }
                }
            }
        }
        return moves;
    }
    
    /**
     * @author Kamron Cole
     * @return whether game is Won, Stalemate, Not started, or In progress
     */
    @Override
    public GameState getGameState() {
        if (pegsLeft() == 1) {
            return GameState.WON;
        }
        
        if (pegsLeft() > 1 && getPossibleMoves().size() == 0) {
            return GameState.STALEMATE;
        }
        
        if (pegsLeft() == this.rows * this.cols - 1) {
            return GameState.NOT_STARTED;
        }
        return GameState.IN_PROGRESS;
    }

    /**
     * @author Sierra Kennedy, Kamron Cole
     * @return a deep copy of RectPegGame
     */
    @Override
    public RectPegGame deepCopy(){
        Location[][] newPegs = new Location[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Location locPeg = pegs[row][col];
                Location newLoc = new Location(locPeg.getRow(), locPeg.getCol(), locPeg.hasPeg());
                newPegs[row][col] = newLoc;
            }
        }
        return new RectPegGame(rows, cols, newPegs);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RectPegGame){
            RectPegGame other = (RectPegGame)obj;

            boolean pegsEqual = true;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (!this.pegs[row][col].equals(other.pegs[row][col])) {
                        pegsEqual = false;
                    }
                }
            }
            return (this.rows == other.rows && this.cols == other.cols && pegsEqual);
        }
        return false;
    }
    
    /**
     * A move is only valid if it is jumping to an empty location and is jumping over a peg. Only one peg can be jumped over at a time.
     * @author Sierra Kennedy, Jack Audino
     * @param move being attempted
     * @return whether or not move is valid
     */
    private boolean validMove(Move move)
    {
        int toRow = move.getTo().getRow();
        int toCol = move.getTo().getCol();
        int fromRow = move.getFrom().getRow();
        int fromCol = move.getFrom().getCol();

        Location[] pegs = getPeg(move);
        Location to = pegs[0];
        Location from = pegs[1];
        Location mid = pegs[2];

        if (((toRow - fromRow) == 2 || (toRow - fromRow) == -2 || (toRow - fromRow) == 0) && ((toCol - fromCol) == 2 || (toCol - fromCol) == -2 || (toCol - fromCol) == 0 )) {
            if (to.hasPeg() == false && from.hasPeg() == true && mid.hasPeg() == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method to get the to peg, the from peg, and the average of the two,
     * which is the middle peg
     * @author Jack Audino
     * @param move
     */
    private Location[] getPeg(Move move) {
        Location[] pegs = new Location[3];
        pegs[0] = this.pegs[move.getTo().getRow()][move.getTo().getCol()];
        pegs[1] = this.pegs[move.getFrom().getRow()][move.getFrom().getCol()];
        int midRow = (move.getTo().getRow() + move.getFrom().getRow()) / 2;
        int midCol = (move.getTo().getCol() + move.getFrom().getCol()) / 2;
        pegs[2] = this.pegs[midRow][midCol];
        return pegs;
    }

    /**
     * Helper method for getGameState
     * @author Kamron Cole
     * @return number of pegs left in board
     */
    private int pegsLeft() {
        int pegsLeft = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pegs[row][col].hasPeg()) {
                    pegsLeft++;
                }
            }
        }
        return pegsLeft;
    }

    /**
     * Manual Test for RectPegGame
     * Prints the boardwith its GameState, makes a move and prints it again with its GameState
     */
    public static void main(String[] args) {
        RectPegGame rpb = new RectPegGame(4, 4);
        System.out.println(rpb.getGameState());
        System.out.println(rpb);
        Move m = new Move(new Location(1, 3), new Location(3,3));
        rpb.makeMove(m);
        System.out.println(rpb);
        System.out.println(rpb.getGameState());
    }
}
