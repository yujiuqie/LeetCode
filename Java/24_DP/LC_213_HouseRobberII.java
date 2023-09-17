class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int max_1 = rob(nums, 0, n - 1);
        int max_2 = rob(nums, 1, n);
        return Math.max(max_1, max_2);
    }

    private int rob(int[] nums, int start, int end) {
        if (end == start) {
            return nums[start];
        }
        int[] dp = new int[end - start + 1];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[end - 1];
    }
}

public class LC_213_HouseRobberII {

}
