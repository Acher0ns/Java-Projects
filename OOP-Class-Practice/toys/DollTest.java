/**
 * Created for assignment 3.2
 * Contains JUnit tests for the Doll Class
 * Each Doll has a hair and eye color and says a random phrase from an array of phrases when played with
 * 
 * @author Kamron Cole
*/
package toys;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class DollTest {
    /** Tests values are set correctly when made */
    @Test
    public void testDollConst() {
        Doll d = new Doll(10.00, new String[]{"WEEEE"}, "Green", "Brown");
        String[] expectedPhrases = new String[]{"WEEEE"};
        String expectedName = "Doll";
        String expectedEyeColor = "Green";
        String expectedHairColor = "Brown";
        double expectedMSRP = 10.00;

        String[] actualPhrases = d.getPhrases();
        String actualName = d.getName();
        String actualEyeColor = d.getEyeColor();
        String actualHairColor = d.getHairColor();
        double actualMSRP = d.getMsrp();

        assertArrayEquals(expectedPhrases, actualPhrases);
        assertEquals(expectedEyeColor, actualEyeColor);
        assertEquals(expectedHairColor, actualHairColor);
        assertEquals(expectedName, actualName);
        assertEquals(expectedMSRP, actualMSRP);
    }

    /** test that when a Doll is played with the remainingPlays is decreased by 1 */
    @Test
    public void testPlay() {
        Doll d = new Doll(10.00, new String[]{"WEEEE"}, "Green", "Brown");
        int expectedRemainingPlays = 9;

        d.play();

        int actualRemainingPlays = d.getRemainingPlays();

        assertEquals(expectedRemainingPlays, actualRemainingPlays);
    }

    /** test that when a Doll is played with the remainingPlays is decreased by 1 but not below 0 and cant be played with when remaining plays is 0*/
    @Test
    public void testPlayTilDone() {
        Doll d = new Doll(10.00, new String[]{"WEEEE"}, "Green", "Brown");
        int expectedRemainingPlays = 0;

        d.play();
        d.play();
        d.play();
        d.play();
        d.play();
        d.play();
        d.play();
        d.play();
        d.play();
        d.play();
        d.play();
        d.play();

        int actualRemainingPlays = d.getRemainingPlays();

        assertEquals(expectedRemainingPlays, actualRemainingPlays);
    }
}
