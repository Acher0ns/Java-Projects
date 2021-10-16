package concurrency;

public class RunnableCounter implements Runnable {
    private final String name;

    public RunnableCounter (String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            // System.out.println(name + " : " + i);
        }
        System.out.println(name + ": Finished");
    }

    public static void main(String[] args) {
        RunnableCounter runnableCounter = new RunnableCounter("counter1");
        Thread counterThread = new Thread(runnableCounter);
        counterThread.start();
    }
}
