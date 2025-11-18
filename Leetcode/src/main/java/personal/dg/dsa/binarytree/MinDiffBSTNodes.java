package personal.dg.dsa.binarytree;

import java.util.*;

public class MinDiffBSTNodes {
    // Using a List to hold the values in order.
    private List<Integer> nodes = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        inOrder(root);
        for (int i = 1 ; i < nodes.size(); i++) {
            minDiff = Math.min(minDiff, nodes.get(i)- nodes.get(i-1));
        }
        return minDiff;
    }
    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        nodes.add(node.val);
        inOrder(node.right);
    }
}
