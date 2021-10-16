package assignments.three;

import java.util.Random;

import assignments.three.TrafficLight.Colour;
import assignments.three.Vehicle.Direction;

/**
 * Created for assignment 10.3
 * Outlines and intersection that has 2 traffic lights, each controlling 2 directions.
 * Allows vehicles through if light controlling their direction is green, else vehicle waits on that light.
 * 
 * @author Kamron Cole
 */
public class Intersection {
    private TrafficLight northSouth;
    private TrafficLight eastWest;

    /**
     * Creates an intersection with 2 traffic lights, each controlling 2 directions
     * @param northSouth traffic light controling vehicles heading North/South
     * @param eastWest traffic light controling vehicles heading East/West
     */
    public Intersection(TrafficLight northSouth, TrafficLight eastWest) {
        this.northSouth = northSouth;
        this.eastWest = eastWest;
    }

    /**
     * A vehicle attempts to drive through the intersection.
     * If light corresponding to its direction is green, go through,
     * Else, wait on the light to turn green.
     * @param vehicle attempting to go through the intersection
     * 
     * Tested in VehicleTest.java
     */
    public void driveThrough(Vehicle vehicle) {
        Direction direction = vehicle.getDirection();
        TrafficLight light = direction == Direction.NORTH || direction == Direction.SOUTH ? northSouth : eastWest;
        synchronized(light) {
            if (light.getColour() == Colour.GREEN) {
                System.out.println("  " + vehicle + " drives through the intersection.");
            } else {
                System.out.println("  " + vehicle + " stops because the light is " + light.getColour() + ".");
                while(light.getColour() != Colour.GREEN) {
                    try {
                        light.wait();
                    } catch (InterruptedException ie) {}
                }
                System.out.println("  " + vehicle + " drives through the intersection.");
            }
        }
    }

    /**
     * Creates 2 Traffic lights and an intersection.
     * Creates 100 vehicles (0 - 2000ms between each) heading in a random directions.
     * 
     * Lights change colors 1 at a time.
     */
    public static void main(String[] args) {
        Random RNG = new Random();

        Object lock = new Object();
        TrafficLight northSouth = new TrafficLight("North/South", lock);
        TrafficLight eastWest = new TrafficLight("East/West", lock);
        Intersection intersection = new Intersection(northSouth, eastWest);
        
        Thread northSouthThread = new Thread(northSouth);
        Thread eastWestThread = new Thread(eastWest);
        northSouthThread.start();
        eastWestThread.start();
        
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(RNG.nextInt(2001));
            } catch (InterruptedException ie) {}
            
            Direction direction = Direction.values()[RNG.nextInt(4)];
            Vehicle vehicle = new Vehicle(i, direction, intersection);
            Thread thread = new Thread(vehicle);
            thread.start();
        }
    }
}
