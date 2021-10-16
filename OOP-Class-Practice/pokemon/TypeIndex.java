package pokemon;

public enum TypeIndex {
    NORMAL("Normal"),
    FIRE("Fire"),
    WATER("Water"),
    GRASS("Grass"),
    ELECTRIC("Electric"),
    ICE("Ice"),
    FIGHTING("Fighting"),
    POISON("Poison"),
    GROUND("Ground"),
    FLYING("Flying"),
    PSYCHIC("Phychic"),
    BUG("Bug"),
    ROCK("Rock"),
    GHOST("Ghost"),
    DARK("Dark"),
    DRAGON("Dragon"),
    STEEL("Steel"),
    FAIRY("Fairy");

    private final String friendlyName;

    private TypeIndex(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return this.friendlyName;
    }
}