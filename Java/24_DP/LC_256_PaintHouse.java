class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];

        for(int j = 0; j < 3; j++){
            dp[0][j] = costs[0][j];
        }

        for(int i = 1; i < n; i++){
            dp[i][0] = Math.min(dp[i - 1][1],dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0],dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0],dp[i - 1][1]) + costs[i][2];
        }

        return Math.min(Math.min(dp[n - 1][0],dp[n - 1][1]),dp[n - 1][2]);
    }
}