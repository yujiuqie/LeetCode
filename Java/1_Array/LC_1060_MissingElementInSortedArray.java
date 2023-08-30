class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;

        // 如果 k 大于最后一个缺失的元素个数
        if (k > missing(n - 1, nums)) {
            return missingK(n - 1, nums, k);
        }

        int idx = 1;

        // 目标 idx ： missing(idx - 1) < k <= missing(idx)
        while (missing(idx, nums) < k) {
            idx++;
        }

        return missingK(idx - 1, nums, k);
    }

    // 获取从第 0 个元素开始，到目标索引所对应的值的缺失的元素个数
    private int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }

    // 获取第 K 个缺失的元素
    private int missingK(int idx, int[] nums, int k) {
        return nums[idx] + k - missing(idx, nums);
    }
}

public class LC_1060_MissingElementInSortedArray {

}
