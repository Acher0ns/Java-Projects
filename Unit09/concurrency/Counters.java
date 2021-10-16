package concurrency;

public class Counters {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            RunnableCounter runnableCounter = new RunnableCounter("Counter " + i);
            Thread counterThread = new Thread(runnableCounter);
            counterThread.start();
            try {
                counterThread.join();
            } catch (InterruptedException e) {
                System.err.println("Interrupted!");
            }
        }
        System.out.println("All done!");
    }
}
