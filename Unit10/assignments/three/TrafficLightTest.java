package assignments.three;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import assignments.three.TrafficLight.Colour;

@Testable
public class TrafficLightTest {
    @Test
    public void testConstructor() {
        Object lock = new Object();
        TrafficLight northSouth = new TrafficLight("North/South", lock);

        assertTrue(northSouth.toString().contains("North/South"));
        assertEquals(Colour.RED, northSouth.getColour());
    }

    @Test
    public void testRunSorta() {
        Object lock = new Object();
        TrafficLight northSouth = new TrafficLight("North/South", lock);

        synchronized(lock) {
            Thread thread = new Thread(northSouth);
            thread.start();
            if (Thread.holdsLock(lock)) {
                assertTrue(true);
            } else {
                assertTrue(false);
            }
        }
    }
}
