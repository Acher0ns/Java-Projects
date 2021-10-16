package assignment6_1;

import ds.Queue;
import ds.ArrayHeap;

public class HeapPQ implements Queue<Integer> {
    private ArrayHeap elements;
    private int size;

    public HeapPQ() {
        this.elements = new ArrayHeap();
        this.size = 0;
    }

    @Override
    public Integer dequeue() {
        size--;
        return elements.remove();
    }

    @Override
    public void enqueue(Integer value) {
        size++;
        elements.add(value);
    }

    @Override
    public int size() {
        return size;
    }
}
