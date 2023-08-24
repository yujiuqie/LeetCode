class Solution {
    public int maxA(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i - 1] + 1;

            for(int j = 2; j + 2 < i; j++){
                dp[i] = Math.max(dp[i],dp[j] * (i - (j + 1)));
            }
        }
        return dp[n];
    }
}