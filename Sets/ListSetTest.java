package set;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class ListSetTest {
    
    @Test
    public void TestListSetIterator () {
        // Setup
        int[] values = {1, 3, 5, 2, 3, 1};
        int expected = 4;

        // Invoke
        Set<Integer> set = new ListSet<> ();
        for (int value : values) {
            set.add (value);
        }
        int actual = set.size ();

        // Analysis
        assertEquals (expected, actual);
        assertTrue (set.contains (5));
        assertFalse (set.contains (4));
    }
}
