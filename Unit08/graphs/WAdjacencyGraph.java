package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An adjacency list implementation of a weighted graph.
 * 
 * @author GCCIS Faculty
 */
public class WAdjacencyGraph<E> implements WGraph<E> {
    private final Map<E, WVertex<E>> vertices;
    
    /**
     * Creates a new, empty graph.
     */
    public WAdjacencyGraph() {
        vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        WVertex<E> vertex = new WVertex<>(value);
        vertices.put(value, vertex);
    }

    @Override
    public boolean contains(E value) {
        return vertices.containsKey(value);
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connect(E a, E b, double weight) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        vertexA.connect(vertexB, weight);
        vertexB.connect(vertexA, weight);

        if(a.equals("E") && b.equals("G")) {
            System.out.println(a + " = " + vertexA.edges());
            System.out.println(b + " = " + vertexB.edges());
        }

    }

    @Override
    public boolean connected(E a, E b) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB) != null;
    }

    @Override
    public double weight(E a, E b) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB).getWeight();
    }

    @Override
    public WPath<E> nearestNeighbors(E start, E end) {
        WVertex<E> s = vertices.get(start);
        WVertex<E> e = vertices.get(end);

        Set<WVertex<E>> visited = new HashSet<>();
        visited.add(s);

        return visitNearestNeighbor(s, e, visited);
    }

    private WPath<E> visitNearestNeighbor(WVertex<E> v, WVertex<E> e, 
        Set<WVertex<E>> visited) {
        if(v == e) {
            WPath<E> path = new WPath<>(e.getValue());
            return path;
        } else {
            for(Edge<E> edge : v.edges()) {
                WVertex<E> neighbor = edge.getTo();
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    WPath<E> path = visitNearestNeighbor(neighbor, e, visited);
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
    public WPath<E> dijkstrasPath(E start, E end) {
        // step 1: setup
        WVertex<E> startV = vertices.get(start);
        WVertex<E> endV = vertices.get(end);

        Map<WVertex<E>, PathTuple<E>> tuples = new HashMap<>();
        TupleQueue<E> queue = new TupleQueue<>();

        for(E value : vertices.keySet()) {
            WVertex<E> vertex = vertices.get(value);
            PathTuple<E> tuple = new PathTuple<>(vertex);
            tuples.put(vertex, tuple);
            queue.enqueue(tuple);
        }

        PathTuple<E> startTuple = tuples.get(startV);
        startTuple.update(null, 0);

        // setp 2: the main loop
        while(queue.size() > 0) {
            PathTuple<E> tuple = queue.dequeue();
            if(tuple.getDistance() == Double.MAX_VALUE) {
                break;
            }

            WVertex<E> v = tuple.getVertex();
            for(Edge<E> edge : v.edges()) {
                WVertex<E> n = edge.getTo();
                PathTuple<E> nTuple = tuples.get(n);

                double dsv = tuple.getDistance() + edge.getWeight();
                nTuple.update(v, dsv); 
            }
        }

        // step 3: build the path

        PathTuple<E> endTuple = tuples.get(endV);
        if(endTuple.getDistance() == Double.MAX_VALUE) {
            return null;
        }
        WPath<E> path = new WPath<>(endV.getValue());
        double distance = endTuple.getDistance();
        WVertex<E> v = endTuple.getPredecessor();

        while(v != null) {
            path.prepend(v.getValue(), distance);
            distance = 0;
            PathTuple<E> vTuple = tuples.get(v); 
            v = vTuple.getPredecessor();
        }

        return path;
    }
}
