package personal.other.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/find-if-path-exists-in-graph/?envType=problem-list-v2&envId=graph
public class GraphPathExists {

    // using bfs
    public boolean validPathUsingBfs(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = getAdjList(edges, n);
        boolean [] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if (cur == destination) return true;
            for (int neighbor : adj.get(cur)) {
                if(! visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        return false;
    }


    // using dfs
    public boolean validPathUsingDfs(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adj = getAdjList(edges, n);
        boolean [] visited = new boolean[n];
        return dfs(adj, source, destination, visited);
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int source, int destination, boolean[] visited) {
        visited[source] = true;
        if (source == destination) {
            return true;
        }
        for (int neighbor : adj.get(source)) {
            if (! visited[neighbor]) {
                if(dfs(adj, neighbor, destination, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private ArrayList<ArrayList<Integer>> getAdjList(int [][] edges, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int [] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

}
