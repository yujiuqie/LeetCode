class Solution {
    public int giveGem(int[] gem, int[][] operations) {

        for (int[] operation : operations) {
            int x = operation[0];
            int y = operation[1];
            int number = gem[x] / 2;
            gem[x] -= number;
            gem[y] += number;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int number : gem) {
            min = Math.min(number, min);
            max = Math.max(number, max);
        }

        return max - min;
    }
}

public class LC_P_50_GemsSupply {

}
