package personal.other.graphs;


import java.util.ArrayList;

// https://leetcode.com/problems/number-of-provinces/description/?envType=problem-list-v2&envId=graph
public class GraphNoOfProvince {

    public static void main(String[] args) {
        GraphNoOfProvince g = new GraphNoOfProvince();
        int ans = g.findCircleNum(new int [][] {{1,1,0},{1,1,0},{0,0,1}});
        System.out.println(ans);
    }

    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        ArrayList<ArrayList<Integer>> adj = getAdjList(isConnected);
        int n = isConnected.length;
        boolean [] visited = new boolean[n];
        for(int i = 0 ; i < n; i++) {
            if (!visited[i]) {
                ans ++;
                dfs(adj, visited, i);
            }
        }
        return ans;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean [] visited, int v) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (! visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }


    private ArrayList<ArrayList<Integer>> getAdjList(int [][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0 ; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0 ; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }
}
