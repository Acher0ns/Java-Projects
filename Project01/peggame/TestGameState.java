package peggame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.platform.commons.annotation.Testable;
import org.junit.Test;

/**
 * Simple JUnit tests for GameState enum
 * @author Jack Audino
 */
@Testable
public class TestGameState {
    @Test
    public void testToString() {
        GameState g = GameState.NOT_STARTED;
        String expected = "Not Started";
        String actual = g.toString();

        assertEquals(expected, actual);
    }
}
