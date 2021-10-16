package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Uses threads to concurrently add integer values to a list, and then prints
 * the total number of values that were successfully added.
 * 
 * @author GCCIS Faculty.
 */
public class ListAdder implements Runnable {
    /**
     * The number of integer values to add to the list.
     */
    private static final int NUMBER_TO_ADD = 1000;

    /**
     * The list to which the vinteger alues should be added.
     */
    private Vector<Integer> vector;

    /**
     * Creates a new list adder thread to add integer values to a list.
     * 
     * @param list The list to which the integer values will be added.
     */
    public ListAdder(Vector<Integer> list) {
        this.vector = list;
    }

    /**
     * Uses a loop to add integer values to the list.
     */
    @Override
    public void run() {
        for (int i = 0; i < NUMBER_TO_ADD; i++) {
            vector.add(i);
        }
    }

    /**
     * Creates 10 list adder threads and starts them. Waits for all of the threads
     * to complete, and then prints the total number of values that were added to
     * the list (which should be 10,000).
     * 
     * @param args The command line arguments. Ignored.
     */
    public static void main(String[] args) {
        int numberOfThreads = 10;

        Vector<Integer> vector = new Vector<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            ListAdder adder = new ListAdder(vector);
            Thread thread = new Thread(adder);
            thread.start();
            threads.add(thread);
        }

        // use join() to wait for all of the other threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // this will never happen, so squash it
            }
        }

        // print the number of integers successfully added
        System.out.println("size (should be " 
            + (numberOfThreads * NUMBER_TO_ADD) + "): " 
            + vector.size());
    }
}