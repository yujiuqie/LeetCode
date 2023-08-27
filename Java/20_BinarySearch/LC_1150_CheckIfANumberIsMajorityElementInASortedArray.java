
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left >> 1);

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left + n / 2 < n && nums[left + n / 2] == target;
    }
}