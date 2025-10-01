package personal.other.binary.tree;

public class BinaryTreeDLL {
    TreeNode prev = null ;
    TreeNode head = null;

    // in order
    public void convertToDll(TreeNode root) {
        if (root == null) return;
        convertToDll(root.left);
        if (head == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertToDll(root.right);
    }
}
