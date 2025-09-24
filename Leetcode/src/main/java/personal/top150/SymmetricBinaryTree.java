package personal.top150;

// https://leetcode.com/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-interview-150
public class SymmetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

}
