package activities;

public class Child extends Parent {
    private int age;

    public Child(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Child{name=<" + getName() + ">, age=<" + this.age + ">}";
    }

    public int getAge() {
        return age;
    }
}
