package personal.other.graphs;


import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-center-of-star-graph/?envType=problem-list-v2&envId=graph
public class GraphStartCenter {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int [] edge : edges) {
            if (! map.containsKey(edge[0])) {
                map.put(edge[0], 0);
            }
            map.put(edge[0], map.get(edge[0])+1);
            if (! map.containsKey(edge[1])) {
                map.put(edge[1], 0);
            }
            map.put(edge[1], map.get(edge[1])+1);
            if (map.get(edge[0])>1) return edge[0];
            if (map.get(edge[1])>1) return edge[1];
        }
        return -1;
    }
}
