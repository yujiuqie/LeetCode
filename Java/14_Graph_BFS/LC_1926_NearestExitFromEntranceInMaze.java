class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int start_x = entrance[0];
        int start_y = entrance[1];

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { start_x, start_y, 0 });

        maze[start_x][start_y] = '+';

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            if (!(point[0] == start_x && point[1] == start_y)
                    && (point[0] == 0 || point[0] == m - 1 || point[1] == 0 || point[1] == n - 1)) {
                return point[2];
            }

            for (int k = 0; k < dx.length; k++) {
                int x = point[0] + dx[k];
                int y = point[1] + dy[k];

                if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.') {
                    queue.offer(new int[] { x, y, point[2] + 1 });
                    maze[x][y] = '+';
                }
            }
        }

        return -1;
    }
}

public class LC_1926_NearestExitFromEntranceInMaze {

}
