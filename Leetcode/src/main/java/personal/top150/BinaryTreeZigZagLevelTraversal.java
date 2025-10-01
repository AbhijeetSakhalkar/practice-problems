package personal.top150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeZigZagLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        preOrder(root, 0, map);
        for(int i = 0 ; i < map.size(); i++) {
            if (i % 2 == 0) {
                ans.add(i, map.get(i));
            } else {
                ans.add(i, reverseList(map.get(i)));
            }
        }
        return ans;
    }
    private void preOrder(TreeNode node, int level, Map<Integer, List<Integer>> map) {
        if (node == null) return;
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(node.val);
        preOrder(node.left, level + 1, map);
        preOrder(node.right, level + 1, map);
    }
    private List<Integer> reverseList(List<Integer> list) {
        List<Integer> reverse = new ArrayList<>();
        for(int i = list.size()-1; i >=0;i--) {
            reverse.add(list.get(i));
        }
        return reverse;
    }
}
