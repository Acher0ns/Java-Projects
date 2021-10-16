package assignments.two;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Food {
    private static final int MAX_SERVINGS = 6;
    public static List<Food> allFood = new LinkedList<>();

    static {
        Random rng = new Random();
        allFood.add(new Food("French Fries", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Pepperoni Pizza", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Turkey Leg", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Hamburger", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Banana Split", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Strawberry Shortcake", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Rice Pudding", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Shrimp Tempura", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Cajun Fries", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Poutine", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Risotto", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Tuna", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Fried Chicken", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Dragon Roll", rng.nextInt(MAX_SERVINGS) + 1));
        allFood.add(new Food("Dumplings", rng.nextInt(MAX_SERVINGS) + 1));
    }

    private String name;
    private int numServings;

    public Food(String name, int numServings) {
        this.name = name;
        this.numServings = numServings;
    }

    @Override
    public String toString() {
        return numServings + " servings of " + name;
    }

    public String getName() {
        return name;
    }

    public int getNumServings() {
        return numServings;
    }
}
