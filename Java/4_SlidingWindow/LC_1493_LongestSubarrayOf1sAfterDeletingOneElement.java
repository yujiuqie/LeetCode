class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int count = 0;
        int left = 0;
        int len = nums.length;
        for (int right = 0; right < len; right++) {
            if (nums[right] != 1) {
                count++;
                while (count == 2) {
                    if (nums[left] != 1) {
                        count--;
                    }
                    left++;
                }
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}

public class LC_1493_LongestSubarrayOf1sAfterDeletingOneElement {

}
