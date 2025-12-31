package personal.dg.dsa.graph;

import java.util.ArrayList;

public class NumberOfProvince {

    // Function to find the province count.
    public int findProvinces(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        int count = 0;
        boolean [] visited = new boolean[n];
        for (int i = 0 ; i < n ; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }
        return count;
    }

    private void dfs(int current, ArrayList<ArrayList<Integer>> adj, boolean [] visited) {
        visited[current] = true;
        for(int neighbor : adj.get(current)) {
            if (! visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvince sol = new NumberOfProvince();
        int count = sol.findProvinces(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,0},{1,0,0,1}});
        System.out.println(count);
    }

}
