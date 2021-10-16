package graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * A vertex in a weighted adjacency graph.
 * 
 * @author GCCIS Faculty
 */
public class WVertex<E> {
    private E value;
    private final Map<WVertex<E>, Edge<E>> neighbors;    

    /**
     * Creates a new vertex with the specified value.
     * 
     * @param value The value contained by the new vertex.
     */
    public WVertex(E value) {
        this.value = value;
        neighbors = new HashMap<>();
    }

    public E getValue() {
        return value;
    }

    /**
     * Connects the vertex to a neighbor with an edge of the specified weight.
     * 
     * @param neighbor The neighbor to which this vertex is being connected.
     * @param weight The weight of the edge to the neighbor.
     */
    public void connect(WVertex<E> neighbor, double weight) {
        Edge<E> edge = new Edge<>(this, neighbor, weight);
        neighbors.put(neighbor, edge);
    }   

    /**
     * Returns a set of edges connected to neighbors.
     * 
     * @return A set of edges connected to neighbors.
     */
    public Set<Edge<E>> edges() {
        Set<Edge<E>> edges = new TreeSet<>();
        for(WVertex<E> neighbor : neighbors.keySet()) {
            edges.add(neighbors.get(neighbor));
        }
        return edges;
    }

    /**
     * Returns the edge to the specified neighbor.
     * 
     * @param neighbor The neighbor to which the edge is connected.
     * 
     * @return The edge between this vertex and the specified neighbor.
     */
    public Edge<E> edge(WVertex<E> neighbor) {
        return neighbors.get(neighbor);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
