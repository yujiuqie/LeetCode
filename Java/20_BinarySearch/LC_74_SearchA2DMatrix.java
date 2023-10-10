class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {

            int mid = left + right + 1 >> 1;
            int mid_num = matrix[mid / n][mid % n];

            if (mid_num < target) {
                left = mid + 1;
            } else if (mid_num > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

public class LC_74_SearchA2DMatrix {

}
