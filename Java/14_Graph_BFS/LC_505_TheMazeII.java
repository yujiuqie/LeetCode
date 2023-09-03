class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        int m = maze.length;
        int n = maze[0].length;

        int[][] distance = new int[m][n];

        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

        q.offer(start);
        distance[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];

                int dis = distance[cur[0]][cur[1]];

                // 然后继续碰到墙停止
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    dis += 1;
                }

                // 撞墙后返回上一个位置，如果没有访问到那就加进去
                x -= dir[0];
                y -= dir[1];

                if (distance[x][y] > dis) {
                    distance[x][y] = dis;
                    q.offer(new int[] { x, y });
                }
            }
        }

        return distance[destination[0]][destination[1]] != Integer.MAX_VALUE ? distance[destination[0]][destination[1]]
                : -1;
    }
}