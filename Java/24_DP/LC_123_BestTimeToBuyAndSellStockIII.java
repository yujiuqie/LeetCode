class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // dp 表示到当前这一天的操作状态
        int[][] dp = new int[n][5];
        dp[0][0] = 0; // 当天无操作
        dp[0][1] = -prices[0]; // 当天第一次买入
        dp[0][2] = 0; // 当天第一次卖出
        dp[0][3] = -prices[0]; // 当天第二次买入
        dp[0][4] = 0; // 当天第二次卖出

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[n - 1][4];
    }
}

public class LC_123_BestTimeToBuyAndSellStockIII {

}
