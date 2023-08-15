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

class Solution_366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while (root != null) {
            List list = new ArrayList<>();
            root = dfs(root, list);
            res.add(list);
        }

        return res;
    }

    private TreeNode dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }

        root.left = dfs(root.left, list);
        root.right = dfs(root.right, list);

        return root;
    }
}