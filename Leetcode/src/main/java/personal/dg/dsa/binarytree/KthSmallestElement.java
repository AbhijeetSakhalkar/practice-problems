package personal.dg.dsa.binarytree;

public class KthSmallestElement {

    int count = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        inOrder(root, k);
        return ans;
    }
    private void inOrder(TreeNode node, int k) {
        if (null == node || count > k) return;
        inOrder(node.left, k);
        if (++ count == k) {
            ans = node.val;
        }
        inOrder(node.right, k);
    }

}
