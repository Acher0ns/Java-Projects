package graphs;

/**
 * A path tuple used to keep track of each vertex, its predecessor, and the 
 * total distance from start when using Dijkstra's Algorithm.
 * 
 * @autho GCCIS Faculty
 */
public class PathTuple<E> {
    private final WVertex<E> vertex;
    private WVertex<E> predecessor;
    private double distance;

    /**
     * Creates a new path tuple for the specified vertex.
     * @param vertex The vertex to which this path tuple belongs.
     */
    public PathTuple(WVertex<E> vertex) {
        this.vertex = vertex;
        this.predecessor = null;
        this.distance = Double.MAX_VALUE;
    }

    public WVertex<E> getVertex() {
        return vertex;
    }

    public WVertex<E> getPredecessor() {
        return predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void update(WVertex<E> predecessor, double distance) {
        if(distance < this.distance) {
            this.predecessor = predecessor;
            this.distance = distance;
        }
    }

    @Override
    public String toString() {
        String string = vertex + ":(" + predecessor + ", ";

        if(distance < Double.MAX_VALUE) {
            string += distance;
        } else {
            string += "infinity";
        }
        string += ")";
        return string;

    }   
}
