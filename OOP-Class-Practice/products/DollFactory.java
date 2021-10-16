/**
 * Created for assignment 3.3
 * Creates a Factory that makes dolls.
 * Each doll has a price between 5 and 30 and ends in .99
 * 
 * @author Kamron Cole
*/
package products;

import java.util.Random;

import toys.Doll;

public class DollFactory implements Factory {
    private static final String[] HAIR_COLOR = {"Brown", "Blond", "Black", "Red", "Colourful"};
    private static final String[] EYE_COLOR = {"Brown", "Green", "Hazel", "Blue"};
    private static final String[] PHRASES = {"Ga-ga", "Goo Goo", "HAHAHA", "Im hungry", "Are we there yet?"};
    private Random r = new Random();

    @Override
    public Doll manufacture() {
        double msrp = r.nextInt(25);
        if (msrp < 5) {
            msrp += 5.99;
        } else {
            msrp += 0.99;
        }

        // msrp = Math.round(msrp * 100) / 100.0; JAVA WEIRD WITH .99

        String hairColor = HAIR_COLOR[r.nextInt(HAIR_COLOR.length)];
        String eyeColor = EYE_COLOR[r.nextInt(EYE_COLOR.length)];
        return new Doll(msrp, PHRASES, hairColor, eyeColor);
    }
}
