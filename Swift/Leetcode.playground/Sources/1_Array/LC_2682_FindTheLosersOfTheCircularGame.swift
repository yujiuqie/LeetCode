import Foundation

public class Solution_2682 {
    public func circularGameLosers(_ n: Int, _ k: Int) -> [Int] {
        var index = 0
        var jump = k
        var visited = Array(repeating: false, count: n)
        
        while(!visited[index]){
            visited[index] = true
            index = (index + jump) % n
            jump = jump + k
        }
        
        var res : [Int] = []
        for i in 0..<visited.count {
            if(!visited[i]){
                res.append(i + 1)
            }
        }
        
        return res
    }
}

public class LC_2682_FindTheLosersOfTheCircularGame : Solution_2682 {
    public override init() {}
}
