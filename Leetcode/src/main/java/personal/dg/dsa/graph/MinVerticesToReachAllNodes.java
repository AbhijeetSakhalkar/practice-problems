package personal.dg.dsa.graph;

import java.util.*;

public class MinVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        boolean [] incoming = new boolean[n];
        for(List<Integer> edge : edges) {
            incoming[edge.get(1)] = true;
        }
        for (int i = 0 ; i < n; i++) {
            if (!incoming[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinVerticesToReachAllNodes sol = new MinVerticesToReachAllNodes();
        List<List<Integer>> edges1 = List.of(List.of(0,1), List.of(1,2), List.of(2,3));
        List<Integer> ans = sol.findSmallestSetOfVertices(4, edges1);
    }
}
