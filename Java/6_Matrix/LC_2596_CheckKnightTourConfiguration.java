class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }

        int n = grid[0].length;
        int dst = n * n - 1;
        int[][] direction = {
                { -1, -2 }, { -2, -1 },
                { -2, 1 }, { -1, 2 },
                { 1, 2 }, { 2, 1 },
                { 2, -1 }, { 1, -2 }
        };

        return dfs(grid, direction, dst, 0, 0, 0);
    }

    private boolean dfs(int[][] grid, int[][] direction, int dst, int row, int col, int target) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }

        if (grid[row][col] != target) {
            return false;
        }

        if (target == dst) {
            return true;
        }

        for (int[] dir : direction) {
            if (dfs(grid, direction, dst, row + dir[0], col + dir[1], target + 1)) {
                return true;
            }
        }

        return false;
    }
}

public class LC_2596_CheckKnightTourConfiguration {

}
