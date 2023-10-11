class Solution {
    func findLongestChain(_ pairs: [[Int]]) -> Int {
        let sortedPairs = pairs.sorted(by: { $0[0] < $1[0] })
        let n = sortedPairs.count
        var dp = Array(repeating: 1, count: n)
        var max = 1
        for i in 1..<n {
            for j in 0..<i {
                if sortedPairs[j][1] < sortedPairs[i][0] {
                    dp[i] = Swift.max(dp[i], dp[j] + 1)
                    max = Swift.max(max, dp[i])
                }
            }
        }
        return max
    }
}