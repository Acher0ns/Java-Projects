/**
 * Created for assignment 7.1
 * Contains method to find mother vertices in a graph (vertices with a path to all other vertices)
 * 
 * @author Kamron Cole
 */
package assignment7_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import graphs.AdjacencyGraph;
import graphs.Graph;

public class Mothers {
    /**
     * Find mother vertices in a graph
     * @param graph graph to check for mother vertecies
     * @param values values in given graph
     * @return a list of mother vertices in a graph
     * 
     * Values should be a HashSet<String>
     */
    public static List<String> findMothers(Graph<String> graph, List<String> values) {
        List<String> mothers = new LinkedList<>();
        List<String> visited = new LinkedList<>();

        for (String value1 : values) {
            boolean isMother = true;

            // Check that value is in the graph
            // Fixes issue where element in values is not in the graph is returned as a mother
            if (!graph.contains(value1)) {
                continue;
            }

            // Fixes issue if values List has duplicate values
            if (!visited.contains(value1)) {
                visited.add(value1);
                // Loop to check that value1 has a path to every other value in the graph
                for (String value2 : values) {

                    // Check that value is in the graph
                    // Fixes issue where element in values is not in the graph is returned as a mother
                    if (!graph.contains(value2)) {
                        continue;
                    }

                    if (!value1.equals(value2) && graph.bfPath(value1, value2) == null) {
                        isMother = false;
                        break;
                    }
                }
            } else {
                isMother = false;
            }

            if (isMother) {
                mothers.add(value1);
            }
        }
        return mothers;
    }

    public static void main(String[] args) {
        Graph<String> graph1 = new AdjacencyGraph<>();
        graph1.add("A");
        graph1.add("B");
        graph1.add("C");
        graph1.add("D");
        graph1.add("E");

        graph1.connectDirected("A", "B");
        graph1.connectDirected("B", "C");
        graph1.connectDirected("C", "D");
        graph1.connectDirected("B", "E");
        graph1.connectDirected("E", "A");

        System.out.println(findMothers(graph1, Arrays.asList(new String[] {"A", "B", "C", "D", "E", "F"})));

        Graph<String> graph2 = new AdjacencyGraph<>();
        graph2.add("T");
        graph2.add("U");
        graph2.add("V");
        graph2.add("W");
        graph2.add("X");
        graph2.add("Y");
        graph2.add("Z");

        graph2.connectDirected("T", "V");
        graph2.connectDirected("X", "T");
        graph2.connectDirected("X", "U");
        graph2.connectDirected("Z", "U");
        graph2.connectDirected("Z", "Y");
        graph2.connectDirected("Y", "X");
        graph2.connectDirected("Y", "W");
        graph2.connectDirected("W", "T");

        System.out.println(findMothers(graph2, Arrays.asList(new String[] {"T", "U", "V", "W", "X", "Y", "Z", "Z"})));
    }
}
