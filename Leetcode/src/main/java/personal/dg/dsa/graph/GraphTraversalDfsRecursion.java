package personal.dg.dsa.graph;

import java.util.LinkedList;

public class GraphTraversalDfsRecursion {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    public GraphTraversalDfsRecursion (int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // For an undirected graph
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Track visited nodes
        System.out.print("DFS Traversal: ");
        DFSRecursive(startVertex, visited); // Start DFS from the given vertex
    }

    private void DFSRecursive(int currentVertex, boolean[] visited) {
        System.out.println(currentVertex);
        visited[currentVertex] = true;
        for (int neighbor: adjacencyList[currentVertex]) {
            if (!visited[neighbor]) {
                DFSRecursive(neighbor, visited);
            }
        }
    }
}

class Solution2 {
    public static void main(String[] args) {
        GraphTraversalDfsRecursion g = new GraphTraversalDfsRecursion(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);

        System.out.print("DFS Traversal starting from vertex 0: ");
        g.DFS(0);

    }
}
