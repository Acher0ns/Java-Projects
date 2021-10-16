package peggame;

/**
 * GameState enum
 * Contains all possible states for a PegGame
 * @author Kamron Cole
 */
public enum GameState {
    NOT_STARTED("Not Started"),
    IN_PROGRESS("In Progress"),
    STALEMATE("Stalemate"),
    WON("Won");

    private final String name;

    private GameState(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
