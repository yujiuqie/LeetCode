import java.util.*;

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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> smaller = new Stack<>();
        Stack<TreeNode> larger = new Stack<>();

        while(root != null){
            if(root.val <= target){
                smaller.push(root);
                root = root.right;
            }
            else{
                larger.push(root);
                root = root.left;
            }
        }

        List<Integer> res = new ArrayList();

        while(k > 0){
            double left = smaller.isEmpty() ? Double.MAX_VALUE : target - smaller.peek().val;
            double right = larger.isEmpty() ? Double.MAX_VALUE : larger.peek().val - target;

            if(left <= right){
                TreeNode node = smaller.pop();
                res.add(node.val);

                // 当找到一个 node 接近且小于 target 时，下一个最接近 target 且小于 target 的数值一定小于当前 node，这个值在当前 node 的左子树中，且是左子树中最大的值，那么就需要先取到 node.left，然后不断向右增加
                node = node.left;
                while(node != null){
                    smaller.push(node);
                    node = node.right;
                }
            }
            else{
                TreeNode node = larger.pop();
                res.add(node.val);

                // 当找到一个 node 接近且大于 target 时，下一个最接近 target 且大于 target 的数值一定大于当前 node，这个值在当前 node 的右子树中，且是右子树中最小的值，那么就需要先取到 node.right，然后不断向左增加
                node = node.right;
                while(node != null){
                    larger.push(node);
                    node = node.left;
                }
            }

            k--;
        }

        return res;
    }
}