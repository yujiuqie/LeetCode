class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
        }

        long res = 0;

        for (int i = 0; i < k; i++) {
            int max = pq.poll();
            res += max;
            pq.add((max + 2) / 3);
        }

        return res;
    }
}

public class LC_2530_MaximalScoreAfterApplyingKOperations {

}
