package graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * A priority queue for path tuples. Because the path tuples change after being
 * added to the queue, a linear search is necessary to find the tuple with the
 * shortest distance when dequeueing.
 */
public class TupleQueue<E> {

    private final List<PathTuple<E>> queue;

    /**
     * Creates an empty tuple queue.
     */
    public TupleQueue() {
        queue = new LinkedList<>();
    }

    /**
     * Adds the specified path tuple to the queue.
     * 
     * @param element The tuple queue to add to the queue.
     */
    public void enqueue(PathTuple<E> element) {
        queue.add(element);        
    }

    /**
     * Removes and returns the path tuple with the shortest distance from the
     * start vertex.
     * 
     * @return The path tuple with the shortest distance from start.
     */
    public PathTuple<E> dequeue() {
        PathTuple<E> shortest = queue.get(0);
        int index = 0;

        for(int i=1; i<queue.size(); i++) {
            PathTuple<E> pt = queue.get(i);
            if(pt.getDistance() < shortest.getDistance()) {
                shortest = pt;
                index = i;
            }
        }

        queue.remove(index);

        return shortest;
    }

    /**
     * Returns the number of path tuples currently in the queue.
     * 
     * @return The number of path tuples currently in the queue.
     */
    public int size() {
        return queue.size();
    }
    
}
