package ds;

import java.util.Arrays;

/**
 * An array-based implementation of a heap. This version is always a min-heap 
 * (the smallest integer is the highest priority).
 * 
 * @author GCCIS Faculty.
 */
public class ArrayHeap implements Heap {
    /**
     * The array used to store the values in the heap. Some indexes may not be
     * used.
     */
    private int[] array;

    /**
     * The number of values currently in the heap.
     */
    private int size;

    /**
     * Creates a new, empty array-based heap.
     */
    public ArrayHeap() {
        array = new int[3];
        size = 0;
    }

    @Override
    public void add(int value) {
        // add pt 1
        if(size == array.length) {
            array = Arrays.copyOf(array, size*2);
        }
        array[size] = value;
        
        // sifting up
        int child = size;
        int parent = (child - 1) / 2;
        while(array[parent] > array[child]) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }

        size++; // don't forget!
    }

    @Override
    public int remove() {
        // most of part 1
        int temp = array[0];
        size--;
        swap(0, size);
        array[size] = 0;

        // sifting down
        int parent = 0;
        while(parent < size) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int dest = parent;
            if(left < size) {
                dest = left;
            }
            if(right < size && array[right] < array[left]) {
                dest = right;
            }
            if(array[dest] < array[parent]) {
                swap(dest, parent);
                parent = dest;
            } else {
                break;
            }
        }

        // last bit of part 1
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(array) + ", " + size;
    }

    /**
     * Helper function that swaps the values at the two specified indexes if
     * the indexes are different.
     * 
     * @param a The first index.
     * @param b The second index.
     */
    private void swap(int a, int b) {
        if(a != b) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }

    /**
     * Tests the class by making a heap, adding several values, and then
     * removing the values.
     * 
     * @param args Command line arguments. Ignored.
     */
    public static void main(String[] args) {
        Heap heap = new ArrayHeap();

        System.out.println(heap);

        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(1);

        System.out.println(heap);

        System.out.println(heap.remove() + ", " + heap);
        System.out.println(heap.remove() + ", " + heap);
        System.out.println(heap.remove() + ", " + heap);
        System.out.println(heap.remove() + ", " + heap);
        System.out.println(heap.remove() + ", " + heap);
    }
    
}
