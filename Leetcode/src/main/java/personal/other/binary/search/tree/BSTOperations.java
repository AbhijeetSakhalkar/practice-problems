package personal.other.binary.search.tree;


public class BSTOperations {


    public boolean search (TreeNode node , int target) {
        if (node == null) return false;
        if (node.val == target) return true;
        if (node.val > target) return search(node.left, target);
        return search(node.right, target);
    }

    public TreeNode insertRecursively(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }
        if (root.val > target) {
            root.left = insertRecursively(root.left, target);
        } else if (root.val < target) {
            root.right = insertRecursively(root.right, target);
        }

        return root;
    }

    public TreeNode insertIteratively(TreeNode root, int target) {
        TreeNode tmp = new TreeNode(target);
        if (root == null) {
            return tmp;
        }

        TreeNode cur = root;
        TreeNode prev = null;

        while(cur != null) {
            prev = cur;
            if (cur.val > target) {
                cur = cur.left;
            } else if (cur.val < target) {
                cur = cur.right;
            } else {
                return root; // already present
            }
        }

        if (prev.val > target) {
            prev.left = tmp;
        } else {
            prev.right = tmp;
        }
        return root;
    }

    public TreeNode deleteNode (TreeNode root, int target) {
        if (root == null) return null;
        if (root.val > target) {
            root.left = deleteNode(root.left, target);
        } else if (root.val < target) {
            root.right = deleteNode(root.right, target);
        } else {
            // If root matches with the given key

            // Cases when root has 0 children or
            // only right child
            if (root.left == null) return root.right;
            // When root has only left child
            else if (root.right == null) return root.left;

            // When both children are present
            root.val = getMin(root);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int getMin(TreeNode node) {
        int min = node.val;
        while (node.left != null) {
            min = node.left.val;
            node = node.left;
        }
        return min;
    }

}
