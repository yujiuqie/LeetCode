class Solution {

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0)
            return;
        int n = rooms[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == 0) {
                    q.add(new int[] { row, col });
                }
            }
        }

        int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : dirs) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }
    }
}