package activities;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TheCount implements Runnable {
    //private static Object lock = new Object();

    private static AtomicInteger COUNT = new AtomicInteger(0);
    private int id;

    public TheCount(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting counter " + this.id);
        for (int i = 0; i < 100000; i++) {
            //synchronized(lock) {
            COUNT.incrementAndGet();
            //}
        }
        System.out.println("Stopping counter " + this.id);
    }

    public static void main(String[] args) {
        List<Thread> threads = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            TheCount counter = new TheCount(i);
            Thread thread = new Thread(counter);
            thread.start();
            threads.add(thread);
        }
        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (Exception e) {}
        }
        System.out.println(COUNT);
    }
}
