class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        let n = prices.count
        var dp = Array(repeating: Array(repeating: 0, count: 2), count: n)
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for i in 1..<n {
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], -prices[i])
        }
        return dp[n - 1][0]
    }
}

//贪心解法
// class Solution {
//     func maxProfit(_ prices: [Int]) -> Int {
//         var res = 0 
//         var temp = Int.max
//         for i in 0..<prices.count {
//             // 努力寻找最小值
//             temp = min(temp, prices[i])
//             res = max(res, prices[i] - temp)
//         }
//         return res 
//     }
// }