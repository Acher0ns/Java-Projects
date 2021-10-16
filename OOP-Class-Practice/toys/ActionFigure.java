/**
 * Created for assignment 3.2
 * Contains the outline of an ActionFigure which is Doll which is a Toy
 * Each Doll has a hair and eye color and says a random phrase from an array of phrases when played with
 * ActionFigures brandish their weapon if they have a Kung Fu Grip
 * 
 * @author Kamron Cole
*/
package toys;

import java.util.Arrays;
import java.util.Random;

public class ActionFigure extends Doll {
    private boolean hasKungFuGrip;

    /**
     * Creates an ActionFigure
     * @param MSRP Cost of the Doll
     * @param phrases Array of phrases to say when played with
     * @param eyeColor Doll's eye color
     * @param hairColor Doll's hair color
     * @param hasKungFuGrip does the ActionFigure have a Kung Fu Grip
    */
    public ActionFigure(double MSRP, String[] phrases, String eyeColor, String hairColor, boolean hasKungFuGrip) {
        super(MSRP, phrases, eyeColor, hairColor);

        this.hasKungFuGrip = hasKungFuGrip;
    }

    /**
     * returns string in format "Name{productCode=<productCode>, MSRP=<MSRP>, hairColor=<hairColor>, eyeColor=<eyeColor>, hasKungFuGrip=<hasKungFuGrip>, phrases=<phrases>}"
    */
    @Override
    public String toString() {
        return getName() + "{productCode=<" + getProductCode() + ">, MSRP=<" + getMsrp() + ">, hairColor=<" + getHairColor() + ">, eyeColor=<" + getEyeColor() + ">, hasKungFuGrip=<" + this.hasKungFuGrip + ">, phrases=<" + Arrays.toString(getPhrases()) + ">}";
    }

    /**
     * When you play with an ActionFigure it says a random phrase from it's array of phrases
     * If the ActionFigure has a KungFuGrip it also brandishes it's weapon
     * An ActionFigure can be played with 10 times before it breaks
     * When an ActionFigure is broken (remainingPlays == 0) you can no longer play with the doll
    */
    @Override
    public void play() {
        if (getRemainingPlays() > 0) {
            Random r = new Random();
            String phrase = hasKungFuGrip ? getPhrases()[r.nextInt(getPhrases().length)] + " *brandishes sword*" : getPhrases()[r.nextInt(getPhrases().length -1)];
            System.out.println("Says \"" + phrase + ".\"");
            super.decreaseRemainingPlays();
        }
    }

    /**
     * @return Return if ActionFigure has a Kung Fu Grip
     */
    public boolean hasKungFuGrip() {
        return hasKungFuGrip;
    }
}
