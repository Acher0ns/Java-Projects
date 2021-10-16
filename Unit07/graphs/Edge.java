package graphs;

public class Edge<T> implements Comparable<Edge<T>> {
    private WVertex<T> from;
    private WVertex<T> to;
    private double weight;

    public Edge(WVertex<T> from, WVertex<T> to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge<T> o) {
        return this.weight <= o.weight ? -1 : 1;
    }

    public WVertex<T> getFrom() {
        return from;
    }

    public WVertex<T> getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }
}
