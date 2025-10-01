package personal.other.binary.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeVerticalOrderTraversal {
    class NodeInfo {
        int row, col, val;
        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);

        // Sort by col, then row, then value
        Collections.sort(nodes, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> ans = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for (NodeInfo ni : nodes) {
            if (ni.col != prevCol) {
                ans.add(new ArrayList<>());
                prevCol = ni.col;
            }
            ans.get(ans.size() - 1).add(ni.val);
        }
        return ans;
    }
    private void dfs(TreeNode node, int row, int col, List<NodeInfo> nodes) {
        if (node == null) return;
        nodes.add(new NodeInfo(row, col, node.val));
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }

}
