class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            // 向上取整写法，计算每个怪物到达时间
            arrivalTimes[i] = (dist[i] - 1) / speed[i] + 1;
        }

        // 时间复杂度 O(logN)
        Arrays.sort(arrivalTimes);

        // 贪心的思路:将怪物的到达时间排序，先消灭到达时间早的怪物
        for (int i = 0; i < n; i++) {

            // 第一次出现到达时间小于等于攻击时间，表示有怪物到达，游戏结束
            if (arrivalTimes[i] <= i) {
                return i;
            }
        }

        // 如果全部到达时间均小于攻击时间，表示全部掉灭完
        return n;
    }
}

public class LC_1921_EliminateMaximumNumberOfMonsters {

}
