
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return max;
    }

    private int[] longestPath(TreeNode root){
        if(root == null){
            return new int[]{0,0};  //第一个元素表示升序最大值，第二个元素表示降序最大值
        }

        //如果左右子节点与 root 节点值不连续（非 +1 -1 关系），则默认为 1
        int increase = 1;
        int decrease = 1;

        if(root.left != null){
            int[] L = longestPath(root.left);
            if(root.val == root.left.val + 1){
                decrease = L[1] + 1; //左子节点值比当前值大 1，与当前值构成降序
            }
            else if(root.val == root.left.val - 1){
                increase = L[0] + 1; //左子节点值比当前值小 1，与当前值构成升序
            }
        }

        if(root.right != null){
            int[] R = longestPath(root.right);
            if(root.val == root.right.val + 1){
                decrease = Math.max(decrease,R[1] + 1); //右子节点值比当前值大 1，与当前值构成降序，需要取左右降序中较大的那个值
            }
            else if(root.val == root.right.val - 1){
                increase = Math.max(increase,R[0] + 1); //右子节点值比当前值小 1，与当前值构成升序，需要取左右升序中较大的那个值
            }
        }

        max = Math.max(max,decrease + increase - 1); //当前节点最大值为升降序最大值之和（由于当前节点在左右两边都计算了一次，所以要 -1）

        return new int[]{increase,decrease};
    }
}

public class $549_BinaryTreeLongestConsecutiveSequenceII {

}