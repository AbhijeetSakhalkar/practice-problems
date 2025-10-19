package personal.other.graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Kahns Algorithm
public class GraphTopologicalSortUsingBfs {

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = convertToAdjacencyList(edges, V);
        int [] inDegree = new int[V];
        for (ArrayList<Integer> list : adj) {
            for (Integer i : list) {
                inDegree[i]++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        bfs(adj, inDegree, V, ans);
        return ans;
    }

    private static void bfs(ArrayList<ArrayList<Integer>> adj, int[] inDegree, int V, ArrayList<Integer> ans) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (! q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for (int neighbor : adj.get(cur)) {
                if (-- inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
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
