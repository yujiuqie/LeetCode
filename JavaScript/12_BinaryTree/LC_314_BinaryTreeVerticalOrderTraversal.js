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
 * @return {number[][]}
 */
var verticalOrder = function (root) {
    if (!root) {
        return [];
    }

    var queue = [[root, 0]];
    var col_map = new Map();

    while (queue.length) {
        [node, col] = queue.shift();

        if (col_map.has(col)) {
            col_map.get(col).push(node.val);
        }
        else {
            col_map.set(col, [node.val]);
        }

        if (node.left) {
            queue.push([node.left, col - 1]);
        }

        if (node.right) {
            queue.push([node.right, col + 1]);
        }
    }

    return getColRes(col_map);

    // 按列的顺序获取最终结果，如果是有序哈希表，则可以省略这一步，直接输出结果
    function getColRes(map) {
        let keys = Array.from(map.keys());
        keys.sort((a, b) => a - b);

        let res = [];
        keys.forEach(key => {
            res.push(map.get(key))
        })

        return res;
    }
};