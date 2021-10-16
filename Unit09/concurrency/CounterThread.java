package concurrency;

public class CounterThread extends Thread {
    private final String name;

    public CounterThread (String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            System.out.println(this.name + " : " + i);
        }
    }

    public static void main(String[] args) {
        CounterThread ct = new CounterThread("counter");
        ct.start();

        while (ct.isAlive());
        {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.err.println("Interrupted!");
            }
        }

        for(char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch + " ");
        }

        System.out.println();
        
        try {
            ct.start();
        } catch (IllegalThreadStateException itse) {
            System.out.println("Thread is dead and can't be started again.");
        }
    }
}
