class Solution {
    func longestSubsequence(_ arr: [Int], _ difference: Int) -> Int {
        var ans = 0
        var dp = [Int: Int]()
        for v in arr {
            dp[v] = (dp[v - difference] ?? 0) + 1
            ans = max(ans, dp[v]!)
        }
        return ans
    }
}