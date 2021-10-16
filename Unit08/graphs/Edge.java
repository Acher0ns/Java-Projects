package graphs;

/**
 * An edge in a weighted graph.
 */
public class Edge<E> implements Comparable<Edge<E>> {
    private double weight;
    private WVertex<E> from;
    private WVertex<E> to;

    /**
     * Creates a new edge between the specified vertices.
     * 
     * @param from The vertex that the edge connects from.
     * @param to The vertex that the edge connects to.
     * @param weight The weight of the edge.
     */
    public Edge(WVertex<E> from, WVertex<E> to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public WVertex<E> getFrom() {
        return from;
    }

    public WVertex<E> getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    /**
     * Compares two edges in order from lowest to highest weight.
     */
    @Override
    public int compareTo(Edge<E> o) {
        // can't return 0 so use <=
        return this.weight <= o.weight ? -1 : 1;
    }

    @Override
    public String toString() {
        return "Edge{"
            + "from=" + from.getValue()
            + ", to=" + to.getValue()
            + ", weight=" + this.weight
            + "}";
    }
}
