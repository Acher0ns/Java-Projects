package peggame;

/**
 * Defines a move on a PegGame board
 * @author Kamron Cole, Jack Audino
 */
public class Move {
    private final Location from;
    private final Location to;

    public Move (Location from, Location to) {
        this.from = from;
        this.to = to;
    }
    
    /**
     * @author Jack Audino, Kamron Cole
     */
    @Override
    public String toString() {
        return "Move from ( " + from.getRow() + ", " + from.getCol() + " )" + " to " + "( " + to.getRow() + ", " + to.getCol() + " )";
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

}
