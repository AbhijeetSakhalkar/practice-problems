package personal.top150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NextRightPointerBinaryTree {
    public Node connect(Node root) {
        int height = height(root);
        Map<Integer, List<Node>> map = new HashMap<>();
        preOrder(root, 0, map);
        for(int i =0; i < height; i++) {
            List<Node> nodes = map.get(i);
            for (int j = 0 ; j < nodes.size()-1; j++) {
                nodes.get(j).next = nodes.get(j+1);
            }
        }
        return root;
    }
    private int height (Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
    private void preOrder(Node node, int level, Map<Integer, List<Node>> map) {
        if (node == null) return;
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(node);
        preOrder(node.left, level+1, map);
        preOrder(node.right, level+1, map);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};