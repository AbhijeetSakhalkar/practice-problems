package personal.dg.dsa.binarytree;

public class RangeSumBST {
    int ans = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        inOrder(root, L, R);
        return ans;
    }

    private void inOrder(TreeNode node, int L, int R) {
        if (node == null) return;
        inOrder(node.left, L, R);
        if (node.val >= L && node.val <= R) {
            ans += node.val;
        }
        inOrder(node.right, L, R);
    }
}
