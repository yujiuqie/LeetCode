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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        int max = Integer.MIN_VALUE;
        int level = 0;
        int max_level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            level++;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }

            if(sum > max){
                max_level = level;
                max = sum;
            }
        }

        return max_level;
    }
}

public class LC_1161_MaximumLevelSumOfABinaryTree {
    
}
