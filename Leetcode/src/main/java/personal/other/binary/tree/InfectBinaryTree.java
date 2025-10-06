package personal.other.binary.tree;

// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
public class InfectBinaryTree {

    static class Depth {
        int d;
        public Depth(int d) {
            this.d = d;
        }
    }

    static int ans = -1;

    public int amountOfTime(TreeNode root, int start) {
        ans = -1;
        Depth d = new Depth(-1);
        burn(root, start, d);
        return ans - 1; // subtract 1 because infection spreads in "edges"
    }

    public static int burn(TreeNode node, int target, Depth depth) {
        if (node == null) return 0;

        Depth ld = new Depth(-1);
        Depth rd = new Depth(-1);
        int lh = burn(node.left, target, ld);
        int rh = burn(node.right, target, rd);

        // found target in current subtree
        if (node.val == target) {
            ans = Math.max(ans, Math.max(lh, rh) + 1); // infection spreads downward
            depth.d = 1;
            return Math.max(lh, rh) + 1;
        }

        if (ld.d != -1) {
            ans = Math.max(ans, ld.d + 1 + rh);
            depth.d = ld.d + 1;
        } else if (rd.d != -1) {
            ans = Math.max(ans, rd.d + 1 + lh);
            depth.d = rd.d + 1;
        }

        // compute height
        return Math.max(lh, rh) + 1;
    }
}

