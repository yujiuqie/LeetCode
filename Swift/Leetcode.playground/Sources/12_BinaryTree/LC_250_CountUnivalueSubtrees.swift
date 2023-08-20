import Foundation

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

public class Solution_250 {
    
    var count : Int = 0
    
    public func countUnivalSubtrees(_ root: TreeNode?) -> Int {
        dfs(root,0)
        return count;
    }
    
    public func dfs(_ root: TreeNode?, _ val: Int!) -> Bool {
        if(root == nil){
            return true;
        }
        
        let valid_left = dfs(root?.left,root?.val)
        let valid_right = dfs(root?.right,root?.val)
        
        if(!valid_left || !valid_right){
            return false
        }
        
        count += 1
        
        return root?.val == val
    }
}

public class LC_250_CountUnivalueSubtrees : Solution_250{
    public override init() {}
}
