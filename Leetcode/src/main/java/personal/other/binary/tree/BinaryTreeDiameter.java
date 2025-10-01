package personal.other.binary.tree;

public class BinaryTreeDiameter {
    public int diameter(TreeNode root) {
        if (root == null) return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);
        int cur = height(root.left) + height(root.right) + 1;
        return Math.max(cur, Math.max(left, right));
    }
    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int dia[] = new int[1];
        hight(root, dia);
        return dia[0];
    }

    public static int hight(TreeNode root, int dia[]) {
        if (root == null) return 0;

        int left = hight(root.left, dia);
        int right = hight(root.right, dia);

        dia[0] = Math.max(dia[0], left + right);

        return Math.max(left, right) + 1;
    }
}
