class Solution {
    public int deleteAndEarn(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int max = nums[0];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, num);
        }

        int[] dp = new int[max + 1];
        dp[1] = map.getOrDefault(1, 0) * 1;

        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * map.getOrDefault(i, 0));
        }

        return dp[max];
    }
}

public class LC_740_DeleteAndEarn {

}
