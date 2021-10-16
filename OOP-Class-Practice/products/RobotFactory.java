/**
 * Created for assignment 3.3
 * Creates a Factory that makes robots.
 * Each doll has a price between 30 and 100 and ends in .99
 * 
 * @author Kamron Cole
*/
package products;

import java.util.Random;

import toys.Robot;

public class RobotFactory implements Factory{
    private static String[] SOUNDS = {"WEEEE", "AAAAAAH", "HAHAHAH", "JAJAJAJA"};
    private Random r = new Random();

    @Override
    public Robot manufacture() {
        double msrp = r.nextInt(70);
        if (msrp < 30) {
            msrp += 30.99;
        } else {
            msrp += 0.99;
        }

        // msrp = Math.round(msrp * 100) / 100.0; JAVA WEIRD WITH .99

        String sound = SOUNDS[r.nextInt(SOUNDS.length)];
        return new Robot(msrp, sound);
    }
}
