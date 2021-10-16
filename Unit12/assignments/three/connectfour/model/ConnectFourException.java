package assignments.three.connectfour.model;


/**
 * A custom exception thrown from any of the Connect Four classes if something
 * goes wrong.
 */
public class ConnectFourException extends Exception {
    /**
     * Convenience constructor to create a new {@link ConnectFourException}
     * with an error message.
     *
     * @param message The error message associated with the exception.
     */
    public ConnectFourException(String message) {
        super(message);
    }
}
