package personal.top150;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/?envType=study-plan-v2&envId=top-interview-150
public class BSTKthSmallestElement {
    int counter = 0;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        counter = 0;
        ans = -1;
        inOrder(root, k);
        return ans;
    }
    public void inOrder(TreeNode node, int k) {
        if (node == null || ans != -1) return;
        inOrder(node.left, k);
        if (++counter == k) {
            ans = node.val;
        }
        inOrder(node.right, k);
    }
}
