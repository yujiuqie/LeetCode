class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] dp_m = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            dp_m[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        dp_m[i] = dp_m[j];
                    } else if (dp[i] == dp[j] + 1) {
                        dp_m[i] += dp_m[j];
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                res += dp_m[i];
            }
        }

        return res;
    }
}

public class LC_673_NumberOfLongestIncreasingSubsequence {

}
