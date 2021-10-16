package pss;

import java.util.LinkedList;
import java.util.List;

/**
 * Team Members:
 * Kamron Cole (myself)
 * Jack Audino
 * Sierra Kennedy
 */
public class pss1 {
    /**
     * Problem Solving 1
     */

    public class Food {
        private String name;
        private int numServings;

        public Food(String name) {
            this.name = name;
            this.numServings = 0;
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



    /**
     * Problem Solving 2
     */

    public class ChezWoolie {
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

        public synchronized int getNumDiners() {
            return numDiners;
        }

        /**
         * Problem Solving 3
         */
    
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
    }
    /**
    * Problem Solving 4
    */

    public class Diner implements Runnable{
        private int hunger;
        private ChezWoolie chezWoolie;

        public void eat(Food food) {
            try {
                Thread.sleep(food.getNumServings() * 1000);
            } catch (InterruptedException ie) {}
            hunger -= food.getNumServings();
        }

        @Override
        public void run() {
            chezWoolie.enter();
            while (hunger > 0) {
                Food food = chezWoolie.retrieveFood();
                eat(food);
            }
            chezWoolie.exit();
        }
    }
}
