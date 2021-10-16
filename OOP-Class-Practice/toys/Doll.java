/**
 * Created for assignment 3.2
 * Contains the outline of a Doll which is a Toy
 * Each Doll has a hair and eye color and says a random phrase from an array of phrases when played with
 * 
 * @author Kamron Cole
*/
package toys;

import java.util.Arrays;
import java.util.Random;

public class Doll extends Toy {
    private String hairColor;
    private String eyeColor;
    private String[] phrases;
    private int remainingPlays;

    /**
     * Creates a Doll
     * @param MSRP Cost of the Doll
     * @param phrases Array of phrases to say when played with
     * @param eyeColor Doll's eye color
     * @param hairColor Doll's hair color
    */
    public Doll(double MSRP, String[] phrases, String eyeColor, String hairColor) {
        super(MSRP, "Doll");

        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.phrases = phrases;
        this.remainingPlays = 10;
    }

    /**
     * returns string in format "Name{productCode=<productCode>, MSRP=<MSRP>, hairColor=<hairColor>, eyeColor=<eyeColor>, phrases=<phrases>}"
    */
    @Override
    public String toString() {
        return getName() + "{productCode=<" + getProductCode() + ">, MSRP=<" + getMsrp() + ">, hairColor=<" + this.hairColor + ">, eyeColor=<" + this.eyeColor + ">, phrases=<" + Arrays.toString(this.phrases) + ">}";
    }

    /**
     * When you play with a doll it says a random phrase from it's array of phrases
     * A Doll can be played with 10 times before it breaks
     * When a doll is broken (remainingPlays == 0) you can no longer play with the doll
    */
    @Override
    public void play() {
        if (remainingPlays > 0) {
            Random r = new Random();
            String phrase = phrases[r.nextInt(phrases.length)];
            System.out.println("Says \"" + phrase + ".\"");
            decreaseRemainingPlays();
        }
    }

    /**
     * Helper function used to decrease remainingPlays whenever played with
    */
    protected void decreaseRemainingPlays() {
        this.remainingPlays--;
    }

    /**
     * @return Return A Doll's phrases
     */
    public String[] getPhrases() {
        return phrases;
    }

    /**
     * @return Return A Doll's remainingPlays
     */
    public int getRemainingPlays() {
        return remainingPlays;
    }

    /**
     * @return Return A Doll's hairColor
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * @return Return A Doll's eyeColor
     */
    public String getEyeColor() {
        return eyeColor;
    }
}
