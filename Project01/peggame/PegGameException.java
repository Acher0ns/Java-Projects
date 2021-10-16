package peggame;

/**
 * Thrown when an invalid move is attempted on a PegGame board
 * @author Sierra Kennedy
 */
public class PegGameException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PegGameException(String message) {
        super(message);
    }
}
