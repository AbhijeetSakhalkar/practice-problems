package personal.other.graphs;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?page=1&category=Graph&sortBy=submissions
public class GraphUndirectedCycle {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = convertToAdjacencyList(edges, V);
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (! vis[i]) {
                if (dfs(i, adj, vis, -1)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {
        vis[i] = true;
        for (int neighbor : adj.get(i)) {
            if (! vis[neighbor]) {
                if(dfs(neighbor, adj, vis, i)) {
                    return true;
                }
            } else if (neighbor != parent) { // here visited = true
                return true;
            }
        }
        return false;
    }


    private ArrayList<ArrayList<Integer>> convertToAdjacencyList(int [][] edges, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }


}
