/**
 * Created for assignment 6.3
 * Contains JUnit tests for Board Class
 * 
 * @author Kamron Cole
 */
package knights;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class BoardTest {
    @Test
    public void boardConstructor(){
        Board b = new Board(9, 10);

        assertEquals(b.getRows(), 9);
        assertEquals(b.getColumns(), 10);
    }

    @Test
    public void isInsideTest() {
        Board b = new Board(3, 3);

        assertTrue(b.isInside(0, 0));
        assertTrue(b.isInside(0, 1));
        assertTrue(b.isInside(0, 2));
        assertTrue(b.isInside(2, 2));

        assertFalse(b.isInside(0, 4));
        assertFalse(b.isInside(-1, 4));
        assertFalse(b.isInside(10, 4));
        assertFalse(b.isInside(0, -1));
    }
}