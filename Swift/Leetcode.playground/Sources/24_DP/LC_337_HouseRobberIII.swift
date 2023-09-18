/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init() { self.val = 0; self.left = nil; self.right = nil; }
 *     public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
 *     public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *     }
 * }
 */
class Solution {
    func rob(_ root: TreeNode?) -> Int {
        let res = robTree(root)
        return max(res[0], res[1])
    }
    
    private func robTree(_ node: TreeNode?) -> [Int] {
        guard let node = node else {
            return [0, 0]
        }
        let robLeft = robTree(node.left)
        let robRight = robTree(node.right)
        let max_1 = max(robLeft[0], robLeft[1]) + max(robRight[0], robRight[1])
        let max_2 = node.val + robLeft[0] + robRight[0]
        return [max_1, max_2]
    }
}