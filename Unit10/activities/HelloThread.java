package activities;

import java.util.LinkedList;
import java.util.List;

public class HelloThread implements Runnable {
    private final int id;

    public HelloThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Hello, World!");
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        List<Thread> threads = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new HelloThread(i));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {}
        }
        System.out.println("Goodbye!");
    }
}
