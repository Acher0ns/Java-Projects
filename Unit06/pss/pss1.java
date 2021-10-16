package pss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import graphs.AdjacencyGraph;
import graphs.Graph;

/**
 * Problem Solving 1
 * 
 * Image saved as "pss1_PS1.png"
 */



 /**
  * Problem Solving 2
  */
public class pss1 {
    public static Graph<String> read(String filename) throws IOException {
        Graph<String> graph = new AdjacencyGraph<String>();

        FileReader file = new FileReader(filename);
        BufferedReader reader = new BufferedReader(file);

        String line;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(" ");
            String first = tokens[0];
            for (int i = 1; i < tokens.length; i++) {
                if (!graph.contains(tokens[i])) {
                    graph.add(tokens[i]);
                }
                graph.connectUndirected(first, tokens[i]);
            }
        }
        reader.close();
        file.close();
        return graph;
    }
}

/**
 * Problem Solving 3
 * 
 * 1. Set count = 0
 * 2. Create and empty set.
 * 3. For each vertex V in graph:
 *  a. if V is already in the set, skip it.
 *  b. else
 *   i. add V to set
 *   ii. increment count
 *   iii. make and empty queue and add V to it
 *   iv. run bfs from V (copy paste)
 * 4. return count.
 * 
 * Create map to store paths already searched for and save them, check saved paths prior to searching?
 */

 /**
  * Problem Solving 3
  */
public class pss1 {
    public int countConnectedComponents() {
        Set<Vertex<T>> visited = new HashSet<>();
        int count = 0;
        for(Vertex<T> vertex : vertecies.values()) {
            if(!visited.ontains(vertex)) {
                count += 1;

                Queue<Vertex<T>> queue = new LinkedList<>();
                queue.add(vertex);
                while (!queue.isEmpty()) {
                    Vertex<T> next = queue.poll();
                    for (Vertex<T> neighbor : next.getNeighbors()) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
        return count;
    }
}
