package personal.top150;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=study-plan-v2&envId=top-interview-150
public class ConstructBinaryTreeFromPreOrderAndInOrder {

    static int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0 ; i< inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1, map);
    }

    private TreeNode helper (int [] preorder, int start, int end, Map<Integer, Integer> map) {
        if (start > end) return null;
        int rootValue = preorder[index++];
        int inorderIndex = map.get(rootValue);
        TreeNode node = new TreeNode(rootValue);
        node.left = helper(preorder, start, inorderIndex -1 , map);
        node.right = helper(preorder, inorderIndex+1, end,map);
        return node;
    }


}
