package personal.other.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {


    // https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?page=1&category=Graph&sortBy=submissions
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        boolean [] visited = new boolean[v];
        Queue <Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);
            for(int i=0 ; i < adj.get(cur).size(); i++) {
                int neighbor = adj.get(cur).get(i);
                if(! visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        return ans;
    }


    private static boolean minDistFromSrcToDest(ArrayList<ArrayList<Integer>> adj,
                               int src, int dest, int v,
                               int [] pred, int [] dist) {

        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[v];
        for (int i = 0 ; i < v ; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        visited[src] = true;
        dist[src] = 0;
        queue.add(src);
        while (! queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < adj.get(cur).size(); i++) {
                int neighbor = adj.get(cur).get(i);
                if (! visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[cur] + 1;
                    pred[neighbor] = cur;
                    queue.add(neighbor);
                }

                if (neighbor == dest) return true;
            }
        }
        return false;
    }
}
