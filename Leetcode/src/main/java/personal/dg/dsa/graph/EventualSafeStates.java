package personal.dg.dsa.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(graph, visited, i)) {
                result.add(i);
            }
        }

        Collections.sort(result); // Sorting the result
        return result;
    }

    private boolean dfs(int[][]graph, int[]visited, int node) {
        if (visited[node] == -1) return true;
        if (visited[node] == 1) return false;

        visited[node] = 1; // Mark the node as visiting
        for (int next : graph[node]) {
            if (!dfs(graph, visited, next)) {
                return false; // If any adjacent node is not safe
            }
        }
        visited[node] = -1; // Mark the node as safe
        return true;
    }
}
