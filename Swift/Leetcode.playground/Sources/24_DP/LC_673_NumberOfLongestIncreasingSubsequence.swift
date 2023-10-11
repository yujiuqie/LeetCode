class Solution {
    func findNumberOfLIS(_ nums: [Int]) -> Int {
        let n = nums.count
        var dp = Array(repeating: 1, count: n)
        var dp_m = Array(repeating: 1, count: n)
        var max = 1
        for i in 0..<n {
            for j in 0..<i {
                if nums[j] < nums[i] {
                    if dp[i] < dp[j] + 1 {
                        dp[i] = dp[j] + 1
                        dp_m[i] = dp_m[j]
                    } else if dp[i] == dp[j] + 1 {
                        dp_m[i] += dp_m[j]
                    }
                }
            }
            max = Swift.max(max, dp[i])
        }
        var res = 0
        for i in 0..<n {
            if dp[i] == max {
                res += dp_m[i]
            }
        }
        return res
    }
}