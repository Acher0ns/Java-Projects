/**
 * Created for assignment 7.1
 * Creates a graph of film names and 3 of there cast/crew members
 * At least 1 cast/crew member is in common with each film
 * Prints 4 paths showing how they are connected
 * 
 * @author Kamron Cole
 */
package assignment7_1;

import graphs.AdjacencyGraph;
import graphs.Graph;

public class SixDegrees {
    public static void main(String[] args) {
        Graph<String> graph = new AdjacencyGraph<>();

        graph.add("Arrival");
        graph.add("Amy Adams");
        graph.add("Jeremy Renner");
        graph.add("Forest Whitaker");

        graph.add("American Hustle");
        graph.add("Christian Bale");
        graph.add("Jennifer Lawrence");

        graph.add("The Hunger Games");
        graph.add("Liam Hemsworth");
        graph.add("Willow Shields");



        graph.connectUndirected("Arrival", "Amy Adams");
        graph.connectUndirected("Arrival", "Jeremy Renner");
        graph.connectUndirected("Arrival", "Forest Whitaker");

        graph.connectUndirected("American Hustle", "Amy Adams");
        graph.connectUndirected("American Hustle", "Christian Bale");
        graph.connectUndirected("American Hustle", "Jennifer Lawrence");

        graph.connectUndirected("The Hunger Games", "Jennifer Lawrence");
        graph.connectUndirected("The Hunger Games", "Liam Hemsworth");
        graph.connectUndirected("The Hunger Games", "Willow Shields");

        System.out.println(graph.bfPath("Amy Adams", "Liam Hemsworth"));
        System.out.println(graph.bfPath("Willow Shields", "Christian Bale"));
        System.out.println(graph.bfPath("Forest Whitaker", "Jennifer Lawrence"));
        System.out.println(graph.bfPath("Jeremy Renner", "Amy Adams"));
    }
}