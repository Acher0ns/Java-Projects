package activities;

public class Deadlock implements Runnable {
    private final int id;
    private final Object lock1;
    private final Object lock2;
    
    public Deadlock(int id, Object lock1, Object lock2) {
        this.id = id;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public String toString() {
        return "Deadlock #" + id;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this + " getting lock: " + lock1);
            synchronized(lock1) {
                System.out.println(this + " got " + lock1 + ", getting " + lock2);
                synchronized(lock2) {
                    System.out.println(this + " got both locks");
                }
                System.out.println(this + " released " + lock2);
            }
            System.out.println(this + " released " + lock1);
        }
    }

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Deadlock d1 = new Deadlock(1, lock1, lock2);
        Deadlock d2 = new Deadlock(2, lock2, lock1);

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);

        t1.start();
        t2.start();
    }
}
