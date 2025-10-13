package personal.other.graphs;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1?page=1&category=Graph&sortBy=submissions
public class GraphDFS {

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean [] visited = new boolean[adj.size()];
        for (int i = 0 ; i < adj.size(); i++) { // this for loop is for non connected portion of graph
            if (!visited[i]) {
                dfs(i, visited, ans, adj);
            }
        }
        //dfs(0, visited, ans, adj);
        return ans;
    }

    private void dfs(int v, boolean [] visited, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        ans.add(v);
        for (int neighbor : adj.get(v)) {
            if(!visited[neighbor]) {
                dfs(neighbor, visited, ans, adj);
            }
        }
    }

}
