package activities;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private static final Random RNG = new Random(1);

    private List<String> queue;
    private int id;

    public Producer (int id, List<String> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        int messageNumber = 1;
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            int numMsgs = RNG.nextInt(4) + 1;
            synchronized(queue) {
                for (int i = 0; i < numMsgs; i++) {
                    String message = "Producer " + id + ": message #" + messageNumber;
                    queue.add(message);
                    messageNumber++;
                }
                queue.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        List<String> queue = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer(i, queue);
            Thread cThread = new Thread(consumer);
            cThread.start();
        }

        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer(i, queue);
            Thread pThread = new Thread(producer);
            pThread.start();
        }
    }
}
