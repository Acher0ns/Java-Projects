package graphs;

public interface WGraph<T> {
    void add(T value);
    boolean contains(T value);
    int size();
    void connect(T a, T b, double weight);
    boolean connected(T a, T b);
    double weight(T a, T b);
    
    default WPath<T> nearestNeighbors(T start, T end) {
        throw new UnsupportedOperationException("nearestNeighbors is not implemented.");
    }

    default WPath<T> dijkstrasPath(T start, T end) {
        throw new UnsupportedOperationException("dijkstasPath is not implemented.");
    }
}
