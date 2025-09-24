package personal.top150;

// https://leetcode.com/problems/same-tree/description/?envType=study-plan-v2&envId=top-interview-150
public class SameBinaryTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }



}
