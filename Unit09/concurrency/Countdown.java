package concurrency;

public class Countdown implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i != 0; i--) {
            System.out.println("T-"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted!");
            }
        }

        System.out.println("Liftoff!");

        for (int i = 1; i < 4; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted!");
            }
        }
    }

    public static void main(String[] args) {
        Thread countdown = new Thread(new Countdown());
        countdown.start();
    }
}
