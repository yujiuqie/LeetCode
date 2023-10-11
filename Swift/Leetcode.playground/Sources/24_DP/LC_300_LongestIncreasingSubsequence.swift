class Solution {
    func lengthOfLIS(_ nums: [Int]) -> Int {
        let n = nums.count
        var dp = Array(repeating: 1, count: n)
        var max = 1
        for i in 0..<n {
            for j in 0..<i {
                if nums[j] < nums[i] {
                    dp[i] = Swift.max(dp[j] + 1, dp[i])
                    max = Swift.max(dp[i], max)
                }
            }
        }
        return max
    }
}