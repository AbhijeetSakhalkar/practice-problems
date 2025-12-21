package personal.dg.dsa.graph;

import java.util.LinkedList;
import java.util.Stack;

public class GraphTraversalDfsStack {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Constructor
    public GraphTraversalDfsStack(int vertices) {
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
        Stack<Integer> stack = new Stack<>(); // Stack for traversal

        stack.push(startVertex);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                System.out.println(current);
                visited[current] = true;
            }
            for (int neighbor : adjacencyList[current]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }

    }
}


class Solution {
    public static void main(String[] args) {
        GraphTraversalDfsStack g = new GraphTraversalDfsStack(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);

        System.out.print("DFS Traversal starting from vertex 0: ");
        g.DFS(0);

    }
}