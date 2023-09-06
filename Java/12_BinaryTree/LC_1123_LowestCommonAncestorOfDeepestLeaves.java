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
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {

        if (root == null) {
            return root;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        if (left == right) {
            return root;
        }

        if (left > right) {
            return lcaDeepestLeaves(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        return Math.max(left, right) + 1;
    }
}

public class LC_1123_LowestCommonAncestorOfDeepestLeaves {

}
