/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * // Compares the sum of arr[l..r] with the sum of arr[x..y]
 * // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 * // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 * // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 * public int compareSub(int l, int r, int x, int y) {}
 *
 * // Returns the length of the array
 * public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int len = reader.length();
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int is_odd = right - left + 1;
            if (is_odd % 2 == 1) {
                // 奇数个数情况，比较左右两部分和的大小，注意要将那个唯一数作为剔除值处理
                int res = reader.compareSub(left, mid - 1, mid + 1, right);
                if (res == 0) {
                    // 左半部分与右半部分相等，则 mid 为那个唯一的数
                    return mid;
                } else if (res == 1) {
                    // 左半部分大于右半部分，说明那个唯一值在左边
                    right = mid - 1;
                } else {
                    // 左半部分小于右半部分，说明那个唯一值在右边
                    left = mid + 1;
                }
            } else {
                // 偶数个数情况，比较左右两部分和的大小，注意那个唯一数没法被剔除值处理，因此不会存在两边相等的情况
                int res = reader.compareSub(left, mid, mid + 1, right);
                if (res == 1) {
                    // 左半部分大于右半部分，说明那个唯一值在左边
                    right = mid;
                } else {
                    // 左半部分小于右半部分，说明那个唯一值在右边
                    left = mid + 1;
                }
            }
        }

        return left;
    }
}