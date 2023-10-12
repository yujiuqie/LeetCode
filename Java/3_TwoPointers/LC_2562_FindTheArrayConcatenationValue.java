class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        long sum = 0;
        StringBuilder sb;
        while (left < right) {
            sb = new StringBuilder();
            sb.append(nums[left++]);
            sb.append(nums[right--]);
            sum += Integer.parseInt(sb.toString());
        }

        sum += left == right ? nums[left] : 0;
        return sum;
    }
}

public class LC_2562_FindTheArrayConcatenationValue {

}
