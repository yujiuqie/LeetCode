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
public class Solution_617 {
    public func mergeTrees(_ root1: TreeNode?, _ root2: TreeNode?) -> TreeNode? {
        guard root1 != nil else{
            return root2
        }

        guard root2 != nil else{
            return root1
        }

        return TreeNode(root1!.val + root2!.val,
        mergeTrees(root1?.left, root2?.left),
        mergeTrees(root1?.right, root2?.right))
    }
}

public class LC_617_MergeTwoBinaryTrees : Solution_617{
    public override init() {}
}
