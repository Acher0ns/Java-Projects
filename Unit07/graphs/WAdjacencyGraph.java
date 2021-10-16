package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class WAdjacencyGraph<T> implements WGraph<T> {

    private Map<T, WVertex<T>> vertices;
    
    public WAdjacencyGraph() {
        vertices = new HashMap<>();
    }

    @Override
    public void add(T value) {
        WVertex<T> vertex = new WVertex<>(value);
        vertices.put(value, vertex);

    }

    @Override
    public boolean contains(T value) {
        return vertices.containsKey(value);
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connect(T a, T b, double weight) {
        WVertex<T> vertexA = vertices.get(a);
        WVertex<T> vertexB = vertices.get(b);
        vertexA.connect(vertexB, weight);
        vertexB.connect(vertexA, weight);
    }

    @Override
    public boolean connected(T a, T b) {
        WVertex<T> vertexA = vertices.get(a);
        WVertex<T> vertexB = vertices.get(b);
        return vertexA.edge(vertexB) != null;
    }

    @Override
    public double weight(T a, T b) {
        WVertex<T> vertexA = vertices.get(a);
        WVertex<T> vertexB = vertices.get(b);
        return vertexA.edge(vertexB).getWeight();
    }

    @Override
    public WPath<T> nearestNeighbors(T start, T end) {
        WVertex<T> s = vertices.get(start);
        WVertex<T> e = vertices.get(end);
    
        Set<WVertex<T>> visited = new HashSet<>();
        visited.add(s);
    
        return visitNearestNeighbors(s, e, visited);
    }

    private WPath<T> visitNearestNeighbors(WVertex<T> v, WVertex<T> e, Set<WVertex<T>> visited) {
        if(v == e) {
            WPath<T> path = new WPath<>(e.getValue());
            return path;
        } else {
            for(Edge<T> edge : v.edges()) {
                WVertex<T> neighbor = edge.getTo();
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    WPath<T> path = visitNearestNeighbors(neighbor, e, visited);
                    if(path != null) {
                        path.prepend(v.getValue(), edge.getWeight());
                        return path;
                    }
                }
            }
            return null;
        }
    }

    @Override
    public WPath<T> dijkstrasPath(T start, T end) {
        Map<WVertex<T>,PathTuple<T>> tuples = new HashMap<>();
        TupleQueue<T> queue = new TupleQueue<>();

        WVertex<T> s = vertices.get(start);
        WVertex<T> e = vertices.get(end);

        for (T value : vertices.keySet()) {
            WVertex<T> v = vertices.get(value);
            PathTuple<T> tuple = new PathTuple<>(v);
            tuples.put(v, tuple);
            queue.enqueue(tuple);
        }

        PathTuple<T> pathTuple = tuples.get(s);
        pathTuple.update(null,0);

        while (queue.size() > 0) {
            pathTuple = queue.dequeue();
            if (pathTuple.isDistanceInfinity())
                break;

            WVertex<T> v = pathTuple.getVertex();
            for (Edge<T> edge : v.edges()) {
                WVertex<T> neighbor = edge.getTo();
                double dv = pathTuple.getDistance() + edge.getWeight();
                PathTuple<T> neighborTuple = tuples.get(neighbor);
                if (dv < neighborTuple.getDistance())
                    neighborTuple.update(v,dv);
            }
        }

        PathTuple<T> endTuple = tuples.get(e);

        if (endTuple.isDistanceInfinity())
            return null;

        double distance = endTuple.getDistance();

        WPath<T> path = new WPath<>(e.getValue());
        WVertex<T> v = endTuple.getPredecessor();
        while (v != null) {
            path.prepend(v.getValue(),distance);
            distance = 0;
            PathTuple<T> vTuple = tuples.get(v);
            v = vTuple.getPredecessor();
        }

        return path;
    }
}
