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
    
    int res = 0;
    
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }

    // 以当前节点为根是否是BST
    int[] dfs(TreeNode root) {

        // 空节点也是一颗BST
        if (root == null) {
            return new int[] { 1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // [0]是否BST
        // [1]当前为根的BST最小值
        // [2]当前为根的BST最大值
        // [3]该BST节点总和
        int[] cur = new int[4];

        // 左右子树是BST，并且val满足大于左最大值，小于右最小值
        if (left[0] == 1 &&
                right[0] == 1 &&
                root.val > left[2] &&
                root.val < right[1]) {
            cur[0] = 1;// 置1
            cur[1] = Math.min(left[1], root.val);// 更新最小值
            cur[2] = Math.max(right[2], root.val);// 更新最大值
            cur[3] = left[3] + right[3] + root.val;// 更新节点总和
            res = Math.max(cur[3], res);// 更新全局变量
        } else {
            cur[0] = 0;// 不然就不是BST，其他数据也用不到
        }
        return cur;
    }
}