package assignments.three;

/**
 * Created for assignment 10.3
 * Outlines a Vehicle that is heading in a direction, that when run, will attempt to drive through an intersection.
 * if light controlling their direction is green, drive through, else vehicle waits on that light.
 * 
 * @author Kamron Cole
 */
public class Vehicle implements Runnable {
    /**
     * Possible directions a vehicle can head through an intersection.
     */
    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST;

        /**
         * @return Direction with the first char capitalized and the rest lowercase.
         */
        public String getSimpleName() {
            return this.toString().substring(0, 1) + this.toString().substring(1, this.toString().length()).toLowerCase();
        }
    }

    private int id;
    private Direction direction;
    private Intersection intersection;

    /**
     * Creates a vehicle
     * @param id unique id of the vehicle
     * @param direction vehicle is heading
     * @param intersection vehicle is attempting to drive through
     */
    public Vehicle (int id, Direction direction, Intersection intersection) {
        this.id = id;
        this.direction = direction;
        this.intersection = intersection;
    }

    /**
     * Vehicle string format ($ is variable prefix):
     * Vehicle ($id) heading $direction
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (" + id + ") heading " + direction.getSimpleName();
    }

    /**
     * Attempts to drive through the intersection
     */
    @Override
    public void run() {
        intersection.driveThrough(this);
    }

    public int getId() {
        return id;
    }

    public Direction getDirection() {
        return direction;
    }
}
