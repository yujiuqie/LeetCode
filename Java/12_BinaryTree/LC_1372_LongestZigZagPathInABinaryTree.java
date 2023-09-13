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

    int max = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 每个节点都往左右移动进行遍历，其中 1 表示往左遍历，2 表示往右遍历
        // 初始 count 从 1 开始计算
        dfs(root.left, 1, 1);
        dfs(root.right, 1, 2);

        return max;
    }

    private void dfs(TreeNode root, int count, int direction) {
        if (root == null) {
            return;
        }

        max = Math.max(max, count);

        // 如果前一个方向是从左边来的(direction == 1)，那当前继续往左遍历的 count 从 1 开始计算
        // 如果前一个方向是从右边来的(direction != 1)，那当前继续往左遍历的 count 加 1 继续计算
        dfs(root.left, direction == 1 ? 1 : count + 1, 1);

        // 如果前一个方向是从右边来的(direction == 2)，那当前继续往右遍历的 count 从 1 开始计算
        // 如果前一个方向是从左边来的(direction != 2)，那当前继续往右遍历的 count 加 1 继续计算
        dfs(root.right, direction == 2 ? 1 : count + 1, 2);
    }
}

public class LC_1372_LongestZigZagPathInABinaryTree {

}
