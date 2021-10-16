package peggame;

import java.util.Collection;

/**
 * @author Sierra Kennedy
 */
public interface PegGame {
    Collection<Move> getPossibleMoves();
    GameState getGameState();
    void makeMove(Move move);
    default PegGame deepCopy(){
        throw new UnsupportedOperationException("Not Implemented");
    }
}
