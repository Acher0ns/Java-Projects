package pokemon;

public class Pokemon {
    private String name;
    private final TypeIndex type;
    private int level;

    public Pokemon(String name, TypeIndex type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;

        if (this.level > 100) {
            this.level = 100;
        }
    }

    public Pokemon(String name, TypeIndex type) {
        this.name = name;
        this.type = type;
        this.level = 1;
    }

    public void levelUp() {
        this.level = this.level >= 100 ? 100 : this.level + 1;
    }

    @Override
    public String toString() {
        return "Pokemon{name=<"+this.name+">, type=<"+this.type+">, level=<"+this.level+">}";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pokemon)) {
            return false;
        }

        Pokemon other = (Pokemon)(obj);
        return (this.type == other.type) && (this.level == other.level);
    }

    public String getName() {
        return name;
    }

    public TypeIndex getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}
