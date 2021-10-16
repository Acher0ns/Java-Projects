package assignments.one;

public abstract class Pet {
    private String species;

    public abstract String speak();

    public Pet(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return species;
    }

    public String getSpecies() {
        return species;
    }

    public static void main(String[] args) {
        Pet cat = new Pet("Cat") {
            @Override
            public String speak() {
                return "Meow";
            }
        };

        Pet dog = new Pet("Dog") {
            @Override
            public String speak() {
                return "Ruff";
            }
        };

        Pet bird = new Pet("Bird") {
            @Override
            public String speak() {
                return "Chirp";
            }
        };

        Pet[] pets = {cat, dog, bird};

        for (Pet pet : pets) {
            System.out.println(pet + " says, \"" + pet.speak() + "\".");
        }
    }
}
