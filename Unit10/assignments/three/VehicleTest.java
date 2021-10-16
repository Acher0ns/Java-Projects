package assignments.three;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import assignments.three.TrafficLight.Colour;
import assignments.three.Vehicle.Direction;

@Testable
public class VehicleTest {
    @Test
    public void testConstructor() {
        Object lock = new Object();
        TrafficLight northSouth = new TrafficLight("North/South", lock);
        TrafficLight eastWest = new TrafficLight("East/West", lock);
        Intersection intersection = new Intersection(northSouth, eastWest);

        Vehicle vehicle = new Vehicle(1, Direction.NORTH, intersection);

        assertEquals(1, vehicle.getId());
        assertEquals(Direction.NORTH, vehicle.getDirection());
    }

    @Test
    public void testRun() {
        Object lock = new Object();
        TrafficLight northSouth = new TrafficLight("North/South", lock);
        TrafficLight eastWest = new TrafficLight("East/West", lock);
        Intersection intersection = new Intersection(northSouth, eastWest);

        Vehicle vehicle = new Vehicle(1, Direction.NORTH, intersection);

        assertEquals(1, vehicle.getId());
        assertEquals(Direction.NORTH, vehicle.getDirection());

        northSouth.setColour(Colour.GREEN);
        vehicle.run();
    }
}
