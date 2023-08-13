//
//  LC_549_BinaryTreeLongestConsecutiveSequenceII.swift
//  Leetcode
//
//  Created by viktyz on 2023/8/13.
//

import Foundation

public class TreeNode {
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    public init() { self.val = 0; self.left = nil; self.right = nil; }
    public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
    public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
        self.val = val
        self.left = left
        self.right = right
    }
}

public class Solution_549 {
    
    public var maxValue : Int = 0;
    
    public func longestConsecutive(_ root: TreeNode?) -> Int {
        longestPath(root)
        return maxValue
    }

    public func longestPath(_ root: TreeNode?) -> [Int] {
        if (root == nil) {
            return [0,0]
        }
        
        var increase : Int = 1;
        var decrease : Int = 1;
        
        if let left = root?.left {
            let L : [Int] = longestPath(left)
            
            if(root?.val == left.val + 1){
                decrease = L[1] + 1;
            }
            else if(root?.val == left.val - 1){
                increase = L[0] + 1;
            }
        }
        
        if let right = root?.right {
            let R : [Int] = longestPath(right)
            
            if(root?.val == right.val + 1){
                decrease = max(decrease,R[1] + 1);
            }
            else if(root?.val == right.val - 1){
                increase = max(increase,R[0] + 1);
            }
        }
        
        maxValue = max(maxValue,decrease + increase - 1)
        
        return [increase,decrease]
    }
}

public class LC_549_BinaryTreeLongestConsecutiveSequenceII : Solution{
    public override init() {}
}
