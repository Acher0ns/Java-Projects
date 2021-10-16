/**
 * Created for assignment 6.2
 * create graph of strings object from a text file
 * 
 * @author Kamron Cole
 */
package assignment6_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import graphs.AdjacencyGraph;
import graphs.Graph;

public class GraphReader {
    /**
     * Create a Graph of strings by reading a text file
     * @param filename containing graph vertices
     * @return Graph of strings
     */
    public static Graph<String> readGraph(String filename){
        Graph<String> graph = new AdjacencyGraph<String>();

        try(FileReader file = new FileReader(filename); BufferedReader reader = new BufferedReader(file);) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                String first = tokens[0];
                if (first != "#") {
                    for (int i = 0; i < tokens.length; i++) {
                        if (!graph.contains(tokens[i])) {
                            graph.add(tokens[i]);
                        }
                        
                        if (i > 0) {graph.connectUndirected(first, tokens[i]);}
                    }
                }
            }
            reader.close();
            file.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return graph;
    }

    /**
     * Manually test readGraph
     * @param args
     */
    public static void main(String[] args) {
        String filePath = "C:/Users//Kamron/Documents/GitHub/SoftDevII/Unit06/data/a_6_1.txt";
        Graph<String> graph = readGraph(filePath);
        System.out.println(graph.contains("A"));
        System.out.println(graph.contains("B"));
        System.out.println(graph.contains("C"));
        System.out.println(graph.contains("D"));
        System.out.println(graph.contains("E"));
        System.out.println(graph.contains("F"));
        System.out.println(graph.connected("A", "F"));
        System.out.println(graph.connected("B", "F"));
        System.out.println(graph.connected("C", "F"));
        System.out.println(graph.connected("D", "F"));
        System.out.println(graph.connected("E", "F"));
        System.out.println(graph.connected("F", "B"));
    }
}