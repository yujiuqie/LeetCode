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
var maximumAverageSubtree = function(root) {

    var max = 0;

    var dfs = function(root){
        if(!root){
            return [0.0,0.0];
        }

        let L = dfs(root.left);
        let R = dfs(root.right);

        var res = [L[0] + R[0] + 1.0,L[1] + R[1] + root.val];

        max = Math.max(max, res[1] / res[0]);

        return res;
    }

    dfs(root);
    return max;
};