package peggame;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Defines a Triangular PegGame where the board is a Location array of arrays
 * @author Sierra Kennedy, Kamron Cole, Jack Audino
 */
public class TriPegGame implements PegGame {
    private final int rows;
    private int size;
    private Location[][] pegs;

    /**
     * Create a tru PegBoard
     * Fills PegBoard with pegs excepts for one location
     * @param rows number of rows
     */
    public TriPegGame (int rows) {
        this.rows = rows;
        this.pegs = new Location[rows][];
        this.size = 0;
        for (int row = 0; row < rows; row++) {
            pegs[row] = new Location[row + 1];
            for (int col = 0; col <= row; col++) {
                Location location;
                if (row == 0) {
                    location = new Location(row, col, false);
                } else {
                    location = new Location(row, col, true);
                }
                pegs[row][col] = location;
                this.size++;
            }
        }
    }

    /**
     * Create a triangluar PegBoard
     * @param rows number of rows
     * @param pegs sets pegs (the board) to a predetermined board
     */
    public TriPegGame (int rows, Location[][] pegs) {
        this.size = 0;
        for (Location[] loc : pegs) {
            size += loc.length;
        }
        this.rows = rows;
        this.pegs = pegs;
    }

    /**
     * Prints current pegboard as a string in the format of an isosceles triangle
     * [o] = peg in that location
     * [-] = no peg in that location
     */
    @Override
    public String toString() {
        int ctr = this.rows;
        String result = "";
        for (int row = 0; row < rows; row++) {
            for (int space = ctr - 1; space > 0; space--) {
                result += "  ";
            }
            ctr --;
            for (int col = 0; col < pegs[row].length; col++) {
                result += pegs[row][col] + " ";
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
    public void makeMove(Move move) throws PegGameException {
        int toRow = move.getTo().getRow();
        int toCol = move.getTo().getCol();
        int fromRow = move.getFrom().getRow();
        int fromCol = move.getFrom().getCol();

        if (toRow >= rows || toCol >= pegs[toRow].length || fromRow >= rows || fromCol >= pegs[fromRow].length) {
            throw new PegGameException("That move is invalid: " + move);
        }

        Location[] pegs = getPeg(move);
        if (validMove(move)) {
            pegs[0].setHasPeg(true); // to
            pegs[1].setHasPeg(false); // from
            pegs[2].setHasPeg(false); // mid
        } else {
            throw new PegGameException("That move is invalid: " + move);
        }
    }

    /**
     * returns all of the possible (valid) moves
     * @return list of all possible moves
     */
    @Override
    public Collection<Move> getPossibleMoves() {
        List<Move> moves = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < pegs[row].length; col++) {
                Location from = new Location(row, col);
                for (int rowTo = 0; rowTo < rows; rowTo++) {
                    for (int colTo = 0; colTo < pegs[rowTo].length; colTo++) {
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
        
        if (pegsLeft() == this.size - 1) {
            return GameState.NOT_STARTED;
        }
        return GameState.IN_PROGRESS;
    }

    /**
     * @return a deep copy of RectPegGame
     */
    @Override
    public TriPegGame deepCopy(){
        Location[][] newPegs = new Location[rows][];
        for (int row = 0; row < rows; row++) {
            newPegs[row] = new Location[row + 1];
            for (int col = 0; col <= row; col++) {
                Location locPeg = pegs[row][col];
                Location newLoc = new Location(locPeg.getRow(), locPeg.getCol(), locPeg.hasPeg());
                newPegs[row][col] = newLoc;
            }
        }
        
        return new TriPegGame(rows, newPegs);
    }

    /**
     * 2 TriPegGames are equal if their pegs arrays are equal and they have the same amount of rows
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TriPegGame) {
            TriPegGame other = (TriPegGame)obj;

            boolean pegsEqual = true;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < pegs[row].length; col++) {
                    if (!this.pegs[row][col].equals(other.pegs[row][col])) {
                        pegsEqual = false;
                    }
                }
            }
            return (this.rows == other.rows && pegsEqual);
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
     * @return number of pegs left in board
     */
    private int pegsLeft() {
        int pegsLeft = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < pegs[row].length; col++) {
                if (pegs[row][col].hasPeg()) {
                    pegsLeft++;
                }
            }
        }
        return pegsLeft;
    }

    /**
     * Manual Test for TriPegGame
     */
    public static void main(String[] args) {
        TriPegGame game = new TriPegGame(5);
        System.out.println(game.getPossibleMoves());
        System.out.println(game.toString());

        TriPegGame copy = game.deepCopy();
        System.out.println(copy.rows);
        System.out.println(copy);
    }
}
