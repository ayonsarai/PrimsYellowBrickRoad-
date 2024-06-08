/* Sarai Ayon
6/7/2024
CS240 Data Structures and Algorithms
Prim's Algorithm
Algorithms HW 9 : Dijkstra's versus Prim's Algorithm */

import java.util.*; 

class PrimsYellowBrickRoad {
    public static void main(String[] args) {
        int[][] graph = { {0, 2, 0, 6, 0},
                          {2, 0, 3, 8, 5},
                          {0, 3, 0, 0, 7},
                          {6, 8, 0, 0, 9},
                          {0, 5, 7, 9, 0} };
        
        findMinSpanningTree(graph);
    } // end main

    // This method finds the minimum spanning tree of a graph using Prim's algorithm.
    // @param graph The input graph represented as an adjacency matrix.
    static void findMinSpanningTree(int[][] graph) {
        int numVertices = graph.length;
        
        // Create arrays to track visited vertices and their parent
        boolean[] visited = new boolean[numVertices];
        int[] parent = new int[numVertices];
        int[] key = new int[numVertices]; // Declare the key array

        // Initialize arrays
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
            parent[i] = -1;
        } // end for

        // Priority queue to store vertices and their corresponding weights
        PriorityQueue<Integer> pq = new PriorityQueue<>(numVertices, Comparator.comparingInt(i -> key[i]));

        // Start with vertex 0
        int source = 0;
        pq.add(source);
        key[source] = 0;
        
        while (!pq.isEmpty()) {
            int u = pq.poll();
            visited[u] = true;
            
            // Iterate through all adjacent vertices of u
            for (int v = 0; v < numVertices; v++) {
                // Check if v is adjacent to u, not visited, and weight of edge u-v is smaller than key[v]
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < key[v]) {
                    // Update parent and key arrays
                    parent[v] = u;
                    key[v] = graph[u][v];
                    pq.add(v);
                } // end if
            } // end for
        } // end while
        
        // Print the minimum spanning tree
        printMinSpanningTree(parent, graph);
        System.out.println("Total weight of the minimum spanning tree: " + Arrays.stream(key).sum());
        System.out.println();
    } // end findMinSpanningTree
    
    /* This method prints the minimum spanning tree.
     @param parent The array containing the parent of each vertex in the minimum spanning tree.
     @param graph The input graph represented as an adjacency matrix. */
    static void printMinSpanningTree(int[] parent, int[][] graph) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
            System.out.println();
        } // end for
    } // end printMinSpanningTree
}// end PrimsYellowBrickRoad
