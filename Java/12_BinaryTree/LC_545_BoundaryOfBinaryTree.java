/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

 import java.util.*;

class Solution_545 {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, true, true, res);
        return res;
    }

    private void dfs(TreeNode node, boolean left, boolean right, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }

        if (left) {
            res.add(node.val);
        }

        dfs(node.left, left, !left && right && node.right == null, res);
        dfs(node.right, left && !right && node.left == null, right, res);

        if (!left && right) {
            res.add(node.val);
        }
    }
}

public class LC_545_BoundaryOfBinaryTree {

}