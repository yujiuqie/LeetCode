class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int len = nums.length;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;

        for (int i = k; i < len; i++) {
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(sum, max);
        }

        return 1.0 * max / k;
    }
}

public class LC_643_MaximumAverageSubarrayI {

}
