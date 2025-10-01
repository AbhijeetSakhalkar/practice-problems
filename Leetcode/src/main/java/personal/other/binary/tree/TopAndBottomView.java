package personal.other.binary.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopAndBottomView {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(3);
        TopAndBottomView t = new TopAndBottomView();
        t.topAndBottomView(root);

    }

    public void topAndBottomView (TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        fillMap(root, 0, map);
        int min = Collections.min(map.keySet());
        int max = Collections.max(map.keySet());
        System.out.println("Top View");
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).get(0));
        }
        System.out.println("Bottom View");
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).get(map.get(i).size()-1));
        }
    }
     private void fillMap(TreeNode node, int hd, Map<Integer, List<Integer>> map) {
        if (node == null) return;
        if (! map.containsKey(hd)) {
            map.put(hd, new ArrayList<>());
        }
        map.get(hd).add(node.val);
        fillMap(node.left, hd-1, map);
        fillMap(node.right, hd+1, map);
     }



}
