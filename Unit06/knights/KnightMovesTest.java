/**
 * Created for assignment 6.3
 * Contains JUnit tests for KnightMoves Class
 * 
 * @author Kamron Cole
 */
package knights;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class KnightMovesTest {
    @Test
    public void connectKnightMovesTest1() {
        Board b = new Board(8, 8);
        KnightMoves.connectAllKnightMoves(b);

        assertTrue(b.getSquares().connected(new Square(0, 0), new Square(1, 2)));
        assertTrue(b.getSquares().connected(new Square(0, 0), new Square(2, 1)));
    }

    @Test
    public void connectKnightMovesTest2() {
        Board b = new Board(10, 70);
        KnightMoves.connectAllKnightMoves(b);

        assertTrue(b.getSquares().connected(new Square(0, 0), new Square(1, 2)));
        assertTrue(b.getSquares().connected(new Square(0, 0), new Square(2, 1)));
    }

    @Test
    public void connectKnightMovesTest3() {
        Board b = new Board(5, 27);
        KnightMoves.connectAllKnightMoves(b);

        assertTrue(b.getSquares().connected(new Square(0, 0), new Square(1, 2)));
        assertTrue(b.getSquares().connected(new Square(0, 0), new Square(2, 1)));
    }

    @Test
    public void connectKnightMovesTest4Null() {
        Board b = new Board(3, 3);
        KnightMoves.connectAllKnightMoves(b);

        assertNull(b.getSquares().dfPath(new Square(1, 1), new Square(1, 2)));
        assertNull(b.getSquares().dfPath(new Square(1, 1), new Square(0, 0)));
        assertNull(b.getSquares().dfPath(new Square(1, 1), new Square(0, 1)));
        assertNull(b.getSquares().dfPath(new Square(1, 1), new Square(0, 2)));
        assertNull(b.getSquares().dfPath(new Square(1, 1), new Square(1, 10)));
    }
}
