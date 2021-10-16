package peggame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.platform.commons.annotation.Testable;

import backtracker.Configuration;

import org.junit.Test;

/**
 * @author Jack Audino, Sierra Kennedy, Kamron Cole
 */
@Testable
public class TestPegConfig {
    @Test
    public void testGetSolutionValid() {
        PegGame testRectGame = new RectPegGame(4, 4);
        PegGame testTriGame = new TriPegGame(5);
        assertTrue(PegConfig.getSolution(testRectGame) != null);
        assertTrue(PegConfig.getSolution(testTriGame) != null);
    }

    @Test
    public void testGetSolutionInalid() {
        PegGame testRectGame = new RectPegGame(3, 3);
        PegGame testTriGame = new TriPegGame(3);
        assertTrue(PegConfig.getSolution(testRectGame) == null);
        assertTrue(PegConfig.getSolution(testTriGame) == null);
    }

    @Test
    public void testGetSuccessors() {
        PegGame testRectGame = new RectPegGame(4, 4);
        PegGame testTriGame = new TriPegGame(5);
        PegConfig testRectConfig = new PegConfig(testRectGame);
        PegConfig testTriConfig = new PegConfig(testTriGame);
        Collection<Configuration> testRectCollection = testRectConfig.getSuccessors();
        Collection<Configuration> testTriCollection = testTriConfig.getSuccessors();
        int expectedRect = 3;
        int expectedTri = 2;
        int actualRect = testRectCollection.size();
        int actualTri = testTriCollection.size();
        assertEquals(expectedRect, actualRect);
        assertEquals(expectedTri, actualTri);
    }

    @Test
    public void testConstructor() {
        PegGame testRectGame = new RectPegGame(4, 4);
        PegGame testTriGame = new TriPegGame(5);
        PegConfig testRectConfig = new PegConfig(testRectGame);
        PegConfig testConfig = new PegConfig(testTriGame);
        Collection<Configuration> testRectCollection = testRectConfig.getSuccessors();
        Collection<Configuration> testTriCollection = testConfig.getSuccessors();
        int expectedRect = 3;
        int expectedTri = 2;
        int actualRect = testRectCollection.size();
        int actualTri = testTriCollection.size();
        assertEquals(expectedRect, actualRect);
        assertEquals(expectedTri, actualTri);
        assertTrue(testRectConfig.isValid());
        assertTrue(testConfig.isValid());
        assertTrue(!testRectConfig.isGoal());
        assertTrue(!testConfig.isGoal());
    }
}
