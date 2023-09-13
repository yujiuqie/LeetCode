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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        dfs(root1,list1);

        List<Integer> list2 = new ArrayList<>();
        dfs(root2,list2);

        return list1.equals(list2);
    }

    private void dfs(TreeNode root, List<Integer> list){
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }

        if(root.left != null) {
            dfs(root.left,list);
        }
        
        if(root.right != null){
            dfs(root.right,list);
        }
    }
}

public class LC_872_LeafSimilarTrees {
    
}
