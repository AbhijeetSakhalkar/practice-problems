package personal.top150;

// https://leetcode.com/problems/invert-binary-tree/?envType=study-plan-v2&envId=top-interview-150
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

}
