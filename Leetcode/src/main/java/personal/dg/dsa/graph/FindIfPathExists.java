package personal.dg.dsa.graph;

import java.util.ArrayList;

public class FindIfPathExists {

    private boolean[] visited; // To keep track of visited nodes

    public boolean validPath(int n, int[][] edges, int start, int end) {
        ArrayList<ArrayList<Integer>> graph = getAdjacencyList(n, edges);
        visited = new boolean[n];
        return dfs(start, end, graph);
    }

    private boolean dfs(int current, int end, ArrayList<ArrayList<Integer>> graph) {
        if (current == end) return true;
        visited[current] = true;
        for(int neighbor : graph.get(current)) {
            if (! visited[neighbor]) {
                if (dfs(neighbor, end, graph)) return true;
            }
        }
        return false;
    }

    private ArrayList<ArrayList<Integer>> getAdjacencyList(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            adj.add(new ArrayList<>());
        }
        for (int [] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    public static void main(String[] args) {
        FindIfPathExists sol = new FindIfPathExists();
        System.out.println(sol.validPath(4, new int[][]{{0,1},{1,2},{2,3}}, 0, 3)); // true
//        System.out.println(sol.validPath(4, new int[][]{{0,1},{2,3}}, 0, 3));     // false
//        System.out.println(sol.validPath(5, new int[][]{{0,1},{3,4}}, 0, 4));     // false
    }

}
