package peggame;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import backtracker.*;

/**
 * Defines a configuration of a PegGame to be used in a backtracker to find the solution of any PegGame is it exists
 * @author Jack Audino, Sierra Kennedy, Kamron Cole
 */
public class PegConfig implements Configuration {
    private List<Move> allMoves;
    private PegGame game;
    
    public PegConfig(PegGame game) {
        this.game = game;
        this.allMoves = new LinkedList<>();
    }

    public PegConfig(PegGame game, List<Move> allMoves) {
        this.game = game;
        this.allMoves = allMoves;
    }
    
    @Override
    public String toString() {
        return this.allMoves.toString() + "\n" + this.game;
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        Collection<Configuration> successors = new LinkedList<>();
        for (Move move : game.getPossibleMoves()) {
            PegGame game = this.game.deepCopy();
            List<Move> allMovesCopy = new LinkedList<>(allMoves);
            game.makeMove(move);
            allMovesCopy.add(move);
            successors.add(new PegConfig(game, allMovesCopy));
        }
        return successors;
    }   
    
    @Override
    public boolean isGoal() {
        return this.game.getGameState() == GameState.WON;
    }

    @Override
    public boolean isValid() {
        return this.game.getGameState() != GameState.STALEMATE;
    }

    public List<Move> getAllMoves() {
        return allMoves;
    }

    /**
     * Get the solution configuration of any PegGame
     * @param game being played
     * @return solution PegConfig of the PegGame passed in, null if no solution is found.
     */
    public static PegConfig getSolution(PegGame game) {
        PegConfig gameConfig = new PegConfig(game);
        Backtracker bt = new Backtracker(false);
        gameConfig = (PegConfig) bt.solve(gameConfig);
        return gameConfig;
    }
}
