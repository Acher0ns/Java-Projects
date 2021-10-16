package peggame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.platform.commons.annotation.Testable;
import org.junit.Test;

/**
 * Simple JUnit tests for Location
 * @author Jack Audino, Kamron Cole
 */
@Testable
public class TestLocation {
    @Test
    public void testConstructor1() {
        Location l = new Location(5, 6);
        assertEquals(5, l.getRow());
        assertEquals(6, l.getCol());
        assertEquals(false, l.hasPeg());
    }

    @Test
    public void testConstructor2() {
        Location l = new Location(1, 10, true);
        assertEquals(1, l.getRow());
        assertEquals(10, l.getCol());
        assertEquals(true, l.hasPeg());
    }

    @Test
    public void testGetRow() {
        Location l = new Location(5, 6);
        int expected = 5;
        int actual = l.getRow();

        assertEquals(expected, actual);
    }

    @Test 
    public void testGetCol() {
        Location l = new Location(5, 6);
        int expected = 6;
        int actual = l.getCol();

        assertEquals(expected, actual);
    }
}
