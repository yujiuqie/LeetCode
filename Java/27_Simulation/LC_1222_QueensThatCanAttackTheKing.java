class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] directions = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 } };
        boolean[][] isQueen = new boolean[8][8];
        for (int[] q : queens) {
            isQueen[q[0]][q[1]] = true;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int[] d : directions) {
            int x = king[0] + d[0];
            int y = king[1] + d[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (isQueen[x][y]) {
                    res.add(List.of(x, y));
                    break;
                }

                x += d[0];
                y += d[1];
            }
        }

        return res;
    }
}

public class LC_1222_QueensThatCanAttackTheKing {

}
