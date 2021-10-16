package ds;

/**
 * Defines the abstract data type for a queue.
 * 
 * @author GCCIS Faculty.
 */
public interface Queue<E> {
    /**
     * Adds a value to the back of the queue.
     * 
     * @param value The value to add to the queue.
     */
    void enqueue(E value);

    /**
     * Removes and returns the value at the front of the queue.
     * 
     * @return The value at the front of the queue.
     */
    E dequeue();

    /**
     * Returns the number of elements currently stored in the queue.
     * 
     * @return The number of elements currently stored in the queue.
     */
    int size();
}