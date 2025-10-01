package personal.top150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/average-of-levels-in-binary-tree/?envType=study-plan-v2&envId=top-interview-150
public class BinaryTreeAverageLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Double> ans = new ArrayList<>();
        fillMap(root, 0, map);
        for (int i=0 ; i< map.size(); i++) {
            double sum = 0;
            for (int j : map.get(i)) {
                sum += j;
            }
            ans.add(sum/map.get(i).size());
        }
        return ans;
    }
    private void fillMap (TreeNode node, int level, Map<Integer, List<Integer>> map) {
        if (node == null) return;
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(node.val);
        fillMap(node.left, level+1, map);
        fillMap(node.right, level+1, map);
    }
}
