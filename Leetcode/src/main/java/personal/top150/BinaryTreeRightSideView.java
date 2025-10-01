package personal.top150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        fillMap(root, 0, map);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < map.size(); i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
    private void fillMap(TreeNode node, int level, Map<Integer, Integer> map) {
        if (node == null) return;
        map.put(level, node.val);
        fillMap(node.left, level+1, map);
        fillMap(node.right, level+1, map);
    }
}
