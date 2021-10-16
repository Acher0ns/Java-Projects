package assignments.two;

import java.util.Random;

public class Chef implements Runnable {
    private ChezWoolie chezWoolie;
    private int id;
    private Random rng = new Random();

    public Chef (int id, ChezWoolie chezWoolie) {
        this.id = id;
        this.chezWoolie = chezWoolie;
    }

    @Override
    public String toString() {
        return "Chef #" + id;
    }

    @Override
    public void run() {
        synchronized(chezWoolie) {
            if (chezWoolie.getNumDiners() == 0) {
                try {
                    System.out.println(this + " is early! Waiting for customers.");
                    chezWoolie.wait();
                } catch (InterruptedException e) {}
            }
        }
            
        while (chezWoolie.getNumDiners() > 0) {        
            Food food = Food.allFood.get(rng.nextInt(Food.allFood.size()));
            System.out.println(this + " begins to prepare " + food.getNumServings() + " serving(s) of " + food.getName() + ".");
                
            try {
                Thread.sleep(food.getNumServings() * (2 * ChezWoolie.WOOLECOND));
            } catch (InterruptedException e) {}
                
            System.out.println(this + " finishes "+ food.getNumServings() + " serving(s) of " + food.getName() + " and places it on the conveyor belt.");
            chezWoolie.serveFood(food);
        }
    }
}
