class Solution {
    private int[][] directions = { { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -2, 1 },
            { -1, 2 } };

    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }

        // 访问数组：boolean[][] visited(二、三、四象限有负值，需特殊处理)
        boolean[][] visited = new boolean[601][601];

        Queue<int[]> deque = new LinkedList<>();

        deque.offer(new int[] { 0, 0 });
        visited[300][300] = true;

        int step = 0;
        while (!deque.isEmpty()) {

            step++;

            int size = deque.size();

            for (int i = 0; i < size; i++) {
                int[] cur = deque.poll();
                // 当前位置到目标位置的曼哈顿距离
                /**
                 * 额外小知识：曼哈顿距离
                 * 例如在平面上，坐标(x1,y1)的i点与坐标(x2,y2)的j点的曼哈顿距离为：
                 * d(i,j)=|X1-X2|+|Y1-Y2|.
                 */
                int currentDistance = getDistance(cur[0], cur[1], x, y);
                for (int[] direction : directions) {
                    int rowIndex = cur[0] + direction[0];
                    int colIndex = cur[1] + direction[1];
                    if (rowIndex == x && colIndex == y) {
                        return step;
                    }

                    if (visited[rowIndex + 300][colIndex + 300]) {
                        continue;
                    }

                    // 新到达的位置到目标位置的曼哈顿距离 小于 当前位置到目标位置的曼哈顿距离
                    int updateDistance = getDistance(rowIndex, colIndex, x, y);
                    if (updateDistance < currentDistance || step == 1) {
                        deque.offer(new int[] { rowIndex, colIndex });
                        visited[rowIndex + 300][colIndex + 300] = true;
                    }
                }
            }
        }
        return -1;
    }

    private int getDistance(int srcX, int srcY, int targetX, int targetY) {
        return Math.abs(srcX - targetX) + Math.abs(srcY - targetY);
    }
}

public class LC_1197_MinimumKnightMoves {

}
