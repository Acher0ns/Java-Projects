package graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import bst.BinaryNode;

@Testable
public class BstAsGraphTest {
    @Test
    public void testMakeBST() {
        int[] array = new int[] {4, 7, 2, 5, 1, 8, 3};
        BinaryNode BST = BstAsGraph.makeBST(array);
        Arrays.sort(array);

        assertEquals(Arrays.toString(array), Arrays.toString(BST.infixTraversal().split(" ")));
    }

    @Test
    public void testConvertToGraph() {
        int[] array = new int[] {4, 7, 2, 5, 1, 8, 3};
        BinaryNode BST = BstAsGraph.makeBST(array);
        Graph<Integer> graph = BstAsGraph.convertToGraph(BST);

        assertEquals(graph.bfPath(1, 8).toString(), Arrays.toString(new int[] {1, 2, 4, 7, 8}));
        assertEquals(graph.bfPath(1, 3).toString(), Arrays.toString(new int[] {1, 2, 3}));
        assertFalse(graph.connected(1, 3));
        assertFalse(graph.connected(1, 4));
        assertFalse(graph.connected(1, 5));
        assertFalse(graph.connected(1, 7));
        assertFalse(graph.connected(1, 8));

        assertFalse(graph.connected(2, 5));
        assertFalse(graph.connected(2, 7));
        assertFalse(graph.connected(2, 8));

        assertFalse(graph.connected(3, 1));
        assertFalse(graph.connected(3, 4));
        assertFalse(graph.connected(3, 5));
        assertFalse(graph.connected(3, 7));
        assertFalse(graph.connected(3, 8));

        assertFalse(graph.connected(4, 1));
        assertFalse(graph.connected(4, 3));
        assertFalse(graph.connected(4, 5));
        assertFalse(graph.connected(4, 8));

        assertFalse(graph.connected(5, 1));
        assertFalse(graph.connected(5, 2));
        assertFalse(graph.connected(5, 3));
        assertFalse(graph.connected(5, 4));
        assertFalse(graph.connected(5, 8));

        assertFalse(graph.connected(7, 1));
        assertFalse(graph.connected(7, 2));
        assertFalse(graph.connected(7, 3));

        assertFalse(graph.connected(8, 1));
        assertFalse(graph.connected(8, 2));
        assertFalse(graph.connected(8, 3));
        assertFalse(graph.connected(8, 4));
        assertFalse(graph.connected(8, 5));
    }
}
