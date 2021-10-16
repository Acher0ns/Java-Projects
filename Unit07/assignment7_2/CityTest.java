package assignment7_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class CityTest {
    @Test
    public void testMake() {
        City city = new City("Painted Post", "NY", 42.1620, 77.0941);
        City city2 = new City("Nowhere", "MN", 42.1620, 77.0941);
        assertEquals("Painted Post, NY", city.toString());
        assertTrue(city.equals(city2));
        assertTrue(city.hashCode() == city2.hashCode());
    }

    @Test
    public void testDistance() {
        City PP = new City("Painted Post", "NY", 42, 42);
        City COR = new City("Corning", "NY", 42, 45);
        assertEquals(3, PP.distanceFrom(COR));
    }
}
