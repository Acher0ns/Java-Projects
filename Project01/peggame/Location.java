package peggame;

/**
 * Defines a location on a PegGame board that either has a peg or is empty
 * @author Kamron Cole, Jack Audino
 */
public class Location {
    private final int row;
    private final int col;
    private boolean hasPeg;

    public Location (int row, int col) {
        this.row = row;
        this.col = col;
        this.hasPeg = false;
    }

    public Location (int row, int col, boolean hasPeg) {
        this.row = row;
        this.col = col;
        this.hasPeg = hasPeg;
    }

    @Override
    public String toString() {
        return hasPeg ? "[o]" : "[-]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location)) {
            return false;
        }

        Location other = (Location)(obj);
        return this.row == other.row && this.col == other.col && this.hasPeg == other.hasPeg;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    /**
     * @author Jack Audino
     */
    public boolean hasPeg() {
        return hasPeg;
    }
    
    /**
     * @author Jack Audino
     */
    public void setHasPeg(boolean hasPeg) {
        this.hasPeg = hasPeg;
    }

}
