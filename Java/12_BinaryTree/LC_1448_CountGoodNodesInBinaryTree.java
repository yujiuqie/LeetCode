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
class Solution {

    public int goodNodes(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }

    public int dfs(TreeNode node, int max){

        if(node == null){
            return 0;
        }

        int left = dfs(node.left, Math.max(max,node.val));
        int right = dfs(node.right, Math.max(max,node.val));

        return left + right + (node.val >= max ? 1 : 0);
    }
}