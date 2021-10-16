package assignments.two;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ChezWoolie {
    private static Random rng = new Random();
    public static final int WOOLECOND = 500;

    private int numDiners;
    List<Food> conveyorBelt;

    public ChezWoolie() {
        this.numDiners = 0;
        this.conveyorBelt = new LinkedList<>();
    }

    public synchronized void enter() {
        numDiners++;
        notify();
    }

    public synchronized void exit() {
        numDiners--;
    }
    
    public Food retrieveFood() {
        synchronized(conveyorBelt) {
            while (conveyorBelt.isEmpty()) {
                try {
                    conveyorBelt.wait();
                } catch (InterruptedException e) {}
            }
            return conveyorBelt.remove(0);
        }
    }
    
    public void serveFood(Food food) {
        synchronized(conveyorBelt) {
            conveyorBelt.add(food);
            conveyorBelt.notifyAll();
        }
    }

    public synchronized int getNumDiners() {
        return numDiners;
    }

    public static void main(String[] args) throws InterruptedException {
        ChezWoolie restaurant = new ChezWoolie();
        List<Thread> chefThreads = new LinkedList<>();
        System.out.println("Chez Woolie is opening for the day!");
        
        for (int chefs = 1; chefs < 3; chefs++) {
            Chef chef = new Chef(chefs, restaurant);
            Thread thread = new Thread(chef);
            chefThreads.add(thread);
            thread.start();
        }

        for (int diners = 1; diners < 11; diners++) {
            Diner diner = new Diner(diners, rng.nextInt(11) + 5, restaurant);
            Thread thread = new Thread(diner);
            thread.start();
        }

        for (Thread thread : chefThreads) {
            thread.join();
        }

        System.out.println("Chez Woolie is closing for the night!");
    }
}
