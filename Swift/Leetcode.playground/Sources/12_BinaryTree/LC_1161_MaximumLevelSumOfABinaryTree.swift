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
    func maxLevelSum(_ root: TreeNode?) -> Int {
        guard let root = root else {
            return 0
        }

        var max_level = 1
        var level = 0
        var max = Int.min
        var queue = [TreeNode]()
        queue.append(root)
        while !queue.isEmpty {
            level += 1

            let size = queue.count
            var sum = 0
            for _ in 0..<size {
                let node = queue.removeFirst()
                sum += node.val
                if let left = node.left {
                    queue.append(left)
                }
                if let right = node.right {
                    queue.append(right)
                }
            }

            if sum > max{
                max_level = level
                max = sum
            }
        }

        return max_level
    }
}