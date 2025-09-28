package personal.top150;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
public class MaxPathSum {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(helper(node.left),0);
        int right = Math.max(helper(node.right),0);

        int pathSum = node.val + left + right;
        ans = Math.max(ans, pathSum);

        return node.val + Math.max(left,right);

    }

}
