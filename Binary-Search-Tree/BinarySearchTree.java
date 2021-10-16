/**
 * Created for assignment 5.2
 * Node based implementation for a BinarySearchTree (sorted BinaryTree)
 * 
 * @author Kamron Cole
 */
package BST;

public class BinarySearchTree<T extends Comparable<T>> {
    private BinaryNode<T> root;
    private int size;

    /**
     * Constructor
     * @param value initial root value
     */
    public BinarySearchTree(T value) {
        root = new BinaryNode<T>(value);
        
        this.size = 1;
    }

    /**
     * @return number of value in BinarySearchTree
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return infixTraversal(root, "");
    }

    /**
     * Helper method for toString
     * @param node current node in recursive loop
     * @param tree result string
     * @return string for of binary tree (all values ordered in infix order (left -> right) separated by a space)
     */
    private String infixTraversal(BinaryNode<T> node, String tree) {
        if (node.getLeft() != null) {
            tree += node.getLeft().infixTraversal();
        }

        tree += node.getValue() + " ";

        if (node.getRight() != null) {
            tree += node.getRight().infixTraversal();
        }
        return tree;
    }

    /**
     * Helper method for insert.
     * @param node current node in recursive loop
     * @param value value being inserted
     * @return new root node.
     */
    private BinaryNode<T> insert(BinaryNode<T> node, T value) {
        if (node == null) {
            return new BinaryNode<>(value);
        }
    
        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(insert(node.getRight(), value));
        } else {
            if (node.getRight() != null) {
                node.setRight(insert(node.getRight(), value));
            } else {
                node.setRight(new BinaryNode<>(value));
            }
        }
        return node;
    }

    /**
     * insert value into BinarySearchTree
     * @param value to insert
     */
    public void insert(T value) {
        root = insert(root, value);
        size++;
    }

    /**
     * Helper method for search.
     * @param node current node in recursive loop
     * @param value value being searched for
     * @return true if the target is found and false otherwise.
     */
    private boolean search(BinaryNode<T> node, T target) {
        if (node == null) {
            return false;
        } 
        if (target == node.getValue()) {
            return true;
        } 
        return target.compareTo(node.getValue()) < 0 ? search(node.getLeft(), target) : search(node.getRight(), target);
    }

    /**
     * Searches the tree for a target value
     * @param target value to search for in the tree
     * @return true if the target is found and false otherwise
     */
    public boolean search(T target) {
        return search(root, target);
    }

    /**
     * Creates a pokedex of Pokemon using a BinarySearchTree
     * @param args
     */
    public static void main(String[] args) {
        // BinarySearchTree<Integer> bt = new BinarySearchTree<>(10);
        // bt.insert(5);
        // bt.insert(15);
        // bt.insert(1);
        // bt.insert(10);
        // System.out.println(bt);
        // System.out.println(bt.search(0));
        // System.out.println(bt.search(1));

        BinarySearchTree<Pokemon> pokedex = new BinarySearchTree<>(new Pokemon(1, "bulbasaur"));
        pokedex.insert(new Pokemon(130,"gyrados"));
        pokedex.insert(new Pokemon(4,"charmander"));
        pokedex.insert(new Pokemon(7,"squirtle"));
        pokedex.insert(new Pokemon(129,"magicarp"));
        pokedex.insert(new Pokemon(26,"raichu"));

        // Collections.sort(pokedex);
        System.out.println (pokedex);
    }
}
