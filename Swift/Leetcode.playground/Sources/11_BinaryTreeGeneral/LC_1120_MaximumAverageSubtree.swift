import Foundation

public class Solution_1120 {
    
    private var maxValue = 0.0
    
    public func maximumAverageSubtree(_ root: TreeNode?) -> Double {
        dfs(root)
        return maxValue
    }
    
    private func dfs(_ root: TreeNode?) -> [Double]{
        if(root == nil){
            return [0.0,0.0]
        }
        
        let L = dfs(root?.left)
        let R = dfs(root?.right)
        
        let res = [L[0] + R[0] + Double(root?.val ?? 0),L[1] + R[1] + 1.0]
        maxValue = Swift.max(res[0] / res[1], maxValue)
        
        return res
    }
}

public class LC_1120_MaximumAverageSubtree : Solution_1120{
    public override init() {}
}
