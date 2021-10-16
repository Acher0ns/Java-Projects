package assignments.three.connectfour.model;

/**
 * Observer used to update ConnectFour GUI when a move is made
 */
public interface ConnectFourObserver {
    public void checkerChanged(ConnectFour connectFour, int column, int row);
}
