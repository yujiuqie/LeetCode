class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = 1l * ranks[0] * cars * cars;
        while (left < right) {
            long mid = left + right >> 1;
            if (check(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean check(int[] ranks, int cars, long t) {
        long count = 0;
        for (int r : ranks) {
            count += (long) Math.sqrt(t / r); // r * n * n = t => n = sqrt(t / r)
        }
        return count >= cars;
    }
}

public class LC_2594_MinimumTimeToRepairCars {

}
