/**
 * Created for assignment 3.2
 * Contains Junit tests for an ActionFigure
 * Each Doll has a hair and eye color and says a random phrase from an array of phrases when played with
 * ActionFigures brandish their weapon if they have a Kung Fu Grip
 * 
 * @author Kamron Cole
*/
package toys;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class ActionFigureTest {
    /** Tests values are set correctly when made */
    @Test
    public void testActionFigureConst() {
        ActionFigure a = new ActionFigure(10.00, new String[]{"WEEEE"}, "Green", "Brown", true);
        String[] expectedPhrases = new String[]{"WEEEE"};
        String expectedName = "Doll";
        String expectedEyeColor = "Green";
        String expectedHairColor = "Brown";
        double expectedMSRP = 10.00;
        boolean expectedHasKungFuGrip = true;

        String[] actualPhrases = a.getPhrases();
        String actualName = a.getName();
        String actualEyeColor = a.getEyeColor();
        String actualHairColor = a.getHairColor();
        double actualMSRP = a.getMsrp();
        boolean actualHasKungFuGrip = a.hasKungFuGrip();

        assertArrayEquals(expectedPhrases, actualPhrases);
        assertEquals(expectedEyeColor, actualEyeColor);
        assertEquals(expectedHairColor, actualHairColor);
        assertEquals(expectedName, actualName);
        assertEquals(expectedMSRP, actualMSRP);
        assertEquals(expectedHasKungFuGrip, actualHasKungFuGrip);
    }

    /** test that when an ActionFIgure is played with the remainingPlays is decreased by 1 */
    @Test
    public void testPlay() {
        ActionFigure a = new ActionFigure(10.00, new String[]{"WEEEE"}, "Green", "Brown", true);
        int expectedRemainingPlays = 9;

        a.play();

        int actualRemainingPlays = a.getRemainingPlays();

        assertEquals(expectedRemainingPlays, actualRemainingPlays);
    }

    /** test that when an ActionFIgure is played with the remainingPlays is decreased by 1 but not below 0 and cant be played with when remaining plays is 0*/
    @Test
    public void testPlayTilDone() {
        ActionFigure a = new ActionFigure(10.00, new String[]{"WEEEE"}, "Green", "Brown", true);
        int expectedRemainingPlays = 0;

        a.play();
        a.play();
        a.play();
        a.play();
        a.play();
        a.play();
        a.play();
        a.play();
        a.play();
        a.play();
        a.play();
        a.play();

        int actualRemainingPlays = a.getRemainingPlays();

        assertEquals(expectedRemainingPlays, actualRemainingPlays);
    }
}
