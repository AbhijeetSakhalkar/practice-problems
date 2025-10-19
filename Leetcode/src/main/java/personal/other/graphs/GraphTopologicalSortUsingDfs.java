package personal.other.graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class GraphTopologicalSortUsingDfs {

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = convertToAdjacencyList(edges, V);
        Stack<Integer> stack = new Stack<>();
        boolean [] visited = new boolean[V];
        for (int i = 0 ; i < V ;i++) {
            if (! visited[i]) {
                dfs(adj, stack, visited, i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack,
                     boolean [] visited, int n) {

        visited[n] = true;
        for (int neighbor : adj.get(n)) {
            if (! visited[neighbor]) {
                dfs(adj, stack, visited, neighbor);
            }
        }
        stack.add(n); // this should add all neighbors in stack before me
    }

    private static ArrayList<ArrayList<Integer>> convertToAdjacencyList(int [][] edges, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        return adj;
    }




}
