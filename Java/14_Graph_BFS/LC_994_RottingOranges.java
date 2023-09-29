class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int time = 0;
        int fresh = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh += 1;
                }
                if (grid[i][j] == 2) {
                    queue.offer(i * n + j); // 二维转一维技巧
                }
            }
        }

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.pollFirst();
                int row = cur / n;
                int col = cur % n;
                for (int[] direction : directions) {
                    int nRow = row + direction[0];
                    int nCol = col + direction[1];

                    if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n || grid[nRow][nCol] != 1) {
                        continue;
                    }

                    grid[nRow][nCol] = 2;
                    queue.offer(nRow * n + nCol);
                    fresh -= 1;
                }
            }

            time += 1;
        }

        return fresh == 0 ? time : -1;
    }
}

public class LC_994_RottingOranges {

}
