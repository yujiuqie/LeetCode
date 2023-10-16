class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        int lbs = sum & (-sum);

        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & lbs) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[] { num1, num2 };
    }
}

public class LC_260_SingleNumberIII {

}
