package pss;

/**
 * Team Members:
 * Kamron Cole (myself)
 * Jack Audino
 * Sierra Kennedy
 */
public class pss2 {
    /**
     * Problem Solving 1
     */

    public enum Color {
        RED,
        YELLOW,
        GREEN
    }

    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }


    
    /**
    * Problem Solving 2
    */

    public class Vehicle implements Runnable {
        private int id;
        private Direction direction;
        private Intersection intersection;

        public Vehicle (int id, Direction direction, Intersection intersection) {
            this.id = id;
            this.direction = direction;
            this.intersection = intersection;
        }

        @Override
        public void run() {
            intersection.driveThrough(this);
        }
    }



    /**
     * Problem Solving 3
     */

    public class TrafficLight implements Runnable {
        Object lock = new Object();

        Color color;

        @Override
        public void run() {
            synchronized(lock) {
                while(true) {
                    try {
                        Thread.sleep(1000);
                        color = Color.GREEN;
                        Thread.sleep(5000);
                        color = color.YELLOW;
                        Thread.sleep(2000);
                        color = color.RED;
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException ie) {}
                }
            }
        }
    }



    /**
     * Problem Solving 4
     */

    public class Intersection {
        public void driveThrough(Vehicle vehicle) {
            /**
             * get direction from vehicle
             * get traffic light corresponding direction
             * synch on light
             *     if light is green
             *         vehicle drives through
             *     else
             *         while light is not green
             *             wait
             *         drive through intersection
             */
        }
    }
}
