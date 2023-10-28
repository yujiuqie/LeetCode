class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i : gifts) {
            queue.offer(i);
        }
        for (int i = 1; i <= k; i++) {
            int temp = queue.poll();
            temp = (int) Math.sqrt(temp);
            queue.offer(temp);
        }
        long ans = 0;
        for (int i : queue) {
            ans += i;
        }
        return ans;
    }
}

public class LC_2558_TakeGiftsFromTheRichestPile {

}
