/**
 * Created for assignment 3.2
 * Contains the outline of a Robot which is a Toy.
 * Each robot plays a (same of different) sound and walks in circles when played with
 * 
 * @author Kamron Cole
*/
package toys;

public class Robot extends Toy {
    private int charge;
    private String sound;

    /**
     * Creates a Robot
     * @param MSRP Cost of the Robot
     * @param sound sound when played with
    */
    public Robot(double MSRP, String sound) {
        super(MSRP, "Robot");
        this.sound = sound;
        this.charge = 0;
    }

    /**
     * returns string in format "Name{productCode=<productCode>, MSRP=<MSRP>, sound=<sound>}"
    */
    @Override
    public String toString() {
        return getName() + "{productCode=<" + getProductCode() + ">, MSRP=<" + getMsrp() + ">, sound=<" + this.sound + ">}";
    }

    /**
     * When you play with the Robot is walks in circles and makes a sound
     * Robot needs charge to be played with
     * Decreases by 20 charge every time it is played with
    */
    @Override
    public void play() {
        if (charge > 0) {
            charge -= 20;
            System.out.println("*Walks in circles* and says \"" + this.sound + ".\"");
        }
    }

    /**
     * Charges the Robot to 100% so it can be played with again
    */
    public void charge() {
        this.charge = 100;
    }

    /**
     * @return Return Robot charge
     */
    public int getCharge() {
        return charge;
    }
}
