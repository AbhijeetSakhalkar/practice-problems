package personal.other.binary.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(6);
        LevelOrderTraversal l = new LevelOrderTraversal();
        l.printLevelOrderUsingQueue(root);
        System.out.println();
        l.printLevelOrderUsingHashMap(root);
    }
    public void printLevelOrderUsingQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(! queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                if (queue.isEmpty()) {
                    return;
                }
                queue.add(null);
                System.out.println();
            } else {
                System.out.print(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
    }

    public void printLevelOrderUsingHashMap(TreeNode root) {
        int height = height(root);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int level = 0;
        preOrder(root, level, map);
        for(int i = 0 ; i < height ; i++) {
            List<Integer> values = map.get(i);
            System.out.println(values.toString());
        }
    }

    private int height (TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private void preOrder(TreeNode node, int level, Map<Integer, List<Integer>> map) {
        if (node == null) return;
        if (! map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(node.val);
        preOrder(node.left, level + 1, map);
        preOrder(node.right, level + 1, map);
    }
}
