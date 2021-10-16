package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sleeper implements Runnable {
    private final int seconds;

    public Sleeper(int s) {
        seconds = s;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Sleeping for " + seconds + " seconds ...");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {}
        System.out.println("I'm awake!");
    }

    public static void main(String[] args) {
        Random RNG = new Random();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int sleepTime = RNG.nextInt(3) + 1;

            Sleeper sleeper = new Sleeper(sleepTime);
            Thread thread = new Thread(sleeper);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (Exception e) {}
        }
    }
}
