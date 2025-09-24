package personal.top150;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150
public class ConstructBinaryTreeFromPostOrderAndInOrder {

    static int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0 ; i< inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length-1, map);
    }
    private TreeNode helper (int [] postorder, int start, int end, Map<Integer, Integer> map) {
        if (start > end) return null;
        int rootValue = postorder[index--];
        TreeNode node = new TreeNode(rootValue);
        int preorderIndex = map.get(rootValue);
        node.right = helper(postorder, preorderIndex + 1, end, map);
        node.left = helper(postorder, start, preorderIndex-1, map);
        return node;

    }

}
