package activities;

public class NameThread implements Runnable {
    private final String name;
    private final int index;
    private final Thread previous;

    public NameThread(String name, int index, Thread previous) {
        this.name = name;
        this.index = index;
        this.previous = previous;
    }

    @Override
    public void run() {
        if (previous != null) {
            try {
                previous.join();
            } catch (InterruptedException e) {}
        }
        System.out.print(name.charAt(index));
    }

    public static void main(String[] args) {
        String name = "Kamron";
        Thread previous = null;
        for (int i = 0; i < name.length(); i++) {
            Thread nameThread = new Thread(new NameThread("Kamron", i, previous));
            previous = nameThread;
            previous.start();
        }
        try {
            previous.join();
        } catch (InterruptedException e) {}
        System.out.print("!");
    }
}
