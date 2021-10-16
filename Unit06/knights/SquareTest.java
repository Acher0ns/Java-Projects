/**
 * Created for assignment 6.3
 * Contains JUnit tests for Square Class
 * 
 * @author Kamron Cole
 */
package knights;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class SquareTest {
    @Test
    public void squareConstructor(){
        Square s = new Square(0, 0);

        assertEquals(s.toString(), "(0, 0)");
    }

    @Test
    public void squareStringConstructor(){
        Square s = new Square("1", "3");

        assertEquals(s.toString(), "(1, 3)");
    }
}
