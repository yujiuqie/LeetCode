class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int num_0 = 10;
        int min_1 = 10;
        int min_2 = 10;

        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums1) {
            min_1 = Math.min(min_1, num);
            set.add(num);
        }

        for (int num : nums2) {
            min_2 = Math.min(min_2, num);
            if (set.contains(num)) {
                num_0 = Math.min(num_0, num);
            }
        }

        if (num_0 != 10) {
            return num_0;
        }

        return Math.min(min_1 * 10 + min_2, min_2 * 10 + min_1);
    }
}

public class LC_2605_FormSmallestNumberFromTwoDigitArrays {

}
