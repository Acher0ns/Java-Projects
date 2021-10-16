package graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WVertex<T> {
    private T value;
    private Map<WVertex<T>, Edge<T>> neighbors;

    public WVertex(T value) {
        this.value = value;
        neighbors = new HashMap<>();
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public void connect(WVertex<T> neighbor, double weight) {
        Edge<T> edge = new Edge<>(this, neighbor, weight);
        neighbors.put(neighbor, edge);
    }

    public Edge<T> edge(WVertex<T> neighbor) {
        return neighbors.get(neighbor);
    }

    public Set<Edge<T>> edges() {
        Set<Edge<T>> edges = new TreeSet<>();
        for (WVertex<T> neighbor : neighbors.keySet()) {
            edges.add(neighbors.get(neighbor));
        }
        return edges;
    }

    public T getValue() {
        return value;
    }
}
