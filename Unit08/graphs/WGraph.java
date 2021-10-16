package graphs;

/**
 * Defines the abstract data type for a weighted graph.
 * 
 * @author GCCIS Faculty
 */
public interface WGraph<E> {
    /**
     * Adds a value to the graph.
     * 
     * @param value The value to add to the graph.
     */
    void add(E value);

    /**
     * Returns true if the graph contains the specified value, and false 
     * otherwise.
     * 
     * @param value The value to check for.
     * 
     * @return True if the graph contains the value, and false otherwise.
     */
    boolean contains(E value);

    /**
     * Returns the number of values in the graph.
     * 
     * @return The number of values in the graph.
     */
    int size();

    /**
     * Connects the specified two values with an edge of the specified weight.
     * 
     * @param a The first of the two values to connect together.
     * @param b The second of the two values to connect together.
     * @param weight The weight of the egde between the two values.
     */
    void connect(E a, E b, double weight);

    /**
     * Returns true of the specified values are connected in the graph.
     * 
     * @param a The first value to check for a connection.
     * @param b The second value to check for a connection.
     * 
     * @return True if the two values are connected, and false otherwise.
     */
    boolean connected(E a, E b);
    double weight(E a, E b);

    /**
     * Performs a nearest neighbors search of the graph. Returns the path, if
     * it exists, that is found by always choosing the next unexplored neighbor
     * connected by the edge with the lowest weight.
     * 
     * @param start The value at which the search should begin.
     * @param end The value at which the search should end.
     * 
     * @return The path, if it exists.
     */
    default WPath<E> nearestNeighbors(E start, E end) {
        throw new UnsupportedOperationException(
            "nearest neighbors not implemented!");
    }

    /**
     * Uses Dijkstra's Algorithm to search of the graph. Returns the path, if
     * it exists.
     * 
     * @param start The value at which the search should begin.
     * @param end The value at which the search should end.
     * 
     * @return The path, if it exists.
     */
    default WPath<E> dijkstrasPath(E start, E end) {
        throw new UnsupportedOperationException(
            "Dijkstra's Path not implemented!");
    }
}
