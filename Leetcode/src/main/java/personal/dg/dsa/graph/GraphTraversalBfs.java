package personal.dg.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversalBfs {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        boolean [] visited = new boolean[v];
        Queue <Integer> q = new LinkedList<>();
        q.add(0);
        ArrayList<Integer> ans = new ArrayList<>();
        while (! q.isEmpty()) {
            int current = q.poll();
            ans.add(current);
            for(int neighbor : adj.get(current)) {
                if (! visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return ans;
    }
}
