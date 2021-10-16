package assignments.two;

public class Diner implements Runnable {
    private int id;
    private int hunger;
    private ChezWoolie chezWoolie;

    public Diner(int id, int hunger, ChezWoolie chezWoolie) {
        this.id = id;
        this.hunger = hunger;
        this.chezWoolie = chezWoolie;
    }

    @Override
    public String toString() {
        return "Diner #" + id;
    }

    public void eat(Food food) {
        System.out.println(this + " begins to eat " + food.getNumServings() + " serving(s) of " + food.getName()+ ".");
        try {
            Thread.sleep(food.getNumServings() * ChezWoolie.WOOLECOND);
        } catch (InterruptedException ie) {}
        hunger -= food.getNumServings();

        if (hunger <= 0) {
            System.out.println(this + " finishes eating " + food.getNumServings() + " serving(s) of " + food.getName() + " and is full!");
        } else {
            System.out.println(this + " finishes eating " + food.getNumServings() + " serving(s) of " + food.getName() + " and is still hungry!");
        }
    }

    @Override
    public void run() {
        System.out.println(this + " enters the restaurant!");
        chezWoolie.enter();
        while (hunger > 0) {
            Food food = chezWoolie.retrieveFood();
            eat(food);
        }
        System.out.println(this + " exits the restaurant!");
        chezWoolie.exit();
    }
}
