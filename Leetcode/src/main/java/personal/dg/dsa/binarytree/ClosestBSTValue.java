package personal.dg.dsa.binarytree;

public class ClosestBSTValue {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        ClosestBSTValue c = new ClosestBSTValue();
        int i = c.closestValue(root, 3.5);
        System.out.println(i);

    }


    double smallest = Double.MAX_VALUE;
    int ans = 0;
    // This function finds the value in the BST closest to the target.
    public int closestValue(TreeNode root, double target) {
        while (root != null) {
            if (smallest > Math.abs(root.val - target)) {
                smallest = Math.abs(root.val - target);
                ans = root.val;
            } else if (smallest == Math.abs(root.val - target)) {
                ans = Math.min(ans, root.val);
            }
            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans;
    }

}
