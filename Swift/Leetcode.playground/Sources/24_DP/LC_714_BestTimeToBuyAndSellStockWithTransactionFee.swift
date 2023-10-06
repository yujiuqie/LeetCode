class Solution {
    func maxProfit(_ prices: [Int], _ fee: Int) -> Int {
        let n = prices.count
        var dp = Array(repeating: Array(repeating: 0, count: 2), count: n)
        dp[0][0] = 0 //不持有
        dp[0][1] = -prices[0]   //持有

        for i in 1..<n{
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee)
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        }

        return dp[n - 1][0]
    }
}