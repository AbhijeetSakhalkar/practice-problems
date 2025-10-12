package personal.other.binary.search.tree;

class Node {
    int data;
    Node left, right;
}

public class BSTFloorAndCeil {

    public static int floor(Node root, int x) {
        int ans = -1;
        while (root != null) {
            if (root.data == x) {
                return root.data;
            }
            if (root.data > x) {
                root = root.left;
            } else {
                ans = root.data;
                root = root.right;
            }
        }
        return ans;
    }

    int findCeil(Node root, int x) {
        int ans = -1;
        while (root != null) {
            if (root.data == x) {
                return root.data;
            }
            if (root.data < x) {
                root = root.right;
            } else {
                ans = root.data;
                root = root.left;
            }
        }
        return ans;
    }
}
