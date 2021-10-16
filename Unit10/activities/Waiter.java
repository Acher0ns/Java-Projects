package activities;

public class Waiter implements Runnable {
    public final Object lock;

    public Waiter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock) {
            System.out.println("Got the lock");
            try {
                lock.wait();
                // lock.notify();
            } catch (Exception e) {}
            System.out.println("Done Waiting");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        for (int i = 0; i < 10; i++) {
            Waiter waiter = new Waiter(lock);
            Thread thread = new Thread(waiter);
            thread.start();
        }
        
        Thread.sleep(100);
        synchronized(lock) { 
            lock.notifyAll();
        }
        System.out.println("Thread Notified");
    }
}
