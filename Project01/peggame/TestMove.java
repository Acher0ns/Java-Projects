package peggame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.platform.commons.annotation.Testable;
import org.junit.Test;

/**
 * Simple JUnit tests for Move
 * @author Sierra Kennedy
 */
@Testable
public class TestMove {
    @Test
    public void testGetFrom() {
        Location to = new Location(4, 4);
        Location from = new Location(2, 2);
        Move move = new Move(from, to);

        Location from2 = move.getFrom();
        int fromRow = from2.getRow();
        int fromCol = from2.getCol();

        int fromRowActual = 2;
        int fromColActual = 2;

        assertEquals(fromRow, fromRowActual);
        assertEquals(fromCol, fromColActual);
    }

    @Test
    public void testGetTo() {
        Location to = new Location(4, 4);
        Location from = new Location(2, 2);
        Move move = new Move(from, to);

        Location to2 = move.getTo();
        int toRow = to2.getRow();
        int toCol = to2.getCol();

        int toRowActual = 4;
        int toColActual = 4;

        assertEquals(toRow, toRowActual);
        assertEquals(toCol, toColActual);
    }
}
