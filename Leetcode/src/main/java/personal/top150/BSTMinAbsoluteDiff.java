package personal.top150;

// https://leetcode.com/problems/minimum-absolute-difference-in-bst/?envType=study-plan-v2&envId=top-interview-150
public class BSTMinAbsoluteDiff {
    int min = 0;
    int prev = 0;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        prev = Integer.MAX_VALUE;
        traverse(root);
        return min;
    }

    private void traverse (TreeNode node) {
        if (node == null) return ;
        traverse(node.left);
        min = Math.min(min, Math.abs(node.val-prev));
        prev = node.val;
        traverse(node.right);
    }
}

