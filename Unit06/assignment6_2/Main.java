/**
 * Created for assignment 6.2
 * Manually test countConnectedComponents
 * 
 * @author Kamron Cole
 */
package assignment6_2;

public class Main {
    private static final String DATA_PATH = "C:/Users/Kamron/Documents/GitHub/SoftDevII/Unit06/data/";

    /**
     * Manually test countConnectedComponents
     */
    public static void main(String[] args) {
        System.out.println("a_7_3 Connected Components: " + GraphReader.readGraph(DATA_PATH + "a_7_3.txt").countConnectedComponents());
        System.out.println("a_6_1 Connected Components: " + GraphReader.readGraph(DATA_PATH + "a_6_1.txt").countConnectedComponents());
        System.out.println("a_13_5 Connected Components: " + GraphReader.readGraph(DATA_PATH + "a_13_5.txt").countConnectedComponents());
        System.out.println("a_22_3 Connected Components: " + GraphReader.readGraph(DATA_PATH + "a_22_3.txt").countConnectedComponents());
        System.out.println("a_26_4 Connected Components: " + GraphReader.readGraph(DATA_PATH + "a_26_4.txt").countConnectedComponents());
        System.out.println("bipartite Connected Components: " + GraphReader.readGraph(DATA_PATH + "bipartite.txt").countConnectedComponents());
        System.out.println("k2_2 Connected Components: " + GraphReader.readGraph(DATA_PATH + "k2_2.txt").countConnectedComponents());
        System.out.println("k2 Connected Components: " + GraphReader.readGraph(DATA_PATH + "k2.txt").countConnectedComponents());
        System.out.println("k3_3 Connected Components: " + GraphReader.readGraph(DATA_PATH + "k3_3.txt").countConnectedComponents());
        System.out.println("k3 Connected Components: " + GraphReader.readGraph(DATA_PATH + "k3.txt").countConnectedComponents());
        System.out.println("k4 Connected Components: " + GraphReader.readGraph(DATA_PATH + "k4.txt").countConnectedComponents());
        System.out.println("k5 Connected Components: " + GraphReader.readGraph(DATA_PATH + "k5.txt").countConnectedComponents());
        System.out.println("non_bipartite Connected Components: " + GraphReader.readGraph(DATA_PATH + "non_bipartite.txt").countConnectedComponents());
        System.out.println("v2 Connected Components: " + GraphReader.readGraph(DATA_PATH + "v2.txt").countConnectedComponents());
        System.out.println("v3_3 Connected Components: " + GraphReader.readGraph(DATA_PATH + "v3_3.txt").countConnectedComponents());
    }
}
