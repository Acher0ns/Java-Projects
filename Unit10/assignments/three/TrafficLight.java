package assignments.three;

/**
 * Created for assignment 10.3
 * Outlines a Traffic Light that is used at an intersection
 * Different lights in the same intersection should be synchronized on the same lock
 * Light goes from green -> yellow -> red then waits for the next light to do the same before going to green again.
 * 
 * @author Kamron Cole
 */
public class TrafficLight implements Runnable {
    /**
     * Possible colours a traffic light can be
     */
    public enum Colour {
        RED,
        YELLOW,
        GREEN
    }

    private String name;
    private Object lock;
    private Colour colour;

    /**
     * Create a TrafficLight that can be used in an intersection
     * @param name of traffic light (direction it controls)
     * @param lock used to sychronize traffic lights in the same intersection
     */
    public TrafficLight(String name, Object lock) {
        this.name = name;
        this.lock = lock;
        this.colour = Colour.RED;
        System.out.println(this);
    }

    /**
     * TrafficLight string format ($ is variable prefix):
     * The $name light is $colour.
     */
    @Override
    public String toString() {
        return "The " + name + " light is " + colour + ".";
    }

    /**
     * Syncronizes with other lights in an intersection
     * Light goes from green -> yellow -> red then waits for the next light to do the same before going to green again.
     * Notifies vehicles waiting at the light when it turns green (could cause issue if light tries to turn green while a vehicle has the clock)
     */
    @Override
    public void run() {
        synchronized(lock) {
            while(true) {
                try {
                    Thread.sleep(1000);

                    synchronized(this) {
                        setColour(Colour.GREEN);
                        this.notifyAll();
                    }

                    Thread.sleep(5000);
                    setColour(Colour.YELLOW);
                    Thread.sleep(2000);
                    setColour(Colour.RED);
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException ie) {}
            }
        }
    }

    /**
     * Set current colour of the TrafficLight
     * @param colour light will change to
     * 
     * Prints string in format ($ is variable prefix):
     * The $name light changes from $previousColour to $newColour
     */
    void setColour(Colour newColour) {
        Colour previousColour = this.colour;
        this.colour = newColour;
        System.out.println("The " + this.name + " light changes from " + previousColour + " to "+ newColour + ".");
    }

    public Colour getColour() {
        return colour;
    }
}
