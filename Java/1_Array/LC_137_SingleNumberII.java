class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i = i + 3) {
            if (nums[i] != nums[i + 2]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}

public class LC_137_SingleNumberII {

}
