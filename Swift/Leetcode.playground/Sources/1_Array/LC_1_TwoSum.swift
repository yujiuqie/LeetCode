import Foundation

public class Solution_1 {
    public func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var map = [Int : Int]()
        for (i,num) in nums.enumerated() {
            if map.keys.contains(target - num){
                return [i,map[target - num]!]
            }
            map[num] = i
        }
        
        return []
    }
}

public class LC_1_TwoSum : Solution_1 {
    public override init() {}
}
