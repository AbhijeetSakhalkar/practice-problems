package personal.other.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class AllAncestorsOfNodeInBinaryTree {
    static List<Integer> ancestors = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);

        /* Construct the following binary tree
                  1
                /   \
               2     3
              /  \
             4    5
            /
           7
        */

        AllAncestorsOfNodeInBinaryTree a = new AllAncestorsOfNodeInBinaryTree();
        a.fillAncestors(root, 7);
        System.out.println(ancestors);
    }

    private boolean fillAncestors(TreeNode node, int target) {
        if (node == null) return false;
        if (node.val == target) {
            ancestors.add(target);
            return true;
        }
        if (fillAncestors(node.left, target) || fillAncestors(node.right, target)) {
            ancestors.add(node.val);
            return true;
        }
        return false;
    }


}
