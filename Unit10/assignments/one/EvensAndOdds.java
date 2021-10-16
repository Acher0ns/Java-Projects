package assignments.one;

public class EvensAndOdds {
    public static void main(String[] args) {
        Thread evensThread = new Thread(() -> {
            for (int i = 2; i <= 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}
            }
        });

        Thread oddsThread = new Thread(() -> {
            for (int i = 1; i <= 99; i++) {
                if (i % 2 == 1) {
                    System.out.println(i);
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}
            }
        });

        oddsThread.start();
        evensThread.start();
    }
}
