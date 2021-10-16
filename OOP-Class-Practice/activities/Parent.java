package activities;

public class Parent {
    private String name;

    public Parent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patent{name=<" + this.name + ">}";
    }

    public String getName() {
        return name;
    }
}
