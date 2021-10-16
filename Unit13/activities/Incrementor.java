package activities;

import java.util.ArrayList;
import java.util.List;

public class Incrementor {
    private int count; 

    public int getCount() {
        return count;
    }

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        int numOfInc = 100000;

        Incrementor count = new Incrementor();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int n = 0; n < numOfInc; n++) {
                    count.increment();
                }
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(count.getCount());
    }
}
