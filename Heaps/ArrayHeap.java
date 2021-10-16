package heaps;

import java.util.Arrays;

public class ArrayHeap implements Heap {
    private final int INIT_SIZE = 3;
    private int[] array;
    private int size;

    public ArrayHeap() {
        array = new int[INIT_SIZE];
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array) + ", " + size;
    }

    @Override
    public void add(int value) {
        if (size == array.length) {
            array = Arrays.copyOf(array, size * 2);
        }

        array[size] = value;
        
        int child = size;
        int parent = (child - 1) / 2;
        while (array[parent] < array[child]) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
        size++;
    }

    @Override
    public int remove() {
        int temp = array[0];
        size--;
        swap(0, size);
        array[size] = 0;

        int parent = 0;
        while (parent < size) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int dest = parent;
            if (left < size) {
                dest = left;
            }

            if (right < size && array[right] > array[left]) {
                dest = right;
            }

            if (array[dest] > array[parent]) {
                swap(dest, parent);
                parent = dest;
            } else {
                break;
            }
        }
        return temp;
    }

    private void swap(int a, int b) {
        if (a != b) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Heap ah = new ArrayHeap();
        for (int i = 1; i < 10; i++) {
            ah.add(i);
        }
        System.out.println(ah);

        for (int i = 1; i < 10; i++) {
            System.out.println(ah.remove());
        }
    }
}
