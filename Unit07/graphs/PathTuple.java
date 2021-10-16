package graphs;

public class PathTuple<T> {
    private static final double INFINITY = Double.MAX_VALUE;
    private WVertex<T> vertex;
    private WVertex<T> predecessor;
    private double distance;

    public PathTuple (WVertex<T> vertex) {
        this.vertex = vertex;
        this.predecessor = null;
        this.distance = INFINITY;
    }

    @Override
    public String toString() {
        String strDistance = isDistanceInfinity() ? "infinity" : String.valueOf(distance);
        return vertex + ":(" + predecessor + ", " + strDistance + ")";
    
    }

    public void update(WVertex<T> predecessor, double distance) {
        if (distance < this.distance) {
            this.predecessor = predecessor;
            this.distance = distance;
        }
    }

    public boolean isDistanceInfinity() {
        return distance == INFINITY;
    }
    
    public WVertex<T> getVertex() {
        return vertex;
    }

    public double getDistance() {
        return distance;
    }

    public WVertex<T> getPredecessor() {
        return predecessor;
    }
}
