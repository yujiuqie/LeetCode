#import java.util.*;

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
class Solution_1214_1 {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null || root2 == null){
            return false;
        }

        int sum = root1.val + root2.val;
        if(sum == target){
            return true;
        }

        if(sum < target){
            return twoSumBSTs(root1.right,root2,target) || twoSumBSTs(root1,root2.right,target);
        }
        else{
            return twoSumBSTs(root1.left,root2,target) || twoSumBSTs(root1,root2.left,target);
        }
    }
}

class Solution_1214_2 {
 public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorderTravel(root1, list1);
        inorderTravel(root2, list2);
        return getResult(list1, list2, target);
    }

    private void inorderTravel(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderTravel(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTravel(root.right, list);
        }
    }

    private boolean getResult(List<Integer> list1, List<Integer> list2, int target) {
        int i = 0;
        int j = list2.size() - 1;
        while (i < list1.size() && j >= 0) {
            int sum = list1.get(i) + list2.get(j);
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}

public class LC_1214_TwoSumBSTs{
    
}