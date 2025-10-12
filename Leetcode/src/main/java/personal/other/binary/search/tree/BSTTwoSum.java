package personal.other.binary.search.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
public class BSTTwoSum {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return util(root, k, set);
    }

    private boolean util (TreeNode node, int k, Set<Integer> set) {
        if (node == null) return false;
        if (util(node.left, k, set)) {
            return true;
        }
        if (set.contains(k-node.val)) {
            return true;
        }
        set.add(node.val);
        return util(node.right, k, set);
    }

    // Using inorder traversal and sorted list
    public boolean findTargetUsingInOrder(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int l = 0; int r = list.size()-1;
        while(l<r) {
            if (list.get(l) + list.get(r) > k) {
                r--;
            } else if (list.get(l) + list.get(r) < k) {
                l ++;
            } else {
                return true;
            }
        }
        return false;
    }
    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }


}
