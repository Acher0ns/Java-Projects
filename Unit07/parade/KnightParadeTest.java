package parade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import backtracker.Backtracker;
import backtracker.Configuration;

@Testable
public class KnightParadeTest {
    @Test
    public void testMake() {
        KnightParade np = new KnightParade(new Chessboard(8), 0, 0);

        assertTrue(np.isValid());
        assertFalse(np.isGoal());
        assertEquals(8, np.getSuccessors().size());
    }

    @Test
    public void testMakeInvalid() {
        KnightParade np = new KnightParade(new Chessboard(8), 10, 10);

        assertFalse(np.isValid());
        assertFalse(np.isGoal());
        assertEquals(8, np.getSuccessors().size());

        // np.getSuccessors().forEach(successor -> {assertFalse(successor.isValid());});
        for (Configuration successor : np.getSuccessors()) {
            assertFalse(successor.isValid());
        }
    }

    @Test
    public void testIsGoalValid() {
        KnightParade np = new KnightParade(new Chessboard(5), 4, 4);
        Backtracker bt = new Backtracker(false);
        Configuration solution = bt.solve(np);
        assertTrue(solution.isGoal() && solution.isValid());
    }

    @Test
    public void testIsGoalValidNull() {
        KnightParade np = new KnightParade(new Chessboard(4), 0, 0);
        Backtracker bt = new Backtracker(false);
        Configuration solution = bt.solve(np);
        assertNull(solution);
    }
}
