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
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robTree(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }

        int[] robLeft = robTree(node.left);
        int[] robRight = robTree(node.right);

        int max_1 = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);
        int max_2 = node.val + robLeft[0] + robRight[0];

        return new int[] { max_1, max_2 };
    }
}

public class LC_337_HouseRobberIII {

}
