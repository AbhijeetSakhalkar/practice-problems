package personal.top150;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class CloneGraph {
    public Node cloneGraph2(Node node) {
        if (node == null) return null;
        Node [] visited = new Node[101];
        Node copy = new Node(node.val);
        dfsCopy(node, copy, visited);
        return copy;
    }

    private Node dfsCopy(Node original, Node copy, Node [] visited) {
        visited[copy.val] = copy;
        for (Node neighbor : original.neighbors) {
            if (visited[neighbor.val] == null) {
                Node copiedNeighbor = new Node(neighbor.val);
                copy.neighbors.add(copiedNeighbor);
                dfsCopy(neighbor, copiedNeighbor, visited);
            } else {
                copy.neighbors.add(visited[neighbor.val]);
            }
        }
        return copy;
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return getCopyUsingDfs(node, map);
    }

    private Node getCopyUsingDfs(Node node, Map<Integer, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);
        Node copiedNode = new Node(node.val);
        map.put(copiedNode.val, copiedNode);
        for (Node neighbor : node.neighbors) {
            copiedNode.neighbors.add(getCopyUsingDfs(neighbor, map));
        }
        return copiedNode;
    }
}
