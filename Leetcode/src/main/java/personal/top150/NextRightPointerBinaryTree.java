package personal.top150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NextRightPointerBinaryTree {
    public TNode connect(TNode root) {
        int height = height(root);
        Map<Integer, List<TNode>> map = new HashMap<>();
        preOrder(root, 0, map);
        for(int i =0; i < height; i++) {
            List<TNode> nodes = map.get(i);
            for (int j = 0 ; j < nodes.size()-1; j++) {
                nodes.get(j).next = nodes.get(j+1);
            }
        }
        return root;
    }
    private int height (TNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
    private void preOrder(TNode node, int level, Map<Integer, List<TNode>> map) {
        if (node == null) return;
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(node);
        preOrder(node.left, level+1, map);
        preOrder(node.right, level+1, map);
    }
}

class TNode {
    public int val;
    public TNode left;
    public TNode right;
    public TNode next;

    public TNode() {}

    public TNode(int _val) {
        val = _val;
    }

    public TNode(int _val, TNode _left, TNode _right, TNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};