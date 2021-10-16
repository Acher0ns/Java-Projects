package concurrency;

public class AnonymousCounter {
    private static void counter(String name) {
        for (int i = 1; i < 101; i++) {
            System.out.println(name + " - " + i);
        }
    }

    public static void main(String[] args) {
        final int COUNTERS = 5;

        for (int i = 0; i <= COUNTERS; i++) {
            Thread countThread = null;
            String name = "Counter " + i;
            if (i % 2 == 0) {
                countThread = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        counter(name);
                    }
                });
            } else {
                countThread = new Thread(() -> counter(name));
            }
            countThread.start();
        }
    }
}
