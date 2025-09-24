package personal.other.binary.tree;

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(3);

        BinaryTreeTraversal b = new BinaryTreeTraversal();
        System.out.println("InOrder: ");
        b.inOrder(root);
        System.out.println();
        System.out.println("PreOrder: ");
        b.preOrder(root);
        System.out.println();
        System.out.println("PostOrder: ");
        b.postOrder(root);
    }

    // LNR
    private void inOrder (TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    // NLR
    private void preOrder (TreeNode root) {
        if (root == null) return;
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // LRN
    private void postOrder (TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }
}
