/**
 * Created for assignment 3.2
 * Contains JUnit tests for the Robot Class
 * Each robot plays a (same of different) sound and walks in circles when played with
 * 
 * @author Kamron Cole
*/
package toys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class RobotTest {
    /** Tests values are set correctly when made */
    @Test
    public void testRobotConstructor() {
        Robot r = new Robot(10.00, "WEEEE");
        int expectedCharge = 0;
        String expectedName = "Robot";
        double expectedMSRP = 10.00;

        int actualCharge = r.getCharge();
        String actualName = r.getName();
        double actualMSRP = r.getMsrp();

        assertEquals(expectedCharge, actualCharge);
        assertEquals(expectedName, actualName);
        assertEquals(expectedMSRP, actualMSRP);
    }

    /** Test that the robot isnt played with with no charge */
    @Test
    public void testPlayNoCharge() {
        Robot r = new Robot(10.00, "WEEEE");
        int expectedCharge = 0;

        r.play();

        int actualCharge = r.getCharge();

        assertEquals(expectedCharge, actualCharge);
    }

    /** test that charge method charges the robot to 100% */
    @Test
    public void testCharge() {
        Robot r = new Robot(10.00, "WEEEE");
        int expectedCharge = 100;

        r.charge();
        
        int actualCharge = r.getCharge();

        assertEquals(expectedCharge, actualCharge);
    }

    /** test that play method properly decreases charge by 20% whenever played with */
    @Test
    public void testPlay() {
        Robot r = new Robot(10.00, "WEEEE");
        int expectedCharge = 80;

        r.charge();
        r.play();
        
        int actualCharge = r.getCharge();

        assertEquals(expectedCharge, actualCharge);
    }
}
