
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int m = maze.length;
        int n = maze[0].length;
        
        boolean [][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        q.offer(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            // 看看碰得到
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }

            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];

                // 然后继续碰到墙停止
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }

                // 撞墙后返回上一个位置，如果没有访问到那就加进去
                x -= dir[0];
                y -= dir[1];

                if(!visited[x][y]) {
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        } 

        return false;
    }
}