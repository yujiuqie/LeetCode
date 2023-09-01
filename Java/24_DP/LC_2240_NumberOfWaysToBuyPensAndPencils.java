class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {

        // dp[i]表示：总数为 i 的金额，能够购买的最多方案数为 dp[i]
        long[] dp = new long[total + 1];

        int[] items = new int[] { cost1, cost2 };

        // 完全背包最多组合问题常规模板
        for (int item : items) {
            for (int i = item; i <= total; i++) {
                if (i >= item) {
                    dp[i] += dp[i - item] + 1;
                }
            }
        }

        // 没法购买也算一种方案，需要加上 1
        return dp[total] + 1;
    }
}