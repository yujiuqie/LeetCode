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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution_250 {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root,0);
        return count;
    }

    public boolean dfs(TreeNode root, int val){
        if(root == null){
            return true;
        }

        boolean valid_left = dfs(root.left,root.val);
        boolean valid_right = dfs(root.right,root.val);

        if(!valid_left || !valid_right){
            return false;
        }

        count++;
        return root.val == val;
    }
}

public class LC_250_CountUnivalueSubtrees {

}