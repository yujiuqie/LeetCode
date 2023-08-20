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
var countUnivalSubtrees = function(root) {
    var count = 0;

    function dfs(root,val){
        if(!root){
            return true;
        }

        let valid_left = dfs(root.left,root.val);
        let valid_right = dfs(root.right,root.val);

        if(!valid_left || !valid_right){
            return false;
        }

        count++;

        return root.val == val;
    }

    dfs(root,0);
    return count;
};