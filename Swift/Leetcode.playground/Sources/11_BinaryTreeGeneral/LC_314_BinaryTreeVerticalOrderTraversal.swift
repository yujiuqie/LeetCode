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
class Solution_314 {
    func verticalOrder(_ root: TreeNode?) -> [[Int]] {
        guard let root = root else {
            return []
        }
        
        var queue = [TreeNode]()
        queue.append(root)
        
        var index_map = [Int]()
        index_map.append(0)
        
        var tmp = [Int : [Int]]()
        
        var minIndex = 0
        
        while(!queue.isEmpty){
            
            let size = queue.count
            
            for _ in 0..<size{
                let node = queue.removeFirst()
                
                let index = index_map.removeFirst()
                
                if(!tmp.keys.contains(index)){
                    tmp[index] = [Int]()
                }
                
                tmp[index]?.append(node.val)
                
                if let left = node.left {
                    queue.append(left)
                    index_map.append(index - 1)
                    minIndex = min(minIndex, index - 1)
                }
                
                if let right = node.right {
                    queue.append(right)
                    index_map.append(index + 1)
                }
            }
        }
        
        var res = [[Int]]()
        
        for i in minIndex..<minIndex + tmp.count {
            res.append(tmp[i]!)
        }
        
        return res
    }
}
