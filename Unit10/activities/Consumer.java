package activities;

import java.util.LinkedList;
import java.util.List;

public class Consumer implements Runnable {
    private List<String> queue;
    private int id;

    public Consumer(int id, List<String> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String message = null;
            synchronized(queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {}
                }
                message = queue.remove(0);
            }
            System.out.println("Consumer " + id + " - " + message);
        }
    }

    public static void main(String[] args) {
        List<String> queue = new LinkedList<>();
        queue.add("First Message");
        queue.add("Second Message");

        Consumer consumer = new Consumer(0, queue);
        Thread thread = new Thread(consumer);
        thread.start();
    }
}
