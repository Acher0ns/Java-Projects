package graphs;

import bst.BinaryNode;

public class BstAsGraph {
    public static BinaryNode makeBST(int[] array) {
        BinaryNode node = new BinaryNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            node.binaryInsert(array[i]);
        }
        return node;
    }

    public static Graph<Integer> convertToGraph(BinaryNode bst) {
        Graph<Integer> graph = new AdjacencyGraph<>();
        for (String value : bst.infixTraversal().split(" ")) {
            int num = Integer.parseInt(value);
            graph.add(num);
        }
        connectValues(bst, graph);
        return graph;
    }

    private static void connectValues(BinaryNode bst, Graph<Integer> graph) {
        if (bst.getLeft() == null && bst.getRight() == null) {
            return;
        }

        if (bst.getLeft() != null) {
            graph.connectUndirected(bst.getValue(), bst.getLeft().getValue());
            connectValues(bst.getLeft(), graph);
        }

        if (bst.getRight() != null) {
            graph.connectUndirected(bst.getValue(), bst.getRight().getValue());
            connectValues(bst.getRight(), graph);
        }
    }

    public static void main(String[] args) {
        BinaryNode bst = makeBST(new int[] {50, 25, 95, 80, 3, 10, 1, 8, 2, 100});
        Graph<Integer> graph = convertToGraph(bst);
        System.out.println(graph.bfPath(1, 100));
    }
}
