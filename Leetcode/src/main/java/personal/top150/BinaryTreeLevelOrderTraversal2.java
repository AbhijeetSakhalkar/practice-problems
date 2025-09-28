package personal.top150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/?envType=problem-list-v2&envId=binary-tree
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        preOrder(root, 0, map);
        for(int i = map.size()-1 ; i >= 0 ; i--) {
            ans.add(map.get(i));
        }
        return ans;
    }

    // NLR
    private void preOrder(TreeNode node, int level, Map<Integer, List<Integer>> map) {
        if (node == null) return;
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(node.val);
        preOrder(node.left, level + 1, map);
        preOrder(node.right, level + 1, map);
    }


}
