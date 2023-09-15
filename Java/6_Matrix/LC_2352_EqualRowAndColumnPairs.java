class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] grid2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid2[i][j] = grid[j][i]; // 转置矩阵
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // 然后第一个矩阵的第一行和转置矩阵的每一行比较
                if (Arrays.equals(grid[i], grid2[j])) {
                    res++;
                }
            }
        }

        return res;
    }
}

public class LC_2352_EqualRowAndColumnPairs {

}
