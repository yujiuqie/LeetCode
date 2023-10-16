class Solution {
    func avoidFlood(_ rains: [Int]) -> [Int] {
        var sunny = Set<Int>()
        var lakeLastRain = [Int: Int]()
        let n = rains.count
        var ans = Array(repeating: 1, count: n)
        
        for i in 0..<n {
            if rains[i] == 0 {
                sunny.insert(i)
            } else {
                ans[i] = -1
                if let lastRain = lakeLastRain[rains[i]] {
                    if let noRain = sunny.first(where: { $0 >= lastRain }) {
                        ans[noRain] = rains[i]
                        sunny.remove(noRain)
                    } else {
                        return []
                    }
                }
                lakeLastRain[rains[i]] = i
            }
        }
        
        return ans
    }
}