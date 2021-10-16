package peggame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.platform.commons.annotation.Testable;
import org.junit.Test;

/**
 * @author Jack audino, Kamron Cole
 */
@Testable
public class TestRectPegGame {
    @Test
    public void testValidMakeMove() {
        Location testTo = new Location(5, 5);
        Location testFrom = new Location(3, 5);
        Move testMove = new Move(testFrom, testTo);
        RectPegGame testGame = new RectPegGame(6, 6);
        GameState expected = GameState.IN_PROGRESS;
        testGame.makeMove(testMove);
        GameState actual = testGame.getGameState();
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidMakeMove() {
        Location testTo = new Location(5, 5);
        Location testFrom = new Location(4, 4);
        Move testMove = new Move(testFrom, testTo);
        RectPegGame testGame = new RectPegGame(6, 6);

        try {
            testGame.makeMove(testMove);
            assertTrue(false);
        } catch (PegGameException pge) {
            assertTrue(true);
        }

    }

    @Test
    public void testGetPossibleMoves() {
        RectPegGame testGame = new RectPegGame(6, 6);
        int expected = 3;
        int actual = testGame.getPossibleMoves().size();
        assertEquals(expected, actual);

        testGame.getPossibleMoves().stream().forEach(move -> {
            int fromRow = move.getFrom().getRow();
            int fromCol = move.getFrom().getCol();
            int toRow = move.getTo().getRow();
            int toCol = move.getTo().getCol();

            assertTrue(toRow - fromRow == 2 || toRow - fromRow == -2 || toRow - fromRow == 0);
            assertTrue(toCol - fromCol == 2 || toCol - fromCol == -2 || toCol - fromCol == 0);
        });
    }

    @Test
    public void testGameStateNotStarted() {
        RectPegGame testGame = new RectPegGame(6, 6);
        GameState expected = GameState.NOT_STARTED;
        GameState actual = testGame.getGameState();
        assertEquals(expected, actual);
    }

    @Test
    public void testGameStateInProgress() {
        Location testTo = new Location(5, 5);
        Location testFrom = new Location(3, 5);
        Move testMove = new Move(testFrom, testTo);
        RectPegGame testGame = new RectPegGame(6, 6);
        testGame.makeMove(testMove);
        GameState expected = GameState.IN_PROGRESS;
        GameState actual = testGame.getGameState();
        assertEquals(expected, actual);
    }

    @Test
    public void testGameStateStaleMate() {
        Move testMove1 = new Move(new Location(0, 2), new Location(2, 2));
        Move testMove2 = new Move(new Location(2, 0), new Location(0, 2));
        Move testMove3 = new Move(new Location(2, 2), new Location(2, 0));
        RectPegGame testGame = new RectPegGame(3, 3);
        testGame.makeMove(testMove1);
        testGame.makeMove(testMove2);
        testGame.makeMove(testMove3);
        GameState expected = GameState.STALEMATE;
        GameState actual = testGame.getGameState();
        assertEquals(expected, actual);
    }

    @Test
    public void testGameStateWon() {
        Move testMove1 = new Move(new Location(0, 2), new Location(2, 2));
        Location[] row0 = new Location[]{new Location(0, 0), new Location(0, 1), new Location(0, 2, true)};
        Location[] row1 = new Location[]{new Location(1, 0), new Location(1, 1), new Location(1, 2, true)};
        Location[] row2 = new Location[]{new Location(2, 0), new Location(2, 1), new Location(2, 2)};
        RectPegGame testGame = new RectPegGame(3, 3, new Location[][]{row0, row1, row2});
        testGame.makeMove(testMove1);
        GameState expected = GameState.WON;
        GameState actual = testGame.getGameState();
        assertEquals(expected, actual);
    }

    @Test
    public void testDeepCopy(){
        Location[] row0 = new Location[]{new Location(0, 0), new Location(0, 1), new Location(0, 2, true)};
        Location[] row1 = new Location[]{new Location(1, 0), new Location(1, 1), new Location(1, 2, true)};
        Location[] row2 = new Location[]{new Location(2, 0), new Location(2, 1), new Location(2, 2)};
        RectPegGame testGame = new RectPegGame(3, 3, new Location[][]{row0, row1, row2});
        PegGame copy = testGame.deepCopy();
        assertTrue(testGame.equals(copy));

    }
}
