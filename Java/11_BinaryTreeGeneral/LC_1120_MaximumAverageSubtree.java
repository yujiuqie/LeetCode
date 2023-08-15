/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution_1120 {
    double max = Integer.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }

    private double[] dfs(TreeNode root){
        if(root == null){
            return new double[]{0.0,0.0};
        }

        double[] L = dfs(root.left);
        double[] R = dfs(root.right);

        double[] res = new double[2];
        res[0] = L[0] + R[0] + 1.0;
        res[1] = L[1] + R[1] + root.val;

        double averge = res[1] / res[0];
        max = Math.max(max,averge);

        return res;
    }
}