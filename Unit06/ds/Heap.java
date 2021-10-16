package ds;

/**
 * Defines the abstract data type for a heap. 
 * 
 * @author GCCIS Faculty.
 */
public interface Heap {
    /**
     * Adds a value to the heap.
     * 
     * @param value The value to add.
     */
    void add(int value);

    /**
     * Removes and returns the highest priority value currently in the heap.
     * 
     * @return The highest priority value currently in the heap. Also removes
     * the value from the heap.
     */
    int remove();

    /**
     * Returns the number of values currently in the heap.
     * 
     * @return The number of values currently in the heap.
     */
    int size();
}
