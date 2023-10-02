class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        let n = prices.count
        var dp = Array(repeating: Array(repeating: 0, count: 2), count: n)
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for i in 1..<n {
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        }
        return dp[n - 1][0]
    }
}

// 贪心解法
// class Solution {
//     func maxProfit(_ prices: [Int]) -> Int {
//         let n = prices.count
//         var res = 0
//         for i in 1..<n {
//             res += max(0,prices[i] - prices[i - 1])
//         }
//         return res
//     }
// }