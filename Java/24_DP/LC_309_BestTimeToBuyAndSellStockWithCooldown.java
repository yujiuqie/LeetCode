class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = 0; // 不持有
        dp[0][1] = -prices[0]; // 持有
        dp[0][2] = 0; // 冷静期不持有

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]); // 不持有：因为前一天本来就不持有；因为前一天冷静期，所以不持有
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }

        return Math.max(dp[n - 1][0], dp[n - 1][2]);
    }
}

public class LC_309_BestTimeToBuyAndSellStockWithCooldown {

}
