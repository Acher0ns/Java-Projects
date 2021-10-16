public class EvensAndOdds {
    public static void main(String[] args) {
        Object printLock = new Object();

        // Thread that prints odds
        new Thread(() -> {
            for (int num = 1; num <= 99; num += 2) {
                synchronized(printLock) {
                    try {
                        System.out.println(num);
                        printLock.notify();
                            
                        if (num < 99) {
                            printLock.wait();
                        }
                    } catch (InterruptedException e) {}
                }
            }
        }).start();

        // Thread that prints evens
        new Thread(() -> {
            for (int num = 2; num <= 100; num += 2) {
                synchronized(printLock) {
                    try {
                        System.out.println(num);
                        printLock.notify();

                        if (num < 100) {
                            printLock.wait();
                        }
                    } catch (InterruptedException e) {}
                }
            }
        }).start();
    }
}
