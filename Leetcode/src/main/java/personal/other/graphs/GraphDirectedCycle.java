package personal.other.graphs;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?page=1&category=Graph&sortBy=submissions
public class GraphDirectedCycle {

    public boolean isCyclic(int V, int[][] edges) {
        boolean [] visited = new boolean[V];
        boolean [] recS = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = convertToAdjList(V, edges);
        for (int i = 0 ; i < V; i++) {
            if (! visited[i]) {
                if (dfs(i, adj, visited, recS)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs (int v, ArrayList<ArrayList<Integer>> adj, boolean [] visited, boolean [] recS) {
        visited[v] = true;
        recS[v] = true;
        for (int neighbor : adj.get(v)) {
            if (! visited[neighbor]) {
                if (dfs(neighbor, adj, visited, recS)) {
                    return true;
                }
            } else if (recS[neighbor]) {
                return true;
            }
        }
        recS[v] = false;
        return false;
    }

    private ArrayList<ArrayList<Integer>> convertToAdjList(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int [] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        return adj;
    }
}
