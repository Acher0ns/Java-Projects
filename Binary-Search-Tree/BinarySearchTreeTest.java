/**
 * Created for assignment 5.2
 * JUnit tests for a BinarySearchTree
 * 
 * @author Kamron Cole
 */
package BST;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class BinarySearchTreeTest {
    @Test
    public void testConstructor() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(10);

        assertEquals(bst.size(), 1);
        assertEquals(bst.search(10), true);
    }

    @Test
    public void testInsert() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(10);
        bst.insert(1);
        bst.insert(15);
        bst.insert(10);

        assertEquals(bst.size(), 4);
        assertEquals(bst.search(1), true);
        assertEquals(bst.search(15), true);
        assertEquals(bst.search(10), true);
        assertEquals(bst.toString(), "1 10 10 15 ");
    }
}
