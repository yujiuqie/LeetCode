/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var longestConsecutive = function(root) {

    var maxValue = 0;

    function longestPath(root){
        if(!root){
            return [0,0];
        }

        var increase = 1;
        var decrease = 1;

        if(root.left){
            let L = longestPath(root.left);
            if(root.val == root.left.val + 1){
                decrease = L[1] + 1; //左子节点值比当前值大 1，与当前值构成降序
            }
            else if(root.val == root.left.val - 1){
                increase = L[0] + 1; //左子节点值比当前值小 1，与当前值构成升序
            }
        }

        if(root.right){
            let R = longestPath(root.right);
            if(root.val == root.right.val + 1){
                decrease = Math.max(decrease, R[1] + 1); //右子节点值比当前值大 1，与当前值构成降序
            }
            else if(root.val == root.right.val - 1){
                increase = Math.max(increase, R[0] + 1); //右子节点值比当前值小 1，与当前值构成升序
            }
        }

        maxValue = Math.max(maxValue,decrease + increase - 1);

        return [increase,decrease];
    }

    longestPath(root);
    return maxValue;
};