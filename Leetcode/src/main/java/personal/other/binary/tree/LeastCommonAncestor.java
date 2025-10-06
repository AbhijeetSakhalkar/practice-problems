package personal.other.binary.tree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=problem-list-v2&envId=binary-tree
public class LeastCommonAncestor {
    public TreeNode lca(TreeNode root, int n1, int n2) {
        if (root == null) return null;

        if (root.val == n1 || root.val == n2) return root;

        TreeNode left = lca (root.left, n1, n2);
        TreeNode right = lca (root.right, n1, n2);

        if (left == null) return right;
        if (right == null) return left;

        return root;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

}
