package concurrency;

import java.util.LinkedList;
import java.util.List;

public class ListAdder implements Runnable {
    private List<Integer> sharedList;
    private int num;

    public ListAdder(List<Integer> sharedList, int num) {
        this.sharedList = sharedList;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            sharedList.add(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> theList = new LinkedList<>();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(new ListAdder(theList , 50));
            threads[i].start();
        }

        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        System.out.println("Shared List has " + theList.size() + " elements.");
    }
}
