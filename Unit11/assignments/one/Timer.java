import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Times adding a number of values to a vector list and an array list
 * 
 * Vector list is slower most of the time. This is most likely because Vectors are thread safe (synchronize)
 * Another reason could be because they differ in resizing methods. Since both internally use arrays to hold data,
 * when data is added they need to grow. ArrayList increases size by 50% its current size, vector increases size by 100%.
 */
public class Timer {
    public static void listTimer(String name, List<Integer> list, int numOfValues) {
        long start = System.nanoTime();
        for (int i = 0; i < numOfValues; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        long elapsed = end - start;

        System.out.printf("Filled '%s' with %d in %s nanoseconds.%n", name, numOfValues, String.format("%,d", elapsed));
    }

    public static void main(String[] args) {
        int numOfValues = 100000000;
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> vectorList = new Vector<>();

        new Thread(() -> {
            listTimer("Array List", arrayList, numOfValues);
        }).start();

        new Thread(() -> {
            listTimer("Vector List", vectorList, numOfValues);
        }).start();
    }
}